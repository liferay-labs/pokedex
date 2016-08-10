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

package com.liferay.pokedex.nosql.model;

import com.liferay.pokedex.cassandra.model.BaseModel;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;

/**
 * @author Pavel Savinov
 */
public class Pokemon extends BaseModel {

	public String getName() {
		String customName = getCustomName();

		if (Validator.isNotNull(customName)) {
			return customName;
		}

		return getOriginalName();
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Pokemon pokemon = (Pokemon) o;

		if (_pokemonId != pokemon._pokemonId) {
			return false;
		}
		if (_companyId != pokemon._companyId) {
			return false;
		}
		if (_groupId != pokemon._groupId) {
			return false;
		}
		if (_userId != pokemon._userId) {
			return false;
		}
		if (_order != pokemon._order) {
			return false;
		}
		if (_userName != null ? !_userName.equals(pokemon._userName) :
			pokemon._userName != null) {
			return false;
		}
		if (_uuid != null ? !_uuid.equals(pokemon._uuid) : pokemon._uuid != null) {
			return false;
		}
		if (_createDate != null ? !_createDate.equals(pokemon._createDate) :
			pokemon._createDate != null) {
			return false;
		}
		if (_modifiedDate != null ? !_modifiedDate.equals(pokemon._modifiedDate) :
			pokemon._modifiedDate != null) {
			return false;
		}
		if (_originalName != null ? !_originalName.equals(pokemon._originalName) :
			pokemon._originalName != null) {
			return false;
		}
		if (_customName != null ? !_customName.equals(pokemon._customName) :
			pokemon._customName != null) {
			return false;
		}
		if (_description != null ? !_description.equals(pokemon._description) :
			pokemon._description != null) {
			return false;
		}
		if (_type != null ? !_type.equals(pokemon._type) : pokemon._type != null) {
			return false;
		}
		if (_frontImageURL != null ?
			!_frontImageURL.equals(pokemon._frontImageURL) :
			pokemon._frontImageURL != null) {
			return false;
		}
		if (_frontShinyImageURL != null ?
			!_frontShinyImageURL.equals(pokemon._frontShinyImageURL) :
			pokemon._frontShinyImageURL != null) {
			return false;
		}
		if (_backImageURL != null ? !_backImageURL.equals(pokemon._backImageURL) :
			pokemon._backImageURL != null) {
			return false;
		}
		return _backShinyImageURL != null ?
			_backShinyImageURL.equals(pokemon._backShinyImageURL) :
			pokemon._backShinyImageURL == null;

	}

	public int hashCode() {
		int result = (int) (_pokemonId ^ (_pokemonId >>> 32));
		result = 31 * result + (int) (_companyId ^ (_companyId >>> 32));
		result = 31 * result + (int) (_groupId ^ (_groupId >>> 32));
		result = 31 * result + (int) (_userId ^ (_userId >>> 32));
		result = 31 * result + (_userName != null ? _userName.hashCode() : 0);
		result = 31 * result + (_uuid != null ? _uuid.hashCode() : 0);
		result = 31 * result + (_createDate != null ? _createDate.hashCode() : 0);
		result =
			31 * result + (_modifiedDate != null ? _modifiedDate.hashCode() : 0);
		result =
			31 * result + (_originalName != null ? _originalName.hashCode() : 0);
		result = 31 * result + (_customName != null ? _customName.hashCode() : 0);
		result =
			31 * result + (_description != null ? _description.hashCode() : 0);
		result = 31 * result + (_type != null ? _type.hashCode() : 0);
		result = 31 * result + (int) (_order ^ (_order >>> 32));
		result =
			31 * result +
			(_frontImageURL != null ? _frontImageURL.hashCode() : 0);
		result = 31 * result +
				 (_frontShinyImageURL != null ? _frontShinyImageURL.hashCode() :
					 0);
		result =
			31 * result + (_backImageURL != null ? _backImageURL.hashCode() : 0);
		result = 31 * result +
				 (_backShinyImageURL != null ? _backShinyImageURL.hashCode() : 0);
		return result;
	}

	public long getPokemonId() {
		return _pokemonId;
	}

	public void setPokemonId(long pokemonId) {
		this._pokemonId = pokemonId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		this._companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		this._groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		this._userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		this._userName = userName;
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		this._uuid = uuid;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		this._createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this._modifiedDate = modifiedDate;
	}

	public String getOriginalName() {
		return _originalName;
	}

	public void setOriginalName(String originalName) {
		this._originalName = originalName;
	}

	public String getCustomName() {
		return _customName;
	}

	public void setCustomName(String customName) {
		this._customName = customName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		this._description = description;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		this._type = type;
	}

	public long getOrder() {
		return _order;
	}

	public void setOrder(long order) {
		this._order = order;
	}

	public String getFrontImageURL() {
		return _frontImageURL;
	}

	public void setFrontImageURL(String frontImageURL) {
		this._frontImageURL = frontImageURL;
	}

	public String getFrontShinyImageURL() {
		return _frontShinyImageURL;
	}

	public void setFrontShinyImageURL(String frontShinyImageURL) {
		this._frontShinyImageURL = frontShinyImageURL;
	}

	public String getBackImageURL() {
		return _backImageURL;
	}

	public void setBackImageURL(String backImageURL) {
		this._backImageURL = backImageURL;
	}

	public String getBackShinyImageURL() {
		return _backShinyImageURL;
	}

	public void setBackShinyImageURL(String backShinyImageURL) {
		this._backShinyImageURL = backShinyImageURL;
	}

	private long _pokemonId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private String _uuid;
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
