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

package com.liferay.pokedex.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.pokedex.exception.NoSuchPokemonException;
import com.liferay.pokedex.model.Pokemon;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the pokemon service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.pokedex.service.persistence.impl.PokemonPersistenceImpl
 * @see PokemonUtil
 * @generated
 */
@ProviderType
public interface PokemonPersistence extends BasePersistence<Pokemon> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PokemonUtil} to access the pokemon persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the pokemons where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching pokemons
	*/
	public java.util.List<Pokemon> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the pokemons where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PokemonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of pokemons
	* @param end the upper bound of the range of pokemons (not inclusive)
	* @return the range of matching pokemons
	*/
	public java.util.List<Pokemon> findByUuid(java.lang.String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the pokemons where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PokemonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of pokemons
	* @param end the upper bound of the range of pokemons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pokemons
	*/
	public java.util.List<Pokemon> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator);

	/**
	* Returns an ordered range of all the pokemons where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PokemonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of pokemons
	* @param end the upper bound of the range of pokemons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pokemons
	*/
	public java.util.List<Pokemon> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pokemon in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pokemon
	* @throws NoSuchPokemonException if a matching pokemon could not be found
	*/
	public Pokemon findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator)
		throws NoSuchPokemonException;

	/**
	* Returns the first pokemon in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pokemon, or <code>null</code> if a matching pokemon could not be found
	*/
	public Pokemon fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator);

	/**
	* Returns the last pokemon in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pokemon
	* @throws NoSuchPokemonException if a matching pokemon could not be found
	*/
	public Pokemon findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator)
		throws NoSuchPokemonException;

	/**
	* Returns the last pokemon in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pokemon, or <code>null</code> if a matching pokemon could not be found
	*/
	public Pokemon fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator);

	/**
	* Returns the pokemons before and after the current pokemon in the ordered set where uuid = &#63;.
	*
	* @param id the primary key of the current pokemon
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pokemon
	* @throws NoSuchPokemonException if a pokemon with the primary key could not be found
	*/
	public Pokemon[] findByUuid_PrevAndNext(long id, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator)
		throws NoSuchPokemonException;

	/**
	* Removes all the pokemons where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of pokemons where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching pokemons
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the pokemon where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPokemonException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching pokemon
	* @throws NoSuchPokemonException if a matching pokemon could not be found
	*/
	public Pokemon findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchPokemonException;

	/**
	* Returns the pokemon where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching pokemon, or <code>null</code> if a matching pokemon could not be found
	*/
	public Pokemon fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the pokemon where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching pokemon, or <code>null</code> if a matching pokemon could not be found
	*/
	public Pokemon fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the pokemon where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the pokemon that was removed
	*/
	public Pokemon removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchPokemonException;

	/**
	* Returns the number of pokemons where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching pokemons
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the pokemons where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching pokemons
	*/
	public java.util.List<Pokemon> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the pokemons where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PokemonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of pokemons
	* @param end the upper bound of the range of pokemons (not inclusive)
	* @return the range of matching pokemons
	*/
	public java.util.List<Pokemon> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the pokemons where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PokemonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of pokemons
	* @param end the upper bound of the range of pokemons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pokemons
	*/
	public java.util.List<Pokemon> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator);

	/**
	* Returns an ordered range of all the pokemons where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PokemonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of pokemons
	* @param end the upper bound of the range of pokemons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pokemons
	*/
	public java.util.List<Pokemon> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pokemon in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pokemon
	* @throws NoSuchPokemonException if a matching pokemon could not be found
	*/
	public Pokemon findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator)
		throws NoSuchPokemonException;

	/**
	* Returns the first pokemon in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pokemon, or <code>null</code> if a matching pokemon could not be found
	*/
	public Pokemon fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator);

	/**
	* Returns the last pokemon in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pokemon
	* @throws NoSuchPokemonException if a matching pokemon could not be found
	*/
	public Pokemon findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator)
		throws NoSuchPokemonException;

	/**
	* Returns the last pokemon in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pokemon, or <code>null</code> if a matching pokemon could not be found
	*/
	public Pokemon fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator);

	/**
	* Returns the pokemons before and after the current pokemon in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param id the primary key of the current pokemon
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pokemon
	* @throws NoSuchPokemonException if a pokemon with the primary key could not be found
	*/
	public Pokemon[] findByUuid_C_PrevAndNext(long id, java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator)
		throws NoSuchPokemonException;

	/**
	* Removes all the pokemons where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of pokemons where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching pokemons
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the pokemons where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching pokemons
	*/
	public java.util.List<Pokemon> findByGroupId(long groupId);

	/**
	* Returns a range of all the pokemons where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PokemonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of pokemons
	* @param end the upper bound of the range of pokemons (not inclusive)
	* @return the range of matching pokemons
	*/
	public java.util.List<Pokemon> findByGroupId(long groupId, int start,
		int end);

	/**
	* Returns an ordered range of all the pokemons where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PokemonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of pokemons
	* @param end the upper bound of the range of pokemons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pokemons
	*/
	public java.util.List<Pokemon> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator);

	/**
	* Returns an ordered range of all the pokemons where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PokemonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of pokemons
	* @param end the upper bound of the range of pokemons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pokemons
	*/
	public java.util.List<Pokemon> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pokemon in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pokemon
	* @throws NoSuchPokemonException if a matching pokemon could not be found
	*/
	public Pokemon findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator)
		throws NoSuchPokemonException;

	/**
	* Returns the first pokemon in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pokemon, or <code>null</code> if a matching pokemon could not be found
	*/
	public Pokemon fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator);

	/**
	* Returns the last pokemon in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pokemon
	* @throws NoSuchPokemonException if a matching pokemon could not be found
	*/
	public Pokemon findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator)
		throws NoSuchPokemonException;

	/**
	* Returns the last pokemon in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pokemon, or <code>null</code> if a matching pokemon could not be found
	*/
	public Pokemon fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator);

	/**
	* Returns the pokemons before and after the current pokemon in the ordered set where groupId = &#63;.
	*
	* @param id the primary key of the current pokemon
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pokemon
	* @throws NoSuchPokemonException if a pokemon with the primary key could not be found
	*/
	public Pokemon[] findByGroupId_PrevAndNext(long id, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator)
		throws NoSuchPokemonException;

	/**
	* Removes all the pokemons where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of pokemons where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching pokemons
	*/
	public int countByGroupId(long groupId);

	/**
	* Caches the pokemon in the entity cache if it is enabled.
	*
	* @param pokemon the pokemon
	*/
	public void cacheResult(Pokemon pokemon);

	/**
	* Caches the pokemons in the entity cache if it is enabled.
	*
	* @param pokemons the pokemons
	*/
	public void cacheResult(java.util.List<Pokemon> pokemons);

	/**
	* Creates a new pokemon with the primary key. Does not add the pokemon to the database.
	*
	* @param id the primary key for the new pokemon
	* @return the new pokemon
	*/
	public Pokemon create(long id);

	/**
	* Removes the pokemon with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the pokemon
	* @return the pokemon that was removed
	* @throws NoSuchPokemonException if a pokemon with the primary key could not be found
	*/
	public Pokemon remove(long id) throws NoSuchPokemonException;

	public Pokemon updateImpl(Pokemon pokemon);

	/**
	* Returns the pokemon with the primary key or throws a {@link NoSuchPokemonException} if it could not be found.
	*
	* @param id the primary key of the pokemon
	* @return the pokemon
	* @throws NoSuchPokemonException if a pokemon with the primary key could not be found
	*/
	public Pokemon findByPrimaryKey(long id) throws NoSuchPokemonException;

	/**
	* Returns the pokemon with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the pokemon
	* @return the pokemon, or <code>null</code> if a pokemon with the primary key could not be found
	*/
	public Pokemon fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, Pokemon> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the pokemons.
	*
	* @return the pokemons
	*/
	public java.util.List<Pokemon> findAll();

	/**
	* Returns a range of all the pokemons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PokemonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pokemons
	* @param end the upper bound of the range of pokemons (not inclusive)
	* @return the range of pokemons
	*/
	public java.util.List<Pokemon> findAll(int start, int end);

	/**
	* Returns an ordered range of all the pokemons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PokemonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pokemons
	* @param end the upper bound of the range of pokemons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of pokemons
	*/
	public java.util.List<Pokemon> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator);

	/**
	* Returns an ordered range of all the pokemons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PokemonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pokemons
	* @param end the upper bound of the range of pokemons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of pokemons
	*/
	public java.util.List<Pokemon> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pokemon> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the pokemons from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of pokemons.
	*
	* @return the number of pokemons
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}