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

import com.datastax.driver.core.TypeCodec;
import com.datastax.driver.core.UDTValue;
import com.datastax.driver.core.UserType;
import com.datastax.driver.extras.codecs.MappingCodec;

/**
 * @author Pavel Savinov
 */
public class PokemonCodec extends MappingCodec<PokemonUserType, UDTValue> {

	public PokemonCodec(
		TypeCodec<UDTValue> innerCodec, Class<PokemonUserType> javaType) {

		super(innerCodec, javaType);
		_userType = (UserType) innerCodec.getCqlType();
	}

	@Override
	protected PokemonUserType deserialize(UDTValue value) {
		return value == null ? null : new PokemonUserType(
			value.getString("backImageURL"),
			value.getString("backShinyImageURL"),
			value.getString("description"),
			value.getString("frontImageURL"),
			value.getString("frontShinyImageURL"),value.getString("name"),
			value.getLong("order_"), value.getString("type_"));
	}

	@Override
	protected UDTValue serialize(PokemonUserType pokemonUserType) {
		UDTValue value = _userType.newValue();

		value.setString("backImageURL", pokemonUserType.getBackImageURL());
		value.setString(
			"backShinyImageURL", pokemonUserType.getBackShinyImageURL());
		value.setString("description", pokemonUserType.getDescription());
		value.setString("frontImageURL", pokemonUserType.getFrontImageURL());
		value.setString(
			"frontShinyImageURL", pokemonUserType.getFrontShinyImageURL());
		value.setString("name", pokemonUserType.getName());
		value.setLong("order_", pokemonUserType.getOrder());
		value.setString("type_", pokemonUserType.getType());

		return pokemonUserType == null ? null : value;
	}

	private final UserType _userType;
}