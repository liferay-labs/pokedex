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

package com.liferay.pokedex.nosql.service;

import com.liferay.pokedex.nosql.model.PokemonCache;
import com.liferay.portal.kernel.json.JSONArray;

import java.util.Date;

/**
 * @author Pavel Savinov
 */
public interface PokemonCacheService {

	public PokemonCache addPokemonCache(
		JSONArray pokemonsArray, int start, int end);

	public PokemonCache fetchNearestPokemonCache(Date date, int start, int end);
}
