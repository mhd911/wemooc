/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.lms.lti.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PadGroup service. Represents a row in the &quot;LmsEtherpad_group&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.lms.lti.model.impl.PadGroupModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.lms.lti.model.impl.PadGroupImpl}.
 * </p>
 *
 * @author Diego Renedo Delgado
 * @see PadGroup
 * @see com.liferay.lms.lti.model.impl.PadGroupImpl
 * @see com.liferay.lms.lti.model.impl.PadGroupModelImpl
 * @generated
 */
public interface PadGroupModel extends BaseModel<PadGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a pad group model instance should use the {@link PadGroup} interface instead.
	 */

	/**
	 * Returns the primary key of this pad group.
	 *
	 * @return the primary key of this pad group
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this pad group.
	 *
	 * @param primaryKey the primary key of this pad group
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the pad group ID of this pad group.
	 *
	 * @return the pad group ID of this pad group
	 */
	public long getPadGroupId();

	/**
	 * Sets the pad group ID of this pad group.
	 *
	 * @param padGroupId the pad group ID of this pad group
	 */
	public void setPadGroupId(long padGroupId);

	/**
	 * Returns the act ID of this pad group.
	 *
	 * @return the act ID of this pad group
	 */
	public long getActId();

	/**
	 * Sets the act ID of this pad group.
	 *
	 * @param actId the act ID of this pad group
	 */
	public void setActId(long actId);

	/**
	 * Returns the company ID of this pad group.
	 *
	 * @return the company ID of this pad group
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this pad group.
	 *
	 * @param companyId the company ID of this pad group
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this pad group.
	 *
	 * @return the group ID of this pad group
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this pad group.
	 *
	 * @param groupId the group ID of this pad group
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the create date of this pad group.
	 *
	 * @return the create date of this pad group
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this pad group.
	 *
	 * @param createDate the create date of this pad group
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the name of this pad group.
	 *
	 * @return the name of this pad group
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this pad group.
	 *
	 * @param name the name of this pad group
	 */
	public void setName(String name);

	/**
	 * Returns the description of this pad group.
	 *
	 * @return the description of this pad group
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this pad group.
	 *
	 * @param description the description of this pad group
	 */
	public void setDescription(String description);

	/**
	 * Returns the url of this pad group.
	 *
	 * @return the url of this pad group
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this pad group.
	 *
	 * @param url the url of this pad group
	 */
	public void setUrl(String url);

	/**
	 * Returns the secret of this pad group.
	 *
	 * @return the secret of this pad group
	 */
	@AutoEscape
	public String getSecret();

	/**
	 * Sets the secret of this pad group.
	 *
	 * @param secret the secret of this pad group
	 */
	public void setSecret(String secret);

	/**
	 * Returns the rol of this pad group.
	 *
	 * @return the rol of this pad group
	 */
	@AutoEscape
	public String getRol();

	/**
	 * Sets the rol of this pad group.
	 *
	 * @param rol the rol of this pad group
	 */
	public void setRol(String rol);

	/**
	 * Returns the conten type of this pad group.
	 *
	 * @return the conten type of this pad group
	 */
	@AutoEscape
	public String getContenType();

	/**
	 * Sets the conten type of this pad group.
	 *
	 * @param contenType the conten type of this pad group
	 */
	public void setContenType(String contenType);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(PadGroup padGroup);

	public int hashCode();

	public CacheModel<PadGroup> toCacheModel();

	public PadGroup toEscapedModel();

	public String toString();

	public String toXmlString();
}