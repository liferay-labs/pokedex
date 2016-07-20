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

package com.liferay.pokedex.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Pokemon service. Represents a row in the &quot;Pokemon&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PokemonModel
 * @see com.liferay.pokedex.model.impl.PokemonImpl
 * @see com.liferay.pokedex.model.impl.PokemonModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.pokedex.model.impl.PokemonImpl")
@ProviderType
public interface Pokemon extends PokemonModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.pokedex.model.impl.PokemonImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Pokemon, Long> ID_ACCESSOR = new Accessor<Pokemon, Long>() {
			@Override
			public Long get(Pokemon pokemon) {
				return pokemon.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Pokemon> getTypeClass() {
				return Pokemon.class;
			}
		};

	public java.lang.String getName();
}