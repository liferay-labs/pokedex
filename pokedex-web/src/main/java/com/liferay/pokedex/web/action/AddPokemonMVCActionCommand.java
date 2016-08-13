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

package com.liferay.pokedex.web.action;

import com.liferay.pokedex.model.Pokemon;
import com.liferay.pokedex.service.PokemonLocalService;
import com.liferay.pokedex.web.portlet.PokedexPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Julio Camarero
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PokedexPortletKeys.POKEDEX,
		"mvc.command.name=add_pokemon"
	},
	service = MVCActionCommand.class
)
public class AddPokemonMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String originalName = ParamUtil.getString(
			actionRequest, "originalName");
		String customName = ParamUtil.getString(actionRequest, "customName");
		String description = ParamUtil.getString(actionRequest, "description");
		String type = ParamUtil.getString(actionRequest, "type");
		long order = ParamUtil.getLong(actionRequest, "order");

		String frontImageURL = ParamUtil.getString(
			actionRequest, "frontImageURL");
		String frontShinyImageURL = ParamUtil.getString(
			actionRequest, "frontShinyImageURL");
		String backImageURL = ParamUtil.getString(
			actionRequest, "backImageURL");
		String backShinyImageURL = ParamUtil.getString(
			actionRequest, "backShinyImageURL");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Pokemon.class.getName(), actionRequest);

		_pokemonLocalService.addPokemon(
			originalName, customName, description, type, order, frontImageURL,
			frontShinyImageURL, backImageURL, backShinyImageURL,
			serviceContext);

		sendRedirect(actionRequest, actionResponse);
	}

	@Reference(unbind = "-")
	protected void setPokemonLocalService(
		PokemonLocalService pokemonLocalService) {

		_pokemonLocalService = pokemonLocalService;
	}

	private PokemonLocalService _pokemonLocalService;

}