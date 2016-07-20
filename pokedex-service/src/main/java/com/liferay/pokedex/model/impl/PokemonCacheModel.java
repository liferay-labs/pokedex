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

package com.liferay.pokedex.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.pokedex.model.Pokemon;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Pokemon in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Pokemon
 * @generated
 */
@ProviderType
public class PokemonCacheModel implements CacheModel<Pokemon>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PokemonCacheModel)) {
			return false;
		}

		PokemonCacheModel pokemonCacheModel = (PokemonCacheModel)obj;

		if (id == pokemonCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", originalName=");
		sb.append(originalName);
		sb.append(", customName=");
		sb.append(customName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", type=");
		sb.append(type);
		sb.append(", order=");
		sb.append(order);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Pokemon toEntityModel() {
		PokemonImpl pokemonImpl = new PokemonImpl();

		if (uuid == null) {
			pokemonImpl.setUuid(StringPool.BLANK);
		}
		else {
			pokemonImpl.setUuid(uuid);
		}

		pokemonImpl.setId(id);
		pokemonImpl.setGroupId(groupId);
		pokemonImpl.setCompanyId(companyId);
		pokemonImpl.setUserId(userId);

		if (userName == null) {
			pokemonImpl.setUserName(StringPool.BLANK);
		}
		else {
			pokemonImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			pokemonImpl.setCreateDate(null);
		}
		else {
			pokemonImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			pokemonImpl.setModifiedDate(null);
		}
		else {
			pokemonImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (originalName == null) {
			pokemonImpl.setOriginalName(StringPool.BLANK);
		}
		else {
			pokemonImpl.setOriginalName(originalName);
		}

		if (customName == null) {
			pokemonImpl.setCustomName(StringPool.BLANK);
		}
		else {
			pokemonImpl.setCustomName(customName);
		}

		if (description == null) {
			pokemonImpl.setDescription(StringPool.BLANK);
		}
		else {
			pokemonImpl.setDescription(description);
		}

		if (type == null) {
			pokemonImpl.setType(StringPool.BLANK);
		}
		else {
			pokemonImpl.setType(type);
		}

		pokemonImpl.setOrder(order);

		pokemonImpl.resetOriginalValues();

		return pokemonImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		originalName = objectInput.readUTF();
		customName = objectInput.readUTF();
		description = objectInput.readUTF();
		type = objectInput.readUTF();

		order = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (originalName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(originalName);
		}

		if (customName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customName);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeLong(order);
	}

	public String uuid;
	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String originalName;
	public String customName;
	public String description;
	public String type;
	public long order;
}