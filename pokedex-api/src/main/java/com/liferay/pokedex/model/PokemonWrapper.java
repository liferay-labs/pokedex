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

package com.liferay.pokedex.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Pokemon}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Pokemon
 * @generated
 */
@ProviderType
public class PokemonWrapper implements Pokemon, ModelWrapper<Pokemon> {
	public PokemonWrapper(Pokemon pokemon) {
		_pokemon = pokemon;
	}

	@Override
	public Class<?> getModelClass() {
		return Pokemon.class;
	}

	@Override
	public String getModelClassName() {
		return Pokemon.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("originalName", getOriginalName());
		attributes.put("customName", getCustomName());
		attributes.put("description", getDescription());
		attributes.put("type", getType());
		attributes.put("order", getOrder());
		attributes.put("frontImageURL", getFrontImageURL());
		attributes.put("frontShinyImageURL", getFrontShinyImageURL());
		attributes.put("backImageURL", getBackImageURL());
		attributes.put("backShinyImageURL", getBackShinyImageURL());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String originalName = (String)attributes.get("originalName");

		if (originalName != null) {
			setOriginalName(originalName);
		}

		String customName = (String)attributes.get("customName");

		if (customName != null) {
			setCustomName(customName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long order = (Long)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String frontImageURL = (String)attributes.get("frontImageURL");

		if (frontImageURL != null) {
			setFrontImageURL(frontImageURL);
		}

		String frontShinyImageURL = (String)attributes.get("frontShinyImageURL");

		if (frontShinyImageURL != null) {
			setFrontShinyImageURL(frontShinyImageURL);
		}

		String backImageURL = (String)attributes.get("backImageURL");

		if (backImageURL != null) {
			setBackImageURL(backImageURL);
		}

		String backShinyImageURL = (String)attributes.get("backShinyImageURL");

		if (backShinyImageURL != null) {
			setBackShinyImageURL(backShinyImageURL);
		}
	}

	@Override
	public Pokemon toEscapedModel() {
		return new PokemonWrapper(_pokemon.toEscapedModel());
	}

	@Override
	public Pokemon toUnescapedModel() {
		return new PokemonWrapper(_pokemon.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _pokemon.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _pokemon.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _pokemon.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _pokemon.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Pokemon> toCacheModel() {
		return _pokemon.toCacheModel();
	}

	@Override
	public int compareTo(Pokemon pokemon) {
		return _pokemon.compareTo(pokemon);
	}

	@Override
	public int hashCode() {
		return _pokemon.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pokemon.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PokemonWrapper((Pokemon)_pokemon.clone());
	}

	/**
	* Returns the back image u r l of this pokemon.
	*
	* @return the back image u r l of this pokemon
	*/
	@Override
	public java.lang.String getBackImageURL() {
		return _pokemon.getBackImageURL();
	}

	/**
	* Returns the back shiny image u r l of this pokemon.
	*
	* @return the back shiny image u r l of this pokemon
	*/
	@Override
	public java.lang.String getBackShinyImageURL() {
		return _pokemon.getBackShinyImageURL();
	}

	/**
	* Returns the custom name of this pokemon.
	*
	* @return the custom name of this pokemon
	*/
	@Override
	public java.lang.String getCustomName() {
		return _pokemon.getCustomName();
	}

	/**
	* Returns the description of this pokemon.
	*
	* @return the description of this pokemon
	*/
	@Override
	public java.lang.String getDescription() {
		return _pokemon.getDescription();
	}

	/**
	* Returns the front image u r l of this pokemon.
	*
	* @return the front image u r l of this pokemon
	*/
	@Override
	public java.lang.String getFrontImageURL() {
		return _pokemon.getFrontImageURL();
	}

	/**
	* Returns the front shiny image u r l of this pokemon.
	*
	* @return the front shiny image u r l of this pokemon
	*/
	@Override
	public java.lang.String getFrontShinyImageURL() {
		return _pokemon.getFrontShinyImageURL();
	}

	@Override
	public java.lang.String getName() {
		return _pokemon.getName();
	}

	/**
	* Returns the original name of this pokemon.
	*
	* @return the original name of this pokemon
	*/
	@Override
	public java.lang.String getOriginalName() {
		return _pokemon.getOriginalName();
	}

	/**
	* Returns the type of this pokemon.
	*
	* @return the type of this pokemon
	*/
	@Override
	public java.lang.String getType() {
		return _pokemon.getType();
	}

	/**
	* Returns the user name of this pokemon.
	*
	* @return the user name of this pokemon
	*/
	@Override
	public java.lang.String getUserName() {
		return _pokemon.getUserName();
	}

	/**
	* Returns the user uuid of this pokemon.
	*
	* @return the user uuid of this pokemon
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _pokemon.getUserUuid();
	}

	/**
	* Returns the uuid of this pokemon.
	*
	* @return the uuid of this pokemon
	*/
	@Override
	public java.lang.String getUuid() {
		return _pokemon.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _pokemon.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _pokemon.toXmlString();
	}

	/**
	* Returns the create date of this pokemon.
	*
	* @return the create date of this pokemon
	*/
	@Override
	public Date getCreateDate() {
		return _pokemon.getCreateDate();
	}

	/**
	* Returns the modified date of this pokemon.
	*
	* @return the modified date of this pokemon
	*/
	@Override
	public Date getModifiedDate() {
		return _pokemon.getModifiedDate();
	}

	/**
	* Returns the company ID of this pokemon.
	*
	* @return the company ID of this pokemon
	*/
	@Override
	public long getCompanyId() {
		return _pokemon.getCompanyId();
	}

	/**
	* Returns the group ID of this pokemon.
	*
	* @return the group ID of this pokemon
	*/
	@Override
	public long getGroupId() {
		return _pokemon.getGroupId();
	}

	/**
	* Returns the ID of this pokemon.
	*
	* @return the ID of this pokemon
	*/
	@Override
	public long getId() {
		return _pokemon.getId();
	}

	/**
	* Returns the order of this pokemon.
	*
	* @return the order of this pokemon
	*/
	@Override
	public long getOrder() {
		return _pokemon.getOrder();
	}

	/**
	* Returns the primary key of this pokemon.
	*
	* @return the primary key of this pokemon
	*/
	@Override
	public long getPrimaryKey() {
		return _pokemon.getPrimaryKey();
	}

	/**
	* Returns the user ID of this pokemon.
	*
	* @return the user ID of this pokemon
	*/
	@Override
	public long getUserId() {
		return _pokemon.getUserId();
	}

	@Override
	public void persist() {
		_pokemon.persist();
	}

	/**
	* Sets the back image u r l of this pokemon.
	*
	* @param backImageURL the back image u r l of this pokemon
	*/
	@Override
	public void setBackImageURL(java.lang.String backImageURL) {
		_pokemon.setBackImageURL(backImageURL);
	}

	/**
	* Sets the back shiny image u r l of this pokemon.
	*
	* @param backShinyImageURL the back shiny image u r l of this pokemon
	*/
	@Override
	public void setBackShinyImageURL(java.lang.String backShinyImageURL) {
		_pokemon.setBackShinyImageURL(backShinyImageURL);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_pokemon.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this pokemon.
	*
	* @param companyId the company ID of this pokemon
	*/
	@Override
	public void setCompanyId(long companyId) {
		_pokemon.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this pokemon.
	*
	* @param createDate the create date of this pokemon
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_pokemon.setCreateDate(createDate);
	}

	/**
	* Sets the custom name of this pokemon.
	*
	* @param customName the custom name of this pokemon
	*/
	@Override
	public void setCustomName(java.lang.String customName) {
		_pokemon.setCustomName(customName);
	}

	/**
	* Sets the description of this pokemon.
	*
	* @param description the description of this pokemon
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_pokemon.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_pokemon.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_pokemon.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_pokemon.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the front image u r l of this pokemon.
	*
	* @param frontImageURL the front image u r l of this pokemon
	*/
	@Override
	public void setFrontImageURL(java.lang.String frontImageURL) {
		_pokemon.setFrontImageURL(frontImageURL);
	}

	/**
	* Sets the front shiny image u r l of this pokemon.
	*
	* @param frontShinyImageURL the front shiny image u r l of this pokemon
	*/
	@Override
	public void setFrontShinyImageURL(java.lang.String frontShinyImageURL) {
		_pokemon.setFrontShinyImageURL(frontShinyImageURL);
	}

	/**
	* Sets the group ID of this pokemon.
	*
	* @param groupId the group ID of this pokemon
	*/
	@Override
	public void setGroupId(long groupId) {
		_pokemon.setGroupId(groupId);
	}

	/**
	* Sets the ID of this pokemon.
	*
	* @param id the ID of this pokemon
	*/
	@Override
	public void setId(long id) {
		_pokemon.setId(id);
	}

	/**
	* Sets the modified date of this pokemon.
	*
	* @param modifiedDate the modified date of this pokemon
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_pokemon.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_pokemon.setNew(n);
	}

	/**
	* Sets the order of this pokemon.
	*
	* @param order the order of this pokemon
	*/
	@Override
	public void setOrder(long order) {
		_pokemon.setOrder(order);
	}

	/**
	* Sets the original name of this pokemon.
	*
	* @param originalName the original name of this pokemon
	*/
	@Override
	public void setOriginalName(java.lang.String originalName) {
		_pokemon.setOriginalName(originalName);
	}

	/**
	* Sets the primary key of this pokemon.
	*
	* @param primaryKey the primary key of this pokemon
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_pokemon.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_pokemon.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the type of this pokemon.
	*
	* @param type the type of this pokemon
	*/
	@Override
	public void setType(java.lang.String type) {
		_pokemon.setType(type);
	}

	/**
	* Sets the user ID of this pokemon.
	*
	* @param userId the user ID of this pokemon
	*/
	@Override
	public void setUserId(long userId) {
		_pokemon.setUserId(userId);
	}

	/**
	* Sets the user name of this pokemon.
	*
	* @param userName the user name of this pokemon
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_pokemon.setUserName(userName);
	}

	/**
	* Sets the user uuid of this pokemon.
	*
	* @param userUuid the user uuid of this pokemon
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_pokemon.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this pokemon.
	*
	* @param uuid the uuid of this pokemon
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_pokemon.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PokemonWrapper)) {
			return false;
		}

		PokemonWrapper pokemonWrapper = (PokemonWrapper)obj;

		if (Objects.equals(_pokemon, pokemonWrapper._pokemon)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _pokemon.getStagedModelType();
	}

	@Override
	public Pokemon getWrappedModel() {
		return _pokemon;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _pokemon.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _pokemon.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_pokemon.resetOriginalValues();
	}

	private final Pokemon _pokemon;
}