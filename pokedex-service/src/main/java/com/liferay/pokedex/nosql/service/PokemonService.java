/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.pokedex.nosql.service;

import com.liferay.pokedex.nosql.model.Pokemon;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

/**
 * @author Pavel Savinov
 */
public interface PokemonService {

	public Pokemon addPokemon(
		java.lang.String originalName, java.lang.String customName,
		java.lang.String description, java.lang.String type, long order,
		java.lang.String frontImageURL, java.lang.String frontShinyImageURL,
		java.lang.String backImageURL, java.lang.String backShinyImageURL,
		ServiceContext serviceContext);

	public Pokemon deletePokemon(long pokemonId);

	public List<Pokemon> getPokemons();

	public List<Pokemon> getPokemons(long groupId);

	public int getPokemonsCount();

	public int getPokemonsCount(long groupId);

	public Pokemon fetchPokemon(long pokemonId);

	public Pokemon updatePokemon(
		long id, java.lang.String customName, java.lang.String description,
		ServiceContext serviceContext);

}
