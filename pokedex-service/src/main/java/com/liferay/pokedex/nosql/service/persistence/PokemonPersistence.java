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

package com.liferay.pokedex.nosql.service.persistence;

import com.liferay.pokedex.nosql.model.Pokemon;

import java.util.List;

/**
 * @author Pavel Savinov
 */
public interface PokemonPersistence {

	public Pokemon create();

	public void delete(long id);

	public Pokemon fetchById(long id);

	public List<Pokemon> getPokemons();

	public List<Pokemon> getPokemons(long groupId);

	public int getPokemonsCount();

	public int getPokemonsCount(long groupId);

	public Pokemon update(Pokemon pokemon);

}
