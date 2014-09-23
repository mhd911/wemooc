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

package com.liferay.lms.model.impl;

import com.liferay.lms.model.Course;
import com.liferay.lms.model.CourseModel;
import com.liferay.lms.model.CourseSoap;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The base model implementation for the Course service. Represents a row in the &quot;Lms_Course&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.lms.model.CourseModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CourseImpl}.
 * </p>
 *
 * @author TLS
 * @see CourseImpl
 * @see com.liferay.lms.model.Course
 * @see com.liferay.lms.model.CourseModel
 * @generated
 */
public class CourseModelImpl extends BaseModelImpl<Course>
	implements CourseModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a course model instance should use the {@link com.liferay.lms.model.Course} interface instead.
	 */
	public static final String TABLE_NAME = "Lms_Course";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "courseId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "groupCreatedId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP },
			{ "title", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "friendlyURL", Types.VARCHAR },
			{ "startDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "icon", Types.BIGINT },
			{ "CourseEvalId", Types.BIGINT },
			{ "CourseExtraData", Types.VARCHAR },
			{ "closed", Types.BOOLEAN },
			{ "maxusers", Types.BIGINT },
			{ "calificationType", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Lms_Course (uuid_ VARCHAR(75) null,courseId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,groupCreatedId LONG,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,title STRING null,description STRING null,friendlyURL VARCHAR(75) null,startDate DATE null,endDate DATE null,icon LONG,CourseEvalId LONG,CourseExtraData TEXT null,closed BOOLEAN,maxusers LONG,calificationType LONG)";
	public static final String TABLE_SQL_DROP = "drop table Lms_Course";
	public static final String ORDER_BY_JPQL = " ORDER BY course.courseId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Lms_Course.courseId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.lms.model.Course"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.lms.model.Course"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.lms.model.Course"),
			true);
	public static long CLOSED_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long GROUPCREATEDID_COLUMN_BITMASK = 4L;
	public static long GROUPID_COLUMN_BITMASK = 8L;
	public static long USERID_COLUMN_BITMASK = 16L;
	public static long UUID_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Course toModel(CourseSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Course model = new CourseImpl();

		model.setUuid(soapModel.getUuid());
		model.setCourseId(soapModel.getCourseId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setGroupCreatedId(soapModel.getGroupCreatedId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());
		model.setTitle(soapModel.getTitle());
		model.setDescription(soapModel.getDescription());
		model.setFriendlyURL(soapModel.getFriendlyURL());
		model.setStartDate(soapModel.getStartDate());
		model.setEndDate(soapModel.getEndDate());
		model.setIcon(soapModel.getIcon());
		model.setCourseEvalId(soapModel.getCourseEvalId());
		model.setCourseExtraData(soapModel.getCourseExtraData());
		model.setClosed(soapModel.getClosed());
		model.setMaxusers(soapModel.getMaxusers());
		model.setCalificationType(soapModel.getCalificationType());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Course> toModels(CourseSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Course> models = new ArrayList<Course>(soapModels.length);

		for (CourseSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.lms.model.Course"));

	public CourseModelImpl() {
	}

	public long getPrimaryKey() {
		return _courseId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCourseId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_courseId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Course.class;
	}

	public String getModelClassName() {
		return Course.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("courseId", getCourseId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("groupCreatedId", getGroupCreatedId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("friendlyURL", getFriendlyURL());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("icon", getIcon());
		attributes.put("CourseEvalId", getCourseEvalId());
		attributes.put("CourseExtraData", getCourseExtraData());
		attributes.put("closed", getClosed());
		attributes.put("maxusers", getMaxusers());
		attributes.put("calificationType", getCalificationType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long groupCreatedId = (Long)attributes.get("groupCreatedId");

		if (groupCreatedId != null) {
			setGroupCreatedId(groupCreatedId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String friendlyURL = (String)attributes.get("friendlyURL");

		if (friendlyURL != null) {
			setFriendlyURL(friendlyURL);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long icon = (Long)attributes.get("icon");

		if (icon != null) {
			setIcon(icon);
		}

		Long CourseEvalId = (Long)attributes.get("CourseEvalId");

		if (CourseEvalId != null) {
			setCourseEvalId(CourseEvalId);
		}

		String CourseExtraData = (String)attributes.get("CourseExtraData");

		if (CourseExtraData != null) {
			setCourseExtraData(CourseExtraData);
		}

		Boolean closed = (Boolean)attributes.get("closed");

		if (closed != null) {
			setClosed(closed);
		}

		Long maxusers = (Long)attributes.get("maxusers");

		if (maxusers != null) {
			setMaxusers(maxusers);
		}

		Long calificationType = (Long)attributes.get("calificationType");

		if (calificationType != null) {
			setCalificationType(calificationType);
		}
	}

	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_columnBitmask = -1L;

		_courseId = courseId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getGroupCreatedId() {
		return _groupCreatedId;
	}

	public void setGroupCreatedId(long groupCreatedId) {
		_columnBitmask |= GROUPCREATEDID_COLUMN_BITMASK;

		if (!_setOriginalGroupCreatedId) {
			_setOriginalGroupCreatedId = true;

			_originalGroupCreatedId = _groupCreatedId;
		}

		_groupCreatedId = groupCreatedId;
	}

	public long getOriginalGroupCreatedId() {
		return _originalGroupCreatedId;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public String getTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId);
	}

	public String getTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId, useDefault);
	}

	public String getTitle(String languageId) {
		return LocalizationUtil.getLocalization(getTitle(), languageId);
	}

	public String getTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getTitle(), languageId,
			useDefault);
	}

	public String getTitleCurrentLanguageId() {
		return _titleCurrentLanguageId;
	}

	@JSON
	public String getTitleCurrentValue() {
		Locale locale = getLocale(_titleCurrentLanguageId);

		return getTitle(locale);
	}

	public Map<Locale, String> getTitleMap() {
		return LocalizationUtil.getLocalizationMap(getTitle());
	}

	public void setTitle(String title) {
		_title = title;
	}

	public void setTitle(String title, Locale locale) {
		setTitle(title, locale, LocaleUtil.getDefault());
	}

	public void setTitle(String title, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(title)) {
			setTitle(LocalizationUtil.updateLocalization(getTitle(), "Title",
					title, languageId, defaultLanguageId));
		}
		else {
			setTitle(LocalizationUtil.removeLocalization(getTitle(), "Title",
					languageId));
		}
	}

	public void setTitleCurrentLanguageId(String languageId) {
		_titleCurrentLanguageId = languageId;
	}

	public void setTitleMap(Map<Locale, String> titleMap) {
		setTitleMap(titleMap, LocaleUtil.getDefault());
	}

	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale) {
		if (titleMap == null) {
			return;
		}

		Locale[] locales = LanguageUtil.getAvailableLocales();

		for (Locale locale : locales) {
			String title = titleMap.get(locale);

			setTitle(title, locale, defaultLocale);
		}
	}

	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDescription(), languageId,
			useDefault);
	}

	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@JSON
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	public void setDescription(String description) {
		_description = description;
	}

	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	public void setDescription(String description, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale) {
		if (descriptionMap == null) {
			return;
		}

		Locale[] locales = LanguageUtil.getAvailableLocales();

		for (Locale locale : locales) {
			String description = descriptionMap.get(locale);

			setDescription(description, locale, defaultLocale);
		}
	}

	public String getFriendlyURL() {
		if (_friendlyURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _friendlyURL;
		}
	}

	public void setFriendlyURL(String friendlyURL) {
		_friendlyURL = friendlyURL;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public long getIcon() {
		return _icon;
	}

	public void setIcon(long icon) {
		_icon = icon;
	}

	public long getCourseEvalId() {
		return _CourseEvalId;
	}

	public void setCourseEvalId(long CourseEvalId) {
		_CourseEvalId = CourseEvalId;
	}

	public String getCourseExtraData() {
		if (_CourseExtraData == null) {
			return StringPool.BLANK;
		}
		else {
			return _CourseExtraData;
		}
	}

	public void setCourseExtraData(String CourseExtraData) {
		_CourseExtraData = CourseExtraData;
	}

	public boolean getClosed() {
		return _closed;
	}

	public boolean isClosed() {
		return _closed;
	}

	public void setClosed(boolean closed) {
		_columnBitmask |= CLOSED_COLUMN_BITMASK;

		if (!_setOriginalClosed) {
			_setOriginalClosed = true;

			_originalClosed = _closed;
		}

		_closed = closed;
	}

	public boolean getOriginalClosed() {
		return _originalClosed;
	}

	public long getMaxusers() {
		return _maxusers;
	}

	public void setMaxusers(long maxusers) {
		_maxusers = maxusers;
	}

	public long getCalificationType() {
		return _calificationType;
	}

	public void setCalificationType(long calificationType) {
		_calificationType = calificationType;
	}

	/**
	 * @deprecated {@link #isApproved}
	 */
	public boolean getApproved() {
		return isApproved();
	}

	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDraft() {
		if ((getStatus() == WorkflowConstants.STATUS_DRAFT) ||
				(getStatus() == WorkflowConstants.STATUS_DRAFT_FROM_APPROVED)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Course.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		setTitle(getTitle(defaultImportLocale), defaultImportLocale,
			defaultImportLocale);
		setDescription(getDescription(defaultImportLocale),
			defaultImportLocale, defaultImportLocale);
	}

	@Override
	public Course toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Course)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		CourseImpl courseImpl = new CourseImpl();

		courseImpl.setUuid(getUuid());
		courseImpl.setCourseId(getCourseId());
		courseImpl.setCompanyId(getCompanyId());
		courseImpl.setGroupId(getGroupId());
		courseImpl.setUserId(getUserId());
		courseImpl.setUserName(getUserName());
		courseImpl.setGroupCreatedId(getGroupCreatedId());
		courseImpl.setCreateDate(getCreateDate());
		courseImpl.setModifiedDate(getModifiedDate());
		courseImpl.setStatus(getStatus());
		courseImpl.setStatusByUserId(getStatusByUserId());
		courseImpl.setStatusByUserName(getStatusByUserName());
		courseImpl.setStatusDate(getStatusDate());
		courseImpl.setTitle(getTitle());
		courseImpl.setDescription(getDescription());
		courseImpl.setFriendlyURL(getFriendlyURL());
		courseImpl.setStartDate(getStartDate());
		courseImpl.setEndDate(getEndDate());
		courseImpl.setIcon(getIcon());
		courseImpl.setCourseEvalId(getCourseEvalId());
		courseImpl.setCourseExtraData(getCourseExtraData());
		courseImpl.setClosed(getClosed());
		courseImpl.setMaxusers(getMaxusers());
		courseImpl.setCalificationType(getCalificationType());

		courseImpl.resetOriginalValues();

		return courseImpl;
	}

	public int compareTo(Course course) {
		int value = 0;

		if (getCourseId() < course.getCourseId()) {
			value = -1;
		}
		else if (getCourseId() > course.getCourseId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Course course = null;

		try {
			course = (Course)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = course.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		CourseModelImpl courseModelImpl = this;

		courseModelImpl._originalUuid = courseModelImpl._uuid;

		courseModelImpl._originalCompanyId = courseModelImpl._companyId;

		courseModelImpl._setOriginalCompanyId = false;

		courseModelImpl._originalGroupId = courseModelImpl._groupId;

		courseModelImpl._setOriginalGroupId = false;

		courseModelImpl._originalUserId = courseModelImpl._userId;

		courseModelImpl._setOriginalUserId = false;

		courseModelImpl._originalGroupCreatedId = courseModelImpl._groupCreatedId;

		courseModelImpl._setOriginalGroupCreatedId = false;

		courseModelImpl._originalClosed = courseModelImpl._closed;

		courseModelImpl._setOriginalClosed = false;

		courseModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Course> toCacheModel() {
		CourseCacheModel courseCacheModel = new CourseCacheModel();

		courseCacheModel.uuid = getUuid();

		String uuid = courseCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			courseCacheModel.uuid = null;
		}

		courseCacheModel.courseId = getCourseId();

		courseCacheModel.companyId = getCompanyId();

		courseCacheModel.groupId = getGroupId();

		courseCacheModel.userId = getUserId();

		courseCacheModel.userName = getUserName();

		String userName = courseCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			courseCacheModel.userName = null;
		}

		courseCacheModel.groupCreatedId = getGroupCreatedId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			courseCacheModel.createDate = createDate.getTime();
		}
		else {
			courseCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			courseCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			courseCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		courseCacheModel.status = getStatus();

		courseCacheModel.statusByUserId = getStatusByUserId();

		courseCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = courseCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			courseCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			courseCacheModel.statusDate = statusDate.getTime();
		}
		else {
			courseCacheModel.statusDate = Long.MIN_VALUE;
		}

		courseCacheModel.title = getTitle();

		String title = courseCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			courseCacheModel.title = null;
		}

		courseCacheModel.description = getDescription();

		String description = courseCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			courseCacheModel.description = null;
		}

		courseCacheModel.friendlyURL = getFriendlyURL();

		String friendlyURL = courseCacheModel.friendlyURL;

		if ((friendlyURL != null) && (friendlyURL.length() == 0)) {
			courseCacheModel.friendlyURL = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			courseCacheModel.startDate = startDate.getTime();
		}
		else {
			courseCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			courseCacheModel.endDate = endDate.getTime();
		}
		else {
			courseCacheModel.endDate = Long.MIN_VALUE;
		}

		courseCacheModel.icon = getIcon();

		courseCacheModel.CourseEvalId = getCourseEvalId();

		courseCacheModel.CourseExtraData = getCourseExtraData();

		String CourseExtraData = courseCacheModel.CourseExtraData;

		if ((CourseExtraData != null) && (CourseExtraData.length() == 0)) {
			courseCacheModel.CourseExtraData = null;
		}

		courseCacheModel.closed = getClosed();

		courseCacheModel.maxusers = getMaxusers();

		courseCacheModel.calificationType = getCalificationType();

		return courseCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", courseId=");
		sb.append(getCourseId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", groupCreatedId=");
		sb.append(getGroupCreatedId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", friendlyURL=");
		sb.append(getFriendlyURL());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", icon=");
		sb.append(getIcon());
		sb.append(", CourseEvalId=");
		sb.append(getCourseEvalId());
		sb.append(", CourseExtraData=");
		sb.append(getCourseExtraData());
		sb.append(", closed=");
		sb.append(getClosed());
		sb.append(", maxusers=");
		sb.append(getMaxusers());
		sb.append(", calificationType=");
		sb.append(getCalificationType());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("com.liferay.lms.model.Course");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseId</column-name><column-value><![CDATA[");
		sb.append(getCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupCreatedId</column-name><column-value><![CDATA[");
		sb.append(getGroupCreatedId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>friendlyURL</column-name><column-value><![CDATA[");
		sb.append(getFriendlyURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>icon</column-name><column-value><![CDATA[");
		sb.append(getIcon());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CourseEvalId</column-name><column-value><![CDATA[");
		sb.append(getCourseEvalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CourseExtraData</column-name><column-value><![CDATA[");
		sb.append(getCourseExtraData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>closed</column-name><column-value><![CDATA[");
		sb.append(getClosed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxusers</column-name><column-value><![CDATA[");
		sb.append(getMaxusers());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>calificationType</column-name><column-value><![CDATA[");
		sb.append(getCalificationType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Course.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Course.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _courseId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private long _groupCreatedId;
	private long _originalGroupCreatedId;
	private boolean _setOriginalGroupCreatedId;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private String _title;
	private String _titleCurrentLanguageId;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private String _friendlyURL;
	private Date _startDate;
	private Date _endDate;
	private long _icon;
	private long _CourseEvalId;
	private String _CourseExtraData;
	private boolean _closed;
	private boolean _originalClosed;
	private boolean _setOriginalClosed;
	private long _maxusers;
	private long _calificationType;
	private long _columnBitmask;
	private Course _escapedModelProxy;
}