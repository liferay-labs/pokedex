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

package com.liferay.pokedex.web.rest;

import com.liferay.pokedex.model.Pokemon;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Eudaldo Alonso
 */
public class PokemonRestUtil {

	public static void addPokemon(Pokemon pokemon) throws Exception {
		URL url = new URL(_URL);

		HttpURLConnection connection = (HttpURLConnection)url.openConnection();

		connection.setDoOutput(true);
		connection.setRequestMethod("PUT");
		connection.setRequestProperty(
			"Content-Type", "application/x-www-form-urlencoded");

		String addDataURL = _getAddDataURL(pokemon);

		OutputStream os = connection.getOutputStream();

		os.write(addDataURL.getBytes());

		os.flush();

		if (_log.isDebugEnabled()) {
			BufferedReader br = new BufferedReader(
				new InputStreamReader((connection.getInputStream())));

			String output;

			_log.debug("Pokemon added:");

			while ((output = br.readLine()) != null) {
				_log.debug(output);
			}
		}

		connection.disconnect();
	}

	private static String _getAddDataURL(Pokemon pokemon) {
		StringBundler sb = new StringBundler();

		sb.append("pokemonId=" + pokemon.getId() + "&");
		sb.append("name=" + pokemon.getName() + "&");
		sb.append("type=" + pokemon.getType() + "&");
		sb.append("smallImageURL=" + pokemon.getFrontShinyImageURL());

		return sb.toString();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PokemonRestUtil.class);

	private static final String _URL = "http://localhost:8070/pokemon/add";

}