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
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;

import org.osgi.service.component.annotations.Component;

/**
 * @author Julio Camarero
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PokedexPortletKeys.POKEDEX,
		"mvc.command.name=add_pokemon"
	},
	service = MVCRenderCommand.class
)
public class AddPokemonMVCRenderCommand implements MVCRenderCommand {

	public static final String PATH = "PokedexAddPokemon";

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		Template template = (Template)renderRequest.getAttribute(
			WebKeys.TEMPLATE);

		template.put("addPokemonURL", getAddPokemonURL(renderResponse));

		template.put("getPokemonsURL", getGetPokemonsURL(renderResponse));

		template.put("backURL", getBackURL(renderResponse));

		template.put("portletNamespace", renderResponse.getNamespace());

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		template.put("pathThemeImages", themeDisplay.getPathThemeImages());

		template.put("pokemons", new ArrayList());

		template.put("originalPokemonList", new ArrayList());

		return PATH;
	}

	protected String getAddPokemonURL(RenderResponse renderResponse) {
		PortletURL portletURL = renderResponse.createActionURL();

		portletURL.setParameter(ActionRequest.ACTION_NAME, "add_pokemon");
		portletURL.setParameter("redirect", getBackURL(renderResponse));

		return portletURL.toString();
	}

	protected String getBackURL(RenderResponse renderResponse) {
		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("mvcRenderCommandName", "/");

		return portletURL.toString();
	}

	protected String getGetPokemonsURL(RenderResponse renderResponse) {
		ResourceURL portletURL = renderResponse.createResourceURL();

		portletURL.setResourceID("get_pokemons");

		return portletURL.toString();
	}

}