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

package com.liferay.pokedex.nosql.model;

import com.liferay.pokedex.cassandra.model.BaseModel;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.Date;
import java.util.List;

/**
 * @author Pavel Savinov
 */
public class PokemonCache extends BaseModel {

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		this._id = id;
	}

	public Date getCacheDate() {
		return _cacheDate;
	}

	public void setCacheDate(Date cacheDate) {
		_cacheDate = cacheDate;
	}

	public List<JSONObject> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<JSONObject> pokemons) {
		this.pokemons = pokemons;
	}

	public int getEnd() {
		return _end;
	}

	public void setEnd(int end) {
		_end = end;
	}

	public int getStart() {
		return _start;
	}

	public void setStart(int start) {
		_start = start;
	}

	private int _end;
	private long _id;
	private Date _cacheDate;
	private List<JSONObject> pokemons;
	private int _start;

}
