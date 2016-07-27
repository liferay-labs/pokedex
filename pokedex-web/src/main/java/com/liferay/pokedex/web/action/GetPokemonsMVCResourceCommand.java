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
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import me.sargunvohra.lib.pokekotlin.client.ClientConfig;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonSprites;

import okhttp3.HttpUrl;
import org.osgi.service.component.annotations.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Julio Camarero
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

	@Override
	protected void doServeResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		JSONArray pokemons = JSONFactoryUtil.createJSONArray();

		int start = ParamUtil.getInteger(resourceRequest, "start", 0);
		int end = ParamUtil.getInteger(resourceRequest, "end", 8);

		ClientConfig clientConfig = new ClientConfig(
			HttpUrl.parse("https://localhost:8000/api/v2/"),
			b -> b.connectTimeout(30, TimeUnit.SECONDS)
				  .readTimeout(30, TimeUnit.SECONDS)
				  .writeTimeout(30, TimeUnit.SECONDS));

		PokeApi pokeApi = new PokeApiClient(clientConfig);

		for (int i = start; i < end; i++) {
			Pokemon pokemon = pokeApi.getPokemon(i + 1);

			pokemons.put(toJSONPokemon(pokemon));
		}

		JSONPortletResponseUtil.writeJSON(
			resourceRequest, resourceResponse, pokemons);
	}

	protected JSONObject toJSONPokemon(Pokemon pokemon) {
		JSONObject pokemonJSON = JSONFactoryUtil.createJSONObject();

		pokemonJSON.put("name", pokemon.getName());
		pokemonJSON.put("order", pokemon.getId());
		pokemonJSON.put("description", "");

		String type = pokemon.getTypes().get(0).getType().getName();

		pokemonJSON.put("type", type);

		PokemonSprites sprites = pokemon.getSprites();

		pokemonJSON.put("frontImageURL", sprites.getFrontDefault());
		pokemonJSON.put("frontShinyImageURL", sprites.getFrontShiny());
		pokemonJSON.put("backImageURL", sprites.getBackDefault());
		pokemonJSON.put("backShinyImageURL", sprites.getBackShiny());

		return pokemonJSON;
	}

}