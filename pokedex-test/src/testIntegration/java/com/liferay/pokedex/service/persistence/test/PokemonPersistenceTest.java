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

package com.liferay.pokedex.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.pokedex.exception.NoSuchPokemonException;
import com.liferay.pokedex.model.Pokemon;
import com.liferay.pokedex.service.PokemonLocalServiceUtil;
import com.liferay.pokedex.service.persistence.PokemonPersistence;
import com.liferay.pokedex.service.persistence.PokemonUtil;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.TransactionalTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class PokemonPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = PokemonUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Pokemon> iterator = _pokemons.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Pokemon pokemon = _persistence.create(pk);

		Assert.assertNotNull(pokemon);

		Assert.assertEquals(pokemon.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Pokemon newPokemon = addPokemon();

		_persistence.remove(newPokemon);

		Pokemon existingPokemon = _persistence.fetchByPrimaryKey(newPokemon.getPrimaryKey());

		Assert.assertNull(existingPokemon);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPokemon();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Pokemon newPokemon = _persistence.create(pk);

		newPokemon.setUuid(RandomTestUtil.randomString());

		newPokemon.setGroupId(RandomTestUtil.nextLong());

		newPokemon.setCompanyId(RandomTestUtil.nextLong());

		newPokemon.setUserId(RandomTestUtil.nextLong());

		newPokemon.setUserName(RandomTestUtil.randomString());

		newPokemon.setCreateDate(RandomTestUtil.nextDate());

		newPokemon.setModifiedDate(RandomTestUtil.nextDate());

		newPokemon.setOriginalName(RandomTestUtil.randomString());

		newPokemon.setCustomName(RandomTestUtil.randomString());

		newPokemon.setDescription(RandomTestUtil.randomString());

		newPokemon.setType(RandomTestUtil.randomString());

		newPokemon.setOrder(RandomTestUtil.nextLong());

		_pokemons.add(_persistence.update(newPokemon));

		Pokemon existingPokemon = _persistence.findByPrimaryKey(newPokemon.getPrimaryKey());

		Assert.assertEquals(existingPokemon.getUuid(), newPokemon.getUuid());
		Assert.assertEquals(existingPokemon.getId(), newPokemon.getId());
		Assert.assertEquals(existingPokemon.getGroupId(),
			newPokemon.getGroupId());
		Assert.assertEquals(existingPokemon.getCompanyId(),
			newPokemon.getCompanyId());
		Assert.assertEquals(existingPokemon.getUserId(), newPokemon.getUserId());
		Assert.assertEquals(existingPokemon.getUserName(),
			newPokemon.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingPokemon.getCreateDate()),
			Time.getShortTimestamp(newPokemon.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingPokemon.getModifiedDate()),
			Time.getShortTimestamp(newPokemon.getModifiedDate()));
		Assert.assertEquals(existingPokemon.getOriginalName(),
			newPokemon.getOriginalName());
		Assert.assertEquals(existingPokemon.getCustomName(),
			newPokemon.getCustomName());
		Assert.assertEquals(existingPokemon.getDescription(),
			newPokemon.getDescription());
		Assert.assertEquals(existingPokemon.getType(), newPokemon.getType());
		Assert.assertEquals(existingPokemon.getOrder(), newPokemon.getOrder());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUUID_G(StringPool.NULL, 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUuid_C(StringPool.NULL, 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Pokemon newPokemon = addPokemon();

		Pokemon existingPokemon = _persistence.findByPrimaryKey(newPokemon.getPrimaryKey());

		Assert.assertEquals(existingPokemon, newPokemon);
	}

	@Test(expected = NoSuchPokemonException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<Pokemon> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("Pokemon", "uuid", true,
			"id", true, "groupId", true, "companyId", true, "userId", true,
			"userName", true, "createDate", true, "modifiedDate", true,
			"originalName", true, "customName", true, "description", true,
			"type", true, "order", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Pokemon newPokemon = addPokemon();

		Pokemon existingPokemon = _persistence.fetchByPrimaryKey(newPokemon.getPrimaryKey());

		Assert.assertEquals(existingPokemon, newPokemon);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Pokemon missingPokemon = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPokemon);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Pokemon newPokemon1 = addPokemon();
		Pokemon newPokemon2 = addPokemon();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPokemon1.getPrimaryKey());
		primaryKeys.add(newPokemon2.getPrimaryKey());

		Map<Serializable, Pokemon> pokemons = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, pokemons.size());
		Assert.assertEquals(newPokemon1,
			pokemons.get(newPokemon1.getPrimaryKey()));
		Assert.assertEquals(newPokemon2,
			pokemons.get(newPokemon2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Pokemon> pokemons = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(pokemons.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Pokemon newPokemon = addPokemon();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPokemon.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Pokemon> pokemons = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, pokemons.size());
		Assert.assertEquals(newPokemon, pokemons.get(newPokemon.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Pokemon> pokemons = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(pokemons.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Pokemon newPokemon = addPokemon();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPokemon.getPrimaryKey());

		Map<Serializable, Pokemon> pokemons = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, pokemons.size());
		Assert.assertEquals(newPokemon, pokemons.get(newPokemon.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = PokemonLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Pokemon>() {
				@Override
				public void performAction(Pokemon pokemon) {
					Assert.assertNotNull(pokemon);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Pokemon newPokemon = addPokemon();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Pokemon.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newPokemon.getId()));

		List<Pokemon> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Pokemon existingPokemon = result.get(0);

		Assert.assertEquals(existingPokemon, newPokemon);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Pokemon.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id",
				RandomTestUtil.nextLong()));

		List<Pokemon> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Pokemon newPokemon = addPokemon();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Pokemon.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newPokemon.getId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("id", new Object[] { newId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Pokemon.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("id",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Pokemon newPokemon = addPokemon();

		_persistence.clearCache();

		Pokemon existingPokemon = _persistence.findByPrimaryKey(newPokemon.getPrimaryKey());

		Assert.assertTrue(Objects.equals(existingPokemon.getUuid(),
				ReflectionTestUtil.invoke(existingPokemon, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingPokemon.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingPokemon,
				"getOriginalGroupId", new Class<?>[0]));
	}

	protected Pokemon addPokemon() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Pokemon pokemon = _persistence.create(pk);

		pokemon.setUuid(RandomTestUtil.randomString());

		pokemon.setGroupId(RandomTestUtil.nextLong());

		pokemon.setCompanyId(RandomTestUtil.nextLong());

		pokemon.setUserId(RandomTestUtil.nextLong());

		pokemon.setUserName(RandomTestUtil.randomString());

		pokemon.setCreateDate(RandomTestUtil.nextDate());

		pokemon.setModifiedDate(RandomTestUtil.nextDate());

		pokemon.setOriginalName(RandomTestUtil.randomString());

		pokemon.setCustomName(RandomTestUtil.randomString());

		pokemon.setDescription(RandomTestUtil.randomString());

		pokemon.setType(RandomTestUtil.randomString());

		pokemon.setOrder(RandomTestUtil.nextLong());

		_pokemons.add(_persistence.update(pokemon));

		return pokemon;
	}

	private List<Pokemon> _pokemons = new ArrayList<Pokemon>();
	private PokemonPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}