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

package com.liferay.pokedex.cassandra.codec;

/**
 * @author Pavel Savinov
 */
public class PokemonUserType {

	public PokemonUserType(
		String backImageURL, String backShinyImageURL, String description,
		String frontImageURL, String frontShinyImageURL, String name,
		long order, String type) {

		_backImageURL = backImageURL;
		_backShinyImageURL = backShinyImageURL;
		_description = description;
		_frontImageURL = frontImageURL;
		_frontShinyImageURL = frontShinyImageURL;
		_name = name;
		_order = order;
		_type = type;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public long getOrder() {
		return _order;
	}

	public void setOrder(long order) {
		_order = order;
	}

	public String getFrontImageURL() {
		return _frontImageURL;
	}

	public void setFrontImageURL(String frontImageURL) {
		_frontImageURL = frontImageURL;
	}

	public String getFrontShinyImageURL() {
		return _frontShinyImageURL;
	}

	public void setFrontShinyImageURL(String frontShinyImageURL) {
		_frontShinyImageURL = frontShinyImageURL;
	}

	public String getBackImageURL() {
		return _backImageURL;
	}

	public void setBackImageURL(String backImageURL) {
		_backImageURL = backImageURL;
	}

	public String getBackShinyImageURL() {
		return _backShinyImageURL;
	}

	public void setBackShinyImageURL(String backShinyImageURL) {
		_backShinyImageURL = backShinyImageURL;
	}

	private String _backImageURL;
	private String _backShinyImageURL;
	private String _description;
	private String _frontImageURL;
	private String _frontShinyImageURL;
	private String _name;
	private long _order;
	private String _type;



}
