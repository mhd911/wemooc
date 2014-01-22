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

import com.liferay.lms.model.CourseResult;
import com.liferay.lms.model.CourseResultModel;
import com.liferay.lms.model.CourseResultSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CourseResult service. Represents a row in the &quot;Lms_CourseResult&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.lms.model.CourseResultModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CourseResultImpl}.
 * </p>
 *
 * @author TLS
 * @see CourseResultImpl
 * @see com.liferay.lms.model.CourseResult
 * @see com.liferay.lms.model.CourseResultModel
 * @generated
 */
public class CourseResultModelImpl extends BaseModelImpl<CourseResult>
	implements CourseResultModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a course result model instance should use the {@link com.liferay.lms.model.CourseResult} interface instead.
	 */
	public static final String TABLE_NAME = "Lms_CourseResult";
	public static final Object[][] TABLE_COLUMNS = {
			{ "crId", Types.BIGINT },
			{ "courseId", Types.BIGINT },
			{ "result", Types.BIGINT },
			{ "comments", Types.VARCHAR },
			{ "userId", Types.BIGINT },
			{ "passed", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table Lms_CourseResult (crId LONG not null primary key,courseId LONG,result LONG,comments VARCHAR(75) null,userId LONG,passed BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table Lms_CourseResult";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.lms.model.CourseResult"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.lms.model.CourseResult"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.lms.model.CourseResult"),
			true);
	public static long COURSEID_COLUMN_BITMASK = 1L;
	public static long PASSED_COLUMN_BITMASK = 2L;
	public static long USERID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CourseResult toModel(CourseResultSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CourseResult model = new CourseResultImpl();

		model.setCrId(soapModel.getCrId());
		model.setCourseId(soapModel.getCourseId());
		model.setResult(soapModel.getResult());
		model.setComments(soapModel.getComments());
		model.setUserId(soapModel.getUserId());
		model.setPassed(soapModel.getPassed());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CourseResult> toModels(CourseResultSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CourseResult> models = new ArrayList<CourseResult>(soapModels.length);

		for (CourseResultSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.lms.model.CourseResult"));

	public CourseResultModelImpl() {
	}

	public long getPrimaryKey() {
		return _crId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCrId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_crId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return CourseResult.class;
	}

	public String getModelClassName() {
		return CourseResult.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("crId", getCrId());
		attributes.put("courseId", getCourseId());
		attributes.put("result", getResult());
		attributes.put("comments", getComments());
		attributes.put("userId", getUserId());
		attributes.put("passed", getPassed());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long crId = (Long)attributes.get("crId");

		if (crId != null) {
			setCrId(crId);
		}

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Long result = (Long)attributes.get("result");

		if (result != null) {
			setResult(result);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Boolean passed = (Boolean)attributes.get("passed");

		if (passed != null) {
			setPassed(passed);
		}
	}

	public long getCrId() {
		return _crId;
	}

	public void setCrId(long crId) {
		_crId = crId;
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_columnBitmask |= COURSEID_COLUMN_BITMASK;

		if (!_setOriginalCourseId) {
			_setOriginalCourseId = true;

			_originalCourseId = _courseId;
		}

		_courseId = courseId;
	}

	public long getOriginalCourseId() {
		return _originalCourseId;
	}

	public long getResult() {
		return _result;
	}

	public void setResult(long result) {
		_result = result;
	}

	public String getComments() {
		if (_comments == null) {
			return StringPool.BLANK;
		}
		else {
			return _comments;
		}
	}

	public void setComments(String comments) {
		_comments = comments;
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

	public boolean getPassed() {
		return _passed;
	}

	public boolean isPassed() {
		return _passed;
	}

	public void setPassed(boolean passed) {
		_columnBitmask |= PASSED_COLUMN_BITMASK;

		if (!_setOriginalPassed) {
			_setOriginalPassed = true;

			_originalPassed = _passed;
		}

		_passed = passed;
	}

	public boolean getOriginalPassed() {
		return _originalPassed;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			CourseResult.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CourseResult toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (CourseResult)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		CourseResultImpl courseResultImpl = new CourseResultImpl();

		courseResultImpl.setCrId(getCrId());
		courseResultImpl.setCourseId(getCourseId());
		courseResultImpl.setResult(getResult());
		courseResultImpl.setComments(getComments());
		courseResultImpl.setUserId(getUserId());
		courseResultImpl.setPassed(getPassed());

		courseResultImpl.resetOriginalValues();

		return courseResultImpl;
	}

	public int compareTo(CourseResult courseResult) {
		long primaryKey = courseResult.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CourseResult courseResult = null;

		try {
			courseResult = (CourseResult)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = courseResult.getPrimaryKey();

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
		CourseResultModelImpl courseResultModelImpl = this;

		courseResultModelImpl._originalCourseId = courseResultModelImpl._courseId;

		courseResultModelImpl._setOriginalCourseId = false;

		courseResultModelImpl._originalUserId = courseResultModelImpl._userId;

		courseResultModelImpl._setOriginalUserId = false;

		courseResultModelImpl._originalPassed = courseResultModelImpl._passed;

		courseResultModelImpl._setOriginalPassed = false;

		courseResultModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CourseResult> toCacheModel() {
		CourseResultCacheModel courseResultCacheModel = new CourseResultCacheModel();

		courseResultCacheModel.crId = getCrId();

		courseResultCacheModel.courseId = getCourseId();

		courseResultCacheModel.result = getResult();

		courseResultCacheModel.comments = getComments();

		String comments = courseResultCacheModel.comments;

		if ((comments != null) && (comments.length() == 0)) {
			courseResultCacheModel.comments = null;
		}

		courseResultCacheModel.userId = getUserId();

		courseResultCacheModel.passed = getPassed();

		return courseResultCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{crId=");
		sb.append(getCrId());
		sb.append(", courseId=");
		sb.append(getCourseId());
		sb.append(", result=");
		sb.append(getResult());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", passed=");
		sb.append(getPassed());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.lms.model.CourseResult");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>crId</column-name><column-value><![CDATA[");
		sb.append(getCrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseId</column-name><column-value><![CDATA[");
		sb.append(getCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>result</column-name><column-value><![CDATA[");
		sb.append(getResult());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passed</column-name><column-value><![CDATA[");
		sb.append(getPassed());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CourseResult.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			CourseResult.class
		};
	private long _crId;
	private long _courseId;
	private long _originalCourseId;
	private boolean _setOriginalCourseId;
	private long _result;
	private String _comments;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private boolean _passed;
	private boolean _originalPassed;
	private boolean _setOriginalPassed;
	private long _columnBitmask;
	private CourseResult _escapedModelProxy;
}