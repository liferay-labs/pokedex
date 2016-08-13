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

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.pokedex.nosql.model.Pokemon;
import com.liferay.pokedex.nosql.service.PokemonService;
import com.liferay.pokedex.nosql.service.persistence.PokemonPersistence;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = PokemonService.class)
public class PokemonServiceImpl implements PokemonService {

	public Pokemon addPokemon(
		String originalName, String customName, String description, String type,
		long order, String frontImageURL, String frontShinyImageURL,
		String backImageURL, String backShinyImageURL,
		ServiceContext serviceContext) {

		Pokemon pokemon = _pokemonPersistence.create();

		pokemon.setPokemonId(_counterLocalService.increment());

		Date now = new Date();

		pokemon.setOriginalName(originalName);
		pokemon.setCustomName(customName);
		pokemon.setDescription(description);
		pokemon.setType(type);
		pokemon.setOrder(order);
		pokemon.setFrontImageURL(frontImageURL);
		pokemon.setFrontShinyImageURL(frontShinyImageURL);
		pokemon.setBackImageURL(backImageURL);
		pokemon.setBackShinyImageURL(backShinyImageURL);

		User user = _userLocalService.fetchUser(serviceContext.getUserId());

		String userName = StringPool.BLANK;
		long groupId = serviceContext.getScopeGroupId();

		if (user != null) {
			userName = user.getFullName();
			groupId = user.getGroupId();
		}

		pokemon.setUuid(serviceContext.getUuid());
		pokemon.setUserId(serviceContext.getUserId());
		pokemon.setCompanyId(serviceContext.getCompanyId());
		pokemon.setGroupId(groupId);
		pokemon.setCreateDate(serviceContext.getCreateDate(now));
		pokemon.setModifiedDate(serviceContext.getModifiedDate(now));
		pokemon.setUserName(userName);

		_pokemonPersistence.update(pokemon);

		return pokemon;
	}

	public Pokemon deletePokemon(long pokemonId) {
		Pokemon pokemon = _pokemonPersistence.fetchById(pokemonId);

		if (pokemon != null) {
			_pokemonPersistence.delete(pokemonId);
		}

		return pokemon;
	}

	public List<Pokemon> getPokemons() {
		return _pokemonPersistence.getPokemons();
	}

	public List<Pokemon> getPokemons(long groupId) {
		return _pokemonPersistence.getPokemons(groupId);
	}

	public int getPokemonsCount() {
		return _pokemonPersistence.getPokemonsCount();
	}

	public int getPokemonsCount(long groupId) {
		return _pokemonPersistence.getPokemonsCount(groupId);
	}

	public Pokemon fetchPokemon(long pokemonId) {
		return _pokemonPersistence.fetchById(pokemonId);
	}

	public Pokemon updatePokemon(
		long id, String customName, String description,
		ServiceContext serviceContext) {

		Pokemon pokemon = _pokemonPersistence.fetchById(id);

		pokemon.setCustomName(customName);
		pokemon.setDescription(description);

		Date now = new Date();

		pokemon.setModifiedDate(serviceContext.getModifiedDate(now));

		_pokemonPersistence.update(pokemon);

		return pokemon;
	}

	@Reference(unbind = "-")
	protected void setCounterLocalService(
		CounterLocalService counterLocalService) {

		_counterLocalService = counterLocalService;
	}

	@Reference(unbind = "-")
	protected void setPokemonPersistence(
		PokemonPersistence pokemonPersistence) {

		_pokemonPersistence = pokemonPersistence;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	private CounterLocalService _counterLocalService;
	private PokemonPersistence _pokemonPersistence;
	private UserLocalService _userLocalService;
}
