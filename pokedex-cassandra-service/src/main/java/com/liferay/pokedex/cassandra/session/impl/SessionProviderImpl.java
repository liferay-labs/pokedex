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

package com.liferay.pokedex.cassandra.session.impl;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.CodecRegistry;
import com.datastax.driver.core.KeyspaceMetadata;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.TypeCodec;
import com.datastax.driver.core.UserType;
import com.liferay.pokedex.cassandra.codec.PokemonCodec;
import com.liferay.pokedex.cassandra.codec.PokemonUserType;
import com.liferay.pokedex.cassandra.session.SessionProvider;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import org.osgi.service.component.annotations.Component;

import java.nio.ByteBuffer;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = SessionProvider.class)
public class SessionProviderImpl implements SessionProvider {

	public Session getSession() throws Exception {
		Cluster cluster = getCluster();

		String keyspace = _configuration.get("cassandra.keyspace");

		return cluster.connect(keyspace);
	}

	protected Cluster getCluster() throws Exception {
		if (_cluster != null) {
			return _cluster;
		}

		Cluster.Builder builder = Cluster.builder();

		String hostName = _configuration.get("cassandra.hostname");
		int port = GetterUtil.getInteger(_configuration.get("cassandra.port"));

		String username = _configuration.get("cassandra.username");
		String password = _configuration.get("cassandra.password");

		String keyspace = _configuration.get("cassandra.keyspace");

		builder.addContactPoint(hostName).withoutMetrics().withPort(port);

		builder.withCredentials(username, password);

		_cluster = builder.build();

		CodecRegistry codecRegistry =
			_cluster.getConfiguration().getCodecRegistry();

		KeyspaceMetadata keyspaceMetadata =
			_cluster.getMetadata().getKeyspace(keyspace);

		UserType pokemonUserType =  keyspaceMetadata.getUserType("pokemon");

		PokemonCodec pokemonCodec =
			new PokemonCodec(
				TypeCodec.userType(pokemonUserType), PokemonUserType.class);

		codecRegistry.register(pokemonCodec);

		return _cluster;
	}

	private Cluster _cluster;

	private static final Configuration _configuration =
		ConfigurationFactoryUtil.getConfiguration(
			SessionProvider.class.getClassLoader(), "portlet");

}
