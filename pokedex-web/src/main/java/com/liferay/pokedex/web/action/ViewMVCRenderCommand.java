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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Julio Camarero
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PokedexPortletKeys.POKEDEX, "mvc.command.name=/"
	},
	service = MVCRenderCommand.class
)
public class ViewMVCRenderCommand implements MVCRenderCommand {

	public static final String PATH = "PokedexView";

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		Template template = (Template)renderRequest.getAttribute(
			WebKeys.TEMPLATE);

		template.put("addPokemonURL", getAddPokemonURL(renderResponse));

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		template.put("pathThemeImages", themeDisplay.getPathThemeImages());

		User user = themeDisplay.getUser();

		List<Pokemon> pokemons = _pokemonLocalService.getPokemons(
			user.getGroupId());

		template.put("pokemons", toSoyData(pokemons, renderResponse));

		return PATH;
	}

	protected String getAddPokemonURL(RenderResponse renderResponse) {
		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("mvcRenderCommandName", "add_pokemon");

		return portletURL.toString();
	}

	protected String getDeletePokemonURL(
		Pokemon pokemon, RenderResponse renderResponse) {

		PortletURL portletURL = renderResponse.createActionURL();

		portletURL.setParameter("mvcRenderCommandName", "delete_pokemon");
		portletURL.setParameter("id", String.valueOf(pokemon.getId()));

		return portletURL.toString();
	}

	protected String getEditPokemonURL(
		Pokemon pokemon, RenderResponse renderResponse) {

		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("mvcRenderCommandName", "edit_pokemon");
		portletURL.setParameter("id", String.valueOf(pokemon.getId()));

		return portletURL.toString();
	}

	@Reference(unbind = "-")
	protected void setPokemonLocalService(
		PokemonLocalService pokemonLocalService) {

		_pokemonLocalService = pokemonLocalService;
	}

	protected List<Map<String, Object>> toSoyData(
		List<Pokemon> pokemons, RenderResponse renderResponse) {

		List soyPokemons = new ArrayList(pokemons.size());

		for (Pokemon pokemon : pokemons) {
			Map<String, Object> soyPokemon = new HashMap<>();

			soyPokemon.put("name", pokemon.getName());
			soyPokemon.put("order", pokemon.getOrder());
			soyPokemon.put("description", pokemon.getDescription());
			soyPokemon.put("type", pokemon.getType());
			soyPokemon.put("frontImageURL", pokemon.getFrontImageURL());
			soyPokemon.put(
				"frontShinyImageURL", pokemon.getFrontShinyImageURL());
			soyPokemon.put("backImageURL", pokemon.getBackImageURL());
			soyPokemon.put("backShinyImageURL", pokemon.getBackShinyImageURL());

			soyPokemon.put(
				"editPokemonURL", getEditPokemonURL(pokemon, renderResponse));
			soyPokemon.put(
				"deletePokemonURL",
				getDeletePokemonURL(pokemon, renderResponse));

			soyPokemons.add(soyPokemon);
		}

		return soyPokemons;
	}

	private PokemonLocalService _pokemonLocalService;

}