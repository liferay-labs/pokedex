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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
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
		"javax.portlet.name=" + PokedexPortletKeys.POKEDEX,
		"mvc.command.name=edit_pokemon"
	},
	service = MVCRenderCommand.class
)
public class EditPokemonMVCRenderCommand implements MVCRenderCommand {

	public static final String ERROR_PATH = "PokedexEditPokemonError";

	public static final String PATH = "PokedexEditPokemon";

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		Template template = (Template)renderRequest.getAttribute(
			WebKeys.TEMPLATE);

		template.put("backURL", getBackURL(renderResponse));

		template.put("portletNamespace", renderResponse.getNamespace());

		long id = ParamUtil.getLong(renderRequest, "id");

		try {
			Pokemon pokemon = _pokemonLocalService.getPokemon(id);

			template.put("pokemon", toSoyData(pokemon));
		}
		catch (PortalException pe) {
			return ERROR_PATH;
		}

		template.put("updatePokemonURL", getUpdatePokemonURL(renderResponse));

		return PATH;
	}

	protected String getBackURL(RenderResponse renderResponse) {
		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("mvcRenderCommandName", "/");

		return portletURL.toString();
	}

	protected String getUpdatePokemonURL(RenderResponse renderResponse) {
		PortletURL portletURL = renderResponse.createActionURL();

		portletURL.setParameter(ActionRequest.ACTION_NAME, "edit_pokemon");
		portletURL.setParameter("redirect", getBackURL(renderResponse));

		return portletURL.toString();
	}

	@Reference(unbind = "-")
	protected void setPokemonLocalService(
		PokemonLocalService pokemonLocalService) {

		_pokemonLocalService = pokemonLocalService;
	}

	protected Map<String, Object> toSoyData(Pokemon pokemon) {
		Map<String, Object> soyPokemon = new HashMap<>();

		soyPokemon.put("id", pokemon.getId());
		soyPokemon.put("name", pokemon.getName());
		soyPokemon.put("order", pokemon.getOrder());
		soyPokemon.put("description", pokemon.getDescription());
		soyPokemon.put("type", pokemon.getType());
		soyPokemon.put("frontImageURL", pokemon.getFrontImageURL());
		soyPokemon.put("frontShinyImageURL", pokemon.getFrontShinyImageURL());
		soyPokemon.put("backImageURL", pokemon.getBackImageURL());
		soyPokemon.put("backShinyImageURL", pokemon.getBackShinyImageURL());

		return soyPokemon;
	}

	private PokemonLocalService _pokemonLocalService;

}