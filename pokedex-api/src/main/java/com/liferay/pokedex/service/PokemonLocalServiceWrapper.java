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

package com.liferay.pokedex.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PokemonLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PokemonLocalService
 * @generated
 */
@ProviderType
public class PokemonLocalServiceWrapper implements PokemonLocalService,
	ServiceWrapper<PokemonLocalService> {
	public PokemonLocalServiceWrapper(PokemonLocalService pokemonLocalService) {
		_pokemonLocalService = pokemonLocalService;
	}

	/**
	* Adds the pokemon to the database. Also notifies the appropriate model listeners.
	*
	* @param pokemon the pokemon
	* @return the pokemon that was added
	*/
	@Override
	public com.liferay.pokedex.model.Pokemon addPokemon(
		com.liferay.pokedex.model.Pokemon pokemon) {
		return _pokemonLocalService.addPokemon(pokemon);
	}

	@Override
	public com.liferay.pokedex.model.Pokemon addPokemon(
		java.lang.String originalName, java.lang.String customName,
		java.lang.String description, java.lang.String type, long order,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pokemonLocalService.addPokemon(originalName, customName,
			description, type, order, serviceContext);
	}

	/**
	* Creates a new pokemon with the primary key. Does not add the pokemon to the database.
	*
	* @param id the primary key for the new pokemon
	* @return the new pokemon
	*/
	@Override
	public com.liferay.pokedex.model.Pokemon createPokemon(long id) {
		return _pokemonLocalService.createPokemon(id);
	}

	/**
	* Deletes the pokemon from the database. Also notifies the appropriate model listeners.
	*
	* @param pokemon the pokemon
	* @return the pokemon that was removed
	*/
	@Override
	public com.liferay.pokedex.model.Pokemon deletePokemon(
		com.liferay.pokedex.model.Pokemon pokemon) {
		return _pokemonLocalService.deletePokemon(pokemon);
	}

	/**
	* Deletes the pokemon with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the pokemon
	* @return the pokemon that was removed
	* @throws PortalException if a pokemon with the primary key could not be found
	*/
	@Override
	public com.liferay.pokedex.model.Pokemon deletePokemon(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pokemonLocalService.deletePokemon(id);
	}

	@Override
	public com.liferay.pokedex.model.Pokemon deletePokemon(long id,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pokemonLocalService.deletePokemon(id, serviceContext);
	}

	@Override
	public com.liferay.pokedex.model.Pokemon fetchPokemon(long id) {
		return _pokemonLocalService.fetchPokemon(id);
	}

	/**
	* Returns the pokemon matching the UUID and group.
	*
	* @param uuid the pokemon's UUID
	* @param groupId the primary key of the group
	* @return the matching pokemon, or <code>null</code> if a matching pokemon could not be found
	*/
	@Override
	public com.liferay.pokedex.model.Pokemon fetchPokemonByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _pokemonLocalService.fetchPokemonByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the pokemon with the primary key.
	*
	* @param id the primary key of the pokemon
	* @return the pokemon
	* @throws PortalException if a pokemon with the primary key could not be found
	*/
	@Override
	public com.liferay.pokedex.model.Pokemon getPokemon(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pokemonLocalService.getPokemon(id);
	}

	/**
	* Returns the pokemon matching the UUID and group.
	*
	* @param uuid the pokemon's UUID
	* @param groupId the primary key of the group
	* @return the matching pokemon
	* @throws PortalException if a matching pokemon could not be found
	*/
	@Override
	public com.liferay.pokedex.model.Pokemon getPokemonByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pokemonLocalService.getPokemonByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the pokemon in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pokemon the pokemon
	* @return the pokemon that was updated
	*/
	@Override
	public com.liferay.pokedex.model.Pokemon updatePokemon(
		com.liferay.pokedex.model.Pokemon pokemon) {
		return _pokemonLocalService.updatePokemon(pokemon);
	}

	@Override
	public com.liferay.pokedex.model.Pokemon updatePokemon(long id,
		java.lang.String customName, java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pokemonLocalService.updatePokemon(id, customName, description,
			serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _pokemonLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pokemonLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _pokemonLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _pokemonLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pokemonLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pokemonLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of pokemons.
	*
	* @return the number of pokemons
	*/
	@Override
	public int getPokemonsCount() {
		return _pokemonLocalService.getPokemonsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _pokemonLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _pokemonLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pokedex.model.impl.PokemonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _pokemonLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pokedex.model.impl.PokemonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _pokemonLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the pokemons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.pokedex.model.impl.PokemonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pokemons
	* @param end the upper bound of the range of pokemons (not inclusive)
	* @return the range of pokemons
	*/
	@Override
	public java.util.List<com.liferay.pokedex.model.Pokemon> getPokemons(
		int start, int end) {
		return _pokemonLocalService.getPokemons(start, end);
	}

	@Override
	public java.util.List<com.liferay.pokedex.model.Pokemon> getPokemons(
		long groupId) {
		return _pokemonLocalService.getPokemons(groupId);
	}

	/**
	* Returns all the pokemons matching the UUID and company.
	*
	* @param uuid the UUID of the pokemons
	* @param companyId the primary key of the company
	* @return the matching pokemons, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.pokedex.model.Pokemon> getPokemonsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _pokemonLocalService.getPokemonsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of pokemons matching the UUID and company.
	*
	* @param uuid the UUID of the pokemons
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of pokemons
	* @param end the upper bound of the range of pokemons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching pokemons, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.pokedex.model.Pokemon> getPokemonsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.pokedex.model.Pokemon> orderByComparator) {
		return _pokemonLocalService.getPokemonsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _pokemonLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _pokemonLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public PokemonLocalService getWrappedService() {
		return _pokemonLocalService;
	}

	@Override
	public void setWrappedService(PokemonLocalService pokemonLocalService) {
		_pokemonLocalService = pokemonLocalService;
	}

	private PokemonLocalService _pokemonLocalService;
}