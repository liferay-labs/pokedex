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

package com.liferay.pokedex.cassandra.persistence;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Delete;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.liferay.pokedex.cassandra.model.BaseModel;

import java.util.Iterator;

/**
 * @author Pavel Savinov
 */
public abstract class BasePersistence<T extends BaseModel> {

	public abstract T create();

	public void delete(long id) {
		delete(getTableName(), id);
	}

	public T fetchById(long id) {
		Select.Selection selection = QueryBuilder.select();

		Select select = selection.from(getTableName());

		select.where(QueryBuilder.eq(getPrimaryKey(), id));

		ResultSet resultSet = session.execute(select);

		Iterator<Row> iterator = resultSet.iterator();

		if (iterator.hasNext()) {
			Row row = iterator.next();

			return getEntity(row);
		}

		return null;
	}

	protected abstract T getEntity(Row row);

	public abstract String getPrimaryKey();

	public abstract String getTableName();

	public void setSession(Session session) {
		this.session = session;
	}

	public abstract T update(T entity);

	protected void delete(String tableName, long id) {
		Delete.Selection selection = QueryBuilder.delete();

		Delete delete = selection.from(tableName);

		delete.where(QueryBuilder.eq(getPrimaryKey(), id));

		session.execute(delete);
	}

	protected Session session;
}
