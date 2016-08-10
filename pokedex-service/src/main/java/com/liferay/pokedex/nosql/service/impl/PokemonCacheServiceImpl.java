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

package com.liferay.pokedex.nosql.service.impl;

import com.liferay.pokedex.nosql.model.PokemonCache;
import com.liferay.pokedex.nosql.service.PokemonCacheService;
import com.liferay.pokedex.nosql.service.presistence.PokemonCachePersistence;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = PokemonCacheService.class)
public class PokemonCacheServiceImpl implements PokemonCacheService {

	@Reference
	protected void setPokemonCachePersistence(
		PokemonCachePersistence pokemonCachePersistence) {

		_pokemonCachePersistence = pokemonCachePersistence;
	}

	private PokemonCachePersistence _pokemonCachePersistence;

	public PokemonCache addPokemonCache(
		JSONArray pokemonsArray, int start, int end) {

		PokemonCache pokemonCache = _pokemonCachePersistence.create();

		pokemonCache.setCacheDate(new Date());
		pokemonCache.setStart(start);
		pokemonCache.setEnd(end);

		List<JSONObject> pokemons = new ArrayList<JSONObject>();

		Iterator<JSONObject> iterator = pokemonsArray.iterator();

		while (iterator.hasNext()) {
			pokemons.add(iterator.next());
		}

		pokemonCache.setPokemons(pokemons);

		_pokemonCachePersistence.update(pokemonCache);

		return pokemonCache;
	}

	public PokemonCache fetchNearestPokemonCache(
		Date date, int start, int end) {

		return _pokemonCachePersistence.fetchNearestPokemonCache(
			date, start, end);
	}
}
