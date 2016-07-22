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

package com.liferay.pokedex.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.pokedex.model.Pokemon;
import com.liferay.pokedex.service.base.PokemonLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

/**
 * The implementation of the pokemon local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.pokedex.service.PokemonLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Julio Camarero
 * @see PokemonLocalServiceBaseImpl
 * @see com.liferay.pokedex.service.PokemonLocalServiceUtil
 */
@ProviderType
public class PokemonLocalServiceImpl extends PokemonLocalServiceBaseImpl {

	@Override
	public Pokemon addPokemon(
			String originalName, String customName, String description,
			String type, long order, String frontImageURL,
			String frontShinyImageURL, String backImageURL,
			String backShinyImageURL, ServiceContext serviceContext)
		throws PortalException {

		// Entry

		User user = userPersistence.findByPrimaryKey(
			serviceContext.getUserId());
		long groupId = user.getGroupId();

		long id = counterLocalService.increment();

		Pokemon pokemon = pokemonPersistence.create(id);

		pokemon.setUuid(serviceContext.getUuid());
		pokemon.setGroupId(groupId);
		pokemon.setCompanyId(user.getCompanyId());
		pokemon.setUserId(user.getUserId());
		pokemon.setUserName(user.getFullName());
		pokemon.setOriginalName(originalName);
		pokemon.setCustomName(customName);
		pokemon.setDescription(description);
		pokemon.setType(type);
		pokemon.setOrder(order);
		pokemon.setCreateDate(serviceContext.getCreateDate());
		pokemon.setModifiedDate(serviceContext.getModifiedDate());
		pokemon.setFrontImageURL(frontImageURL);
		pokemon.setFrontShinyImageURL(frontShinyImageURL);
		pokemon.setBackImageURL(backImageURL);
		pokemon.setBackShinyImageURL(backShinyImageURL);

		return pokemonPersistence.update(pokemon);
	}

	@Override
	public Pokemon deletePokemon(long id, ServiceContext serviceContext)
		throws PortalException {

		Pokemon pokemon = pokemonPersistence.findByPrimaryKey(id);

		return pokemonPersistence.remove(pokemon);
	}

	@Override
	public List<Pokemon> getPokemons(long groupId) {
		return pokemonPersistence.findByGroupId(groupId);
	}

	@Override
	public Pokemon updatePokemon(
			long id, String customName, String description,
			ServiceContext serviceContext)
		throws PortalException {

		// Entry

		User user = userPersistence.findByPrimaryKey(
			serviceContext.getUserId());
		long groupId = serviceContext.getScopeGroupId();

		Pokemon pokemon = pokemonPersistence.findByPrimaryKey(id);

		pokemon.setCustomName(customName);
		pokemon.setDescription(description);
		pokemon.setModifiedDate(serviceContext.getModifiedDate());

		return pokemonPersistence.update(pokemon);
	}

}