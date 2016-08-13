/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p/>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p/>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.pokedex.nosql.service.persistence.impl;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.liferay.pokedex.cassandra.codec.PokemonUserType;
import com.liferay.pokedex.cassandra.persistence.BasePersistence;
import com.liferay.pokedex.cassandra.session.SessionProvider;
import com.liferay.pokedex.nosql.model.PokemonCache;
import com.liferay.pokedex.nosql.service.persistence.PokemonCachePersistence;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = PokemonCachePersistence.class)
public class PokemonCachePersistenceImpl extends BasePersistence<PokemonCache>
	implements PokemonCachePersistence {

	@Activate
	protected void activate() throws Exception {
		if (session == null) {
			try {
				setSession(_sessionProvider.getSession());
			}
			catch (Exception e) {
				_log.error("Error connecting to Cassandra", e);
			}
		}
	}

	public PokemonCache create() {
		PokemonCache pokemonCache = new PokemonCache();

		pokemonCache.setNew(true);

		return pokemonCache;
	}

	public PokemonCache fetchNearestPokemonCache(
		Date date, int start, int end) {

		Select.Selection selection = QueryBuilder.select();

		Select select = selection.from(getTableName());

		select.allowFiltering();

		select.where(QueryBuilder.eq("start_", start));
		select.where(QueryBuilder.eq("end_", end));
		select.where(QueryBuilder.lte("cacheDate", date));
		select.limit(1);

		ResultSet resultSet = session.execute(select);

		Iterator<Row> iterator = resultSet.iterator();

		if (iterator.hasNext()) {
			Row row = iterator.next();

			return getEntity(row);
		}

		return null;
	}

	protected PokemonCache getEntity(Row row) {
		PokemonCache pokemonCache = new PokemonCache();

		pokemonCache.setCacheDate(
			new Date(row.getTimestamp("cacheDate").getTime()));
		pokemonCache.setEnd(row.getInt("end_"));
		pokemonCache.setId(row.getLong("id"));
		pokemonCache.setStart(row.getInt("start_"));

		List<PokemonUserType> pokemonUserTypes =
			row.getList("pokemons", PokemonUserType.class);

		List<JSONObject> pokemons = new ArrayList<JSONObject>();

		for (PokemonUserType pokemonUserType : pokemonUserTypes) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put("backImageURL", pokemonUserType.getBackImageURL());
			jsonObject.put(
				"backShinyImageURL", pokemonUserType.getBackShinyImageURL());
			jsonObject.put("description", pokemonUserType.getDescription());
			jsonObject.put("frontImageURL", pokemonUserType.getFrontImageURL());
			jsonObject.put(
				"frontShinyImageURL", pokemonUserType.getFrontShinyImageURL());
			jsonObject.put("name", pokemonUserType.getName());
			jsonObject.put("order", pokemonUserType.getOrder());
			jsonObject.put("type", pokemonUserType.getType());

			pokemons.add(jsonObject);
		}

		pokemonCache.setPokemons(pokemons);

		return pokemonCache;
	}

	public String getPrimaryKey() {
		return _PRIMARY_KEY;
	}

	public String getTableName() {
		return _TABLE_NAME;
	}

	public PokemonCache update(PokemonCache entity) {
		Statement statement = null;

		if (entity.isNew()) {
			Insert insert = QueryBuilder.insertInto(getTableName());

			insert.value("cacheDate", entity.getCacheDate());
			insert.value("end_", entity.getEnd());
			insert.value("id", entity.getId());
			insert.value("start_", entity.getStart());

			try {
				insert.value(
					"pokemons", _convertPokemons(entity.getPokemons()));
			}
			catch (Exception e) {
				_log.error(e, e);

				return null;
			}

			insert.using(QueryBuilder.ttl(POKEMON_CACHE_TTL));

			statement = insert;
		}

		session.execute(statement);

		entity.setNew(false);

		return entity;
	}

	private List<PokemonUserType> _convertPokemons(
		List<JSONObject> jsonObjects) throws Exception {

		List<PokemonUserType> pokemonMapsList =
			new ArrayList<PokemonUserType>();

		for (Object object : jsonObjects) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
				object.toString());

			PokemonUserType pokemonUserType = new PokemonUserType(
				jsonObject.getString("backImageURL"),
				jsonObject.getString("backShinyImageURL"),
				jsonObject.getString("description"),
				jsonObject.getString("frontImageURL"),
				jsonObject.getString("frontShinyImageURL"),
				jsonObject.getString("name"),
				jsonObject.getLong("order"),jsonObject.getString("type"));

			pokemonMapsList.add(pokemonUserType);
		}

		return pokemonMapsList;
	}

	@Reference(unbind = "-")
	protected void setSessionProvider(SessionProvider sessionProvider) {
		_sessionProvider = sessionProvider;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PokemonPersistenceImpl.class);

	private static final String _PRIMARY_KEY = "id";
	private static final String _TABLE_NAME = "PokemonCache";

	private SessionProvider _sessionProvider;

}
