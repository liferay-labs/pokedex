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
import com.datastax.driver.core.querybuilder.Update;
import com.liferay.pokedex.cassandra.persistence.BasePersistence;
import com.liferay.pokedex.cassandra.session.SessionProvider;
import com.liferay.pokedex.nosql.model.Pokemon;
import com.liferay.pokedex.nosql.service.presistence.PokemonPersistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = PokemonPersistence.class)
public class PokemonPersistenceImpl extends BasePersistence<Pokemon>
	implements PokemonPersistence {

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

	public Pokemon create() {
 		Pokemon pokemon = new Pokemon();

		pokemon.setNew(true);

		return pokemon;
	}

	public List<Pokemon> getPokemons() {
		List<Pokemon> pokemons = new ArrayList<Pokemon>();

		Select.Selection selection = QueryBuilder.select();

		Select select = selection.from(getTableName());

		select.allowFiltering();

		ResultSet resultSet = session.execute(select);

		Iterator<Row> iterator = resultSet.iterator();

		while (iterator.hasNext()) {
			Row row = iterator.next();

			pokemons.add(getEntity(row));
		}

		return pokemons;
	}

	public List<Pokemon> getPokemons(long groupId) {
		List<Pokemon> pokemons = new ArrayList<Pokemon>();

		Select.Selection selection = QueryBuilder.select();

		Select select = selection.from(getTableName());

		select.allowFiltering();

		select.where(QueryBuilder.eq("groupId", groupId));

		ResultSet resultSet = session.execute(select);

		Iterator<Row> iterator = resultSet.iterator();

		while (iterator.hasNext()) {
			Row row = iterator.next();

			pokemons.add(getEntity(row));
		}

		return pokemons;
	}

	public int getPokemonsCount() {
		Select.Selection selection = QueryBuilder.select();

		Select select = selection.from(getTableName());

		select.allowFiltering();

		return session.execute(select).all().size();
	}

	public int getPokemonsCount(long groupId) {
		Select.Selection selection = QueryBuilder.select();

		Select select = selection.from(getTableName());

		select.where(QueryBuilder.eq("groupId", groupId));

		return session.execute(select).all().size();
	}

	public String getPrimaryKey() {
		return _PRIMARY_KEY;
	}

	public String getTableName() {
		return _TABLE_NAME;
	}

	public Pokemon update(Pokemon pokemon) {
		Statement statement = null;

		if (pokemon.isNew()) {
			Insert insert = QueryBuilder.insertInto(getTableName());

			insert.value("pokemonId", pokemon.getPokemonId());
			insert.value("originalName", pokemon.getOriginalName());
			insert.value("backImageURL", pokemon.getBackImageURL());
			insert.value("backShinyImageURL", pokemon.getBackShinyImageURL());
			insert.value("companyId", pokemon.getCompanyId());
			insert.value("createDate", pokemon.getCreateDate());
			insert.value("customName", pokemon.getCustomName());
			insert.value("description", pokemon.getDescription());
			insert.value("frontImageURL", pokemon.getFrontImageURL());
			insert.value("frontShinyImageURL", pokemon.getFrontShinyImageURL());
			insert.value("groupId", pokemon.getGroupId());
			insert.value("modifiedDate", pokemon.getModifiedDate());
			insert.value("order_", pokemon.getOrder());
			insert.value("type_", pokemon.getType());
			insert.value("userId", pokemon.getUserId());
			insert.value("userName", pokemon.getUserName());
			insert.value("uuid", pokemon.getUuid());

			statement = insert;
		}
		else {
			Update update = QueryBuilder.update(getTableName());

			Update.Assignments assignments = update.with();

			assignments.and(
				QueryBuilder.set("originalName", pokemon.getOriginalName()));
			assignments.and(
				QueryBuilder.set("backImageURL", pokemon.getBackImageURL()));
			assignments.and(
				QueryBuilder.set(
					"backShinyImageURL", pokemon.getBackShinyImageURL()));
			assignments.and(
				QueryBuilder.set("companyId", pokemon.getCompanyId()));
			assignments.and(
				QueryBuilder.set("createDate", pokemon.getCreateDate()));
			assignments.and(
				QueryBuilder.set("customName", pokemon.getCustomName()));
			assignments.and(
				QueryBuilder.set("description", pokemon.getDescription()));
			assignments.and(
				QueryBuilder.set("frontImageURL", pokemon.getFrontImageURL()));
			assignments.and(
				QueryBuilder.set(
					"frontShinyImageURL", pokemon.getFrontShinyImageURL()));
			assignments.and(
				QueryBuilder.set("groupId", pokemon.getGroupId()));
			assignments.and(
				QueryBuilder.set("modifiedDate", pokemon.getModifiedDate()));
			assignments.and(
				QueryBuilder.set("order_", pokemon.getOrder()));
			assignments.and(
				QueryBuilder.set("type_", pokemon.getType()));
			assignments.and(
				QueryBuilder.set("userId", pokemon.getUserId()));
			assignments.and(
				QueryBuilder.set("userName", pokemon.getUserName()));
			assignments.and(
				QueryBuilder.set("uuid", pokemon.getUuid()));

			update.where(QueryBuilder.eq("pokemonId", pokemon.getPokemonId()));

			statement = update;
		}

		session.execute(statement);

		pokemon.setNew(false);

		return pokemon;
	}

	@Reference(unbind = "-")
	protected void setSessionProvider(SessionProvider sessionProvider) {
		_sessionProvider = sessionProvider;
	}

	protected Pokemon getEntity(Row row) {
		Pokemon pokemon = new Pokemon();

		pokemon.setPokemonId(row.getLong("pokemonId"));
		pokemon.setOriginalName(row.getString("originalName"));
		pokemon.setBackImageURL(row.getString("backImageURL"));
		pokemon.setBackShinyImageURL(row.getString("backShinyImageURL"));
		pokemon.setCompanyId(row.getLong("companyId"));
		pokemon.setCreateDate(
			new Date(row.getTimestamp("createDate").getTime()));
		pokemon.setCustomName(row.getString("customName"));
		pokemon.setDescription(row.getString("description"));
		pokemon.setFrontImageURL(row.getString("frontImageURL"));
		pokemon.setFrontShinyImageURL(row.getString("frontShinyImageURL"));
		pokemon.setGroupId(row.getLong("groupId"));
		pokemon.setModifiedDate(
			new Date(row.getTimestamp("modifiedDate").getTime()));
		pokemon.setOrder(row.getLong("order_"));
		pokemon.setType(row.getString("type_"));
		pokemon.setUserId(row.getLong("userId"));
		pokemon.setUserName(row.getString("userName"));
		pokemon.setUuid(row.getString("uuid"));

		return pokemon;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PokemonPersistenceImpl.class);

	private static final String _PRIMARY_KEY = "pokemonId";
	private static final String _TABLE_NAME = "Pokemon";

	private SessionProvider _sessionProvider;
}
