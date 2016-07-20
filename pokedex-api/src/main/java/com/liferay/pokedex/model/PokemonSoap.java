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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PokemonSoap implements Serializable {
	public static PokemonSoap toSoapModel(Pokemon model) {
		PokemonSoap soapModel = new PokemonSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setOriginalName(model.getOriginalName());
		soapModel.setCustomName(model.getCustomName());
		soapModel.setDescription(model.getDescription());
		soapModel.setType(model.getType());
		soapModel.setOrder(model.getOrder());
		soapModel.setFrontImageURL(model.getFrontImageURL());
		soapModel.setFrontShinyImageURL(model.getFrontShinyImageURL());
		soapModel.setBackImageURL(model.getBackImageURL());
		soapModel.setBackShinyImageURL(model.getBackShinyImageURL());

		return soapModel;
	}

	public static PokemonSoap[] toSoapModels(Pokemon[] models) {
		PokemonSoap[] soapModels = new PokemonSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PokemonSoap[][] toSoapModels(Pokemon[][] models) {
		PokemonSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PokemonSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PokemonSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PokemonSoap[] toSoapModels(List<Pokemon> models) {
		List<PokemonSoap> soapModels = new ArrayList<PokemonSoap>(models.size());

		for (Pokemon model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PokemonSoap[soapModels.size()]);
	}

	public PokemonSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getOriginalName() {
		return _originalName;
	}

	public void setOriginalName(String originalName) {
		_originalName = originalName;
	}

	public String getCustomName() {
		return _customName;
	}

	public void setCustomName(String customName) {
		_customName = customName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public long getOrder() {
		return _order;
	}

	public void setOrder(long order) {
		_order = order;
	}

	public String getFrontImageURL() {
		return _frontImageURL;
	}

	public void setFrontImageURL(String frontImageURL) {
		_frontImageURL = frontImageURL;
	}

	public String getFrontShinyImageURL() {
		return _frontShinyImageURL;
	}

	public void setFrontShinyImageURL(String frontShinyImageURL) {
		_frontShinyImageURL = frontShinyImageURL;
	}

	public String getBackImageURL() {
		return _backImageURL;
	}

	public void setBackImageURL(String backImageURL) {
		_backImageURL = backImageURL;
	}

	public String getBackShinyImageURL() {
		return _backShinyImageURL;
	}

	public void setBackShinyImageURL(String backShinyImageURL) {
		_backShinyImageURL = backShinyImageURL;
	}

	private String _uuid;
	private long _id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _originalName;
	private String _customName;
	private String _description;
	private String _type;
	private long _order;
	private String _frontImageURL;
	private String _frontShinyImageURL;
	private String _backImageURL;
	private String _backShinyImageURL;
}