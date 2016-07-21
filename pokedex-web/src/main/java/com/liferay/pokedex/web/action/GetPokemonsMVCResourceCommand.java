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

import com.liferay.pokedex.web.portlet.PokedexPortletKeys;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bruno Basto
 * @author Leonardo Barros
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PokedexPortletKeys.POKEDEX,
		"mvc.command.name=get_pokemons"
	},
	service = MVCResourceCommand.class
)
public class GetPokemonsMVCResourceCommand extends BaseMVCResourceCommand {

	protected JSONObject addPokemon(
		String name, long order, String description, String type,
		String frontImageURL, String frontShinyImageURL, String backImageURL,
		String backShinyImageURL) {

		JSONObject pokemon = JSONFactoryUtil.createJSONObject();

		pokemon.put("name", name);
		pokemon.put("order", order);
		pokemon.put("description", description);
		pokemon.put("type", type);
		pokemon.put("frontImageURL", frontImageURL);
		pokemon.put("frontShinyImageURL", frontShinyImageURL);
		pokemon.put("backImageURL", backImageURL);
		pokemon.put("backShinyImageURL", backShinyImageURL);

		return pokemon;
	}

	@Override
	protected void doServeResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		JSONArray pokemons = JSONFactoryUtil.createJSONArray();

		JSONObject bulbasaur = addPokemon(
			"Bulbasaur", 1,
			"Bulbasaur is a small, quadruped Pokémon that has blue-green skin" +
				" with darker green patches.",
			"grass", "http://pokeapi.co/media/sprites/pokemon/1.png",
			"http://pokeapi.co/media/sprites/pokemon/shiny/1.png",
			"http://pokeapi.co/media/sprites/pokemon/back/1.png",
			"http://pokeapi.co/media/sprites/pokemon/back/shiny/1.png");

		pokemons.put(bulbasaur);

		JSONObject charmander = addPokemon(
			"Charmander", 4,
			"Charmander is a bipedal, reptilian Pokémon with a primarily " +
				"orange body",
			"fire", "http://pokeapi.co/media/sprites/pokemon/4.png",
			"http://pokeapi.co/media/sprites/pokemon/shiny/4.png",
			"http://pokeapi.co/media/sprites/pokemon/back/4.png",
			"http://pokeapi.co/media/sprites/pokemon/back/shiny/4.png");

		pokemons.put(charmander);

		JSONPortletResponseUtil.writeJSON(
			resourceRequest, resourceResponse, pokemons);
	}

}