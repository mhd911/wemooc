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

package com.liferay.lms.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author TLS
 */
public class CourseServiceClp implements CourseService {
	public CourseServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "getCoursesOfGroup";

		_methodParameterTypes3 = new String[] { "long" };

		_methodName4 = "createCourse";

		_methodParameterTypes4 = new String[] { "java.lang.String" };

		_methodName5 = "getCourseStudents";

		_methodParameterTypes5 = new String[] { "long" };

		_methodName6 = "getCourseTeachers";

		_methodParameterTypes6 = new String[] { "long" };

		_methodName7 = "getCourseEditors";

		_methodParameterTypes7 = new String[] { "long" };

		_methodName8 = "addStudentToCourse";

		_methodParameterTypes8 = new String[] { "long", "java.lang.String" };

		_methodName9 = "addTeacherToCourse";

		_methodParameterTypes9 = new String[] { "long", "java.lang.String" };

		_methodName10 = "addEditorToCourse";

		_methodParameterTypes10 = new String[] { "long", "java.lang.String" };

		_methodName11 = "removeStudentFromCourse";

		_methodParameterTypes11 = new String[] { "long", "java.lang.String" };

		_methodName12 = "removeTeacherFromCourse";

		_methodParameterTypes12 = new String[] { "long", "java.lang.String" };

		_methodName13 = "removeEditorFromCourse";

		_methodParameterTypes13 = new String[] { "long", "java.lang.String" };

		_methodName14 = "getUserResult";

		_methodParameterTypes14 = new String[] { "long", "java.lang.String" };

		_methodName15 = "myCourses";

		_methodParameterTypes15 = new String[] {  };

		_methodName16 = "addUser";

		_methodParameterTypes16 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "boolean"
			};

		_methodName17 = "updateUser";

		_methodParameterTypes17 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "boolean"
			};

		_methodName18 = "setParent";

		_methodParameterTypes18 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName19 = "unsetParent";

		_methodParameterTypes19 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName20 = "setTutor";

		_methodParameterTypes20 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName21 = "unsetTutor";

		_methodParameterTypes21 = new String[] {
				"java.lang.String", "java.lang.String"
			};
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	public java.util.List<com.liferay.lms.model.Course> getCoursesOfGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3, new Object[] { groupId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.lms.model.Course>)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.lms.model.Course createCourse(java.lang.String name) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] { ClpSerializer.translateInput(name) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.lms.model.Course)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<java.lang.String> getCourseStudents(long courseId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5, new Object[] { courseId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<java.lang.String> getCourseTeachers(long courseId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6, new Object[] { courseId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<java.lang.String> getCourseEditors(long courseId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7, new Object[] { courseId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	public void addStudentToCourse(long courseId, java.lang.String login) {
		try {
			_invokableService.invokeMethod(_methodName8,
				_methodParameterTypes8,
				new Object[] { courseId, ClpSerializer.translateInput(login) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addTeacherToCourse(long courseId, java.lang.String login) {
		try {
			_invokableService.invokeMethod(_methodName9,
				_methodParameterTypes9,
				new Object[] { courseId, ClpSerializer.translateInput(login) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addEditorToCourse(long courseId, java.lang.String login) {
		try {
			_invokableService.invokeMethod(_methodName10,
				_methodParameterTypes10,
				new Object[] { courseId, ClpSerializer.translateInput(login) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void removeStudentFromCourse(long courseId, java.lang.String login) {
		try {
			_invokableService.invokeMethod(_methodName11,
				_methodParameterTypes11,
				new Object[] { courseId, ClpSerializer.translateInput(login) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void removeTeacherFromCourse(long courseId, java.lang.String login) {
		try {
			_invokableService.invokeMethod(_methodName12,
				_methodParameterTypes12,
				new Object[] { courseId, ClpSerializer.translateInput(login) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void removeEditorFromCourse(long courseId, java.lang.String login) {
		try {
			_invokableService.invokeMethod(_methodName13,
				_methodParameterTypes13,
				new Object[] { courseId, ClpSerializer.translateInput(login) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public long getUserResult(long courseId, java.lang.String login) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName14,
					_methodParameterTypes14,
					new Object[] { courseId, ClpSerializer.translateInput(login) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public java.util.List<com.liferay.lms.model.Course> myCourses()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName15,
					_methodParameterTypes15, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.lms.model.Course>)ClpSerializer.translateOutput(returnObj);
	}

	public void addUser(java.lang.String login, java.lang.String firstName,
		java.lang.String lastName, java.lang.String email, boolean isStudent,
		boolean isTeacher, boolean isParent) {
		try {
			_invokableService.invokeMethod(_methodName16,
				_methodParameterTypes16,
				new Object[] {
					ClpSerializer.translateInput(login),
					
				ClpSerializer.translateInput(firstName),
					
				ClpSerializer.translateInput(lastName),
					
				ClpSerializer.translateInput(email),
					
				isStudent,
					
				isTeacher,
					
				isParent
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void updateUser(java.lang.String login, java.lang.String firstName,
		java.lang.String lastName, java.lang.String email, boolean isStudent,
		boolean isTeacher, boolean isParent) {
		try {
			_invokableService.invokeMethod(_methodName17,
				_methodParameterTypes17,
				new Object[] {
					ClpSerializer.translateInput(login),
					
				ClpSerializer.translateInput(firstName),
					
				ClpSerializer.translateInput(lastName),
					
				ClpSerializer.translateInput(email),
					
				isStudent,
					
				isTeacher,
					
				isParent
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void setParent(java.lang.String parentLogin,
		java.lang.String studentLogin) {
		try {
			_invokableService.invokeMethod(_methodName18,
				_methodParameterTypes18,
				new Object[] {
					ClpSerializer.translateInput(parentLogin),
					
				ClpSerializer.translateInput(studentLogin)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void unsetParent(java.lang.String parentLogin,
		java.lang.String studentLogin) {
		try {
			_invokableService.invokeMethod(_methodName19,
				_methodParameterTypes19,
				new Object[] {
					ClpSerializer.translateInput(parentLogin),
					
				ClpSerializer.translateInput(studentLogin)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void setTutor(java.lang.String tutorLogin,
		java.lang.String studentLogin) {
		try {
			_invokableService.invokeMethod(_methodName20,
				_methodParameterTypes20,
				new Object[] {
					ClpSerializer.translateInput(tutorLogin),
					
				ClpSerializer.translateInput(studentLogin)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void unsetTutor(java.lang.String parentLogin,
		java.lang.String studentLogin) {
		try {
			_invokableService.invokeMethod(_methodName21,
				_methodParameterTypes21,
				new Object[] {
					ClpSerializer.translateInput(parentLogin),
					
				ClpSerializer.translateInput(studentLogin)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
}