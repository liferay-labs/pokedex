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

package com.liferay.pokedex.web.sampledata;

import com.liferay.pokedex.model.Pokemon;
import com.liferay.pokedex.service.PokemonLocalService;
import com.liferay.pokedex.web.portlet.PokedexPortletKeys;
import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Julio Camarero
 */
@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class AddDefaultPokemonsPortalInstanceLifecycleListener
	extends BasePortalInstanceLifecycleListener {

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		List<User> users = _userLocalService.getCompanyUsers(
			company.getCompanyId(), 0, 10);

		for (User user : users) {
			if (!user.isActive() || user.isDefaultUser()) {
				continue;
			}

			Group group = user.getGroup();

			if (group == null) {
				continue;
			}

			List<Pokemon> pokemons = _pokemonLocalService.getPokemons(
				user.getGroupId());

			if (!pokemons.isEmpty()) {
				continue;
			}

			addDefaultPokemons(user);
		}
	}

	protected void addDefaultPokemons(User user) throws PortalException {
		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setUserId(user.getUserId());

		_pokemonLocalService.addPokemon(
			"Pikachu", null,
			"Pikachu is a short, chubby rodent Pokémon. It is covered in yell" +
				"ow fur, and its ears are long and pointed with black tips.",
			"electric", 25, "http://pokeapi.co/media/sprites/pokemon/25.png",
			"http://pokeapi.co/media/sprites/pokemon/shiny/25.png",
			"http://pokeapi.co/media/sprites/pokemon/back/25.png",
			"http://pokeapi.co/media/sprites/pokemon/back/shiny/25.png",
			serviceContext);

		_pokemonLocalService.addPokemon(
			"Squirtle", null,
			"Squirtle is a small Pokémon that resembles a light blue turtle." +
				" While it typically walks on its two short legs, it has been" +
					" shown to run on all fours in Super Smash Bros.",
			"water", 7, "http://pokeapi.co/media/sprites/pokemon/7.png",
			"http://pokeapi.co/media/sprites/pokemon/shiny/7.png",
			"http://pokeapi.co/media/sprites/pokemon/back/7.png",
			"http://pokeapi.co/media/sprites/pokemon/back/shiny/7.png",
			serviceContext);
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	@Reference(
		target = "(javax.portlet.name=" + PokedexPortletKeys.POKEDEX + ")",
		unbind = "-"
	)
	protected void setPokedexPortlet(Portlet portlet) {
	}

	@Reference(unbind = "-")
	protected void setPokemonLocalService(
		PokemonLocalService pokemonLocalService) {

		_pokemonLocalService = pokemonLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	private PokemonLocalService _pokemonLocalService;
	private UserLocalService _userLocalService;

}