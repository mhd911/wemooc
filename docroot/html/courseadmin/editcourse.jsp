<%@page import="com.liferay.portal.model.LayoutSetPrototype"%>
<%@page import="com.liferay.portal.service.LayoutSetPrototypeLocalServiceUtil"%>
<%@page import="com.liferay.lms.service.LmsPrefsLocalServiceUtil"%>
<%@page import="com.liferay.lms.learningactivity.courseeval.CourseEval"%>
<%@page import="com.liferay.lms.learningactivity.courseeval.CourseEvalRegistry"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.util.JavaScriptUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.lms.model.Module"%>
<%@page import="com.liferay.lms.service.ModuleLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.lms.service.CourseLocalServiceUtil"%>
<%@page import="com.liferay.lms.service.CourseServiceUtil"%>
<%@page import="com.liferay.lms.model.Course"%>

<%@ include file="/init.jsp" %>

<portlet:actionURL var="savecourseURL" name="saveCourse" />
<portlet:renderURL var="cancel" />

<a href="<%=cancel.toString()%>"><liferay-ui:message key="back" /></a>
<%

String publishPermission="PUBLISH";
String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL");

String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");
long courseId=ParamUtil.getLong(request, "courseId",0);
Course course=null;
if(request.getAttribute("course")!=null)
{
	course=(Course)request.getAttribute("course");
}
else
{
	if(courseId>0)
	{
		course=CourseLocalServiceUtil.getCourse(courseId);
	}
}	


String description="";
SimpleDateFormat formatDay = new SimpleDateFormat("dd");
SimpleDateFormat formatMonth = new SimpleDateFormat("MM");
SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
SimpleDateFormat formatHour = new SimpleDateFormat("HH");
SimpleDateFormat formatMin = new SimpleDateFormat("mm");
Date today=new Date(System.currentTimeMillis());
int startDay=Integer.parseInt(formatDay.format(today));
int startMonth=Integer.parseInt(formatMonth.format(today))-1;
int startYear=Integer.parseInt(formatYear.format(today));
int startHour=Integer.parseInt(formatHour.format(today));
int startMin=Integer.parseInt(formatMin.format(today));
int endDay=Integer.parseInt(formatDay.format(today));
int endMonth=Integer.parseInt(formatMonth.format(today))-1;
int endYear=Integer.parseInt(formatYear.format(today))+1;
int endHour=Integer.parseInt(formatHour.format(today));
int endMin=Integer.parseInt(formatMin.format(today));
String summary="";
AssetEntry entry=null;
boolean visibleencatalogo=false;
if(course!=null)
{
	entry=AssetEntryLocalServiceUtil.getEntry(Course.class.getName(),course.getCourseId());
	visibleencatalogo=entry.getVisible();
	summary=entry.getSummary();
	courseId=course.getCourseId();
	description=course.getDescription(themeDisplay.getLocale());
	startDay=Integer.parseInt(formatDay.format(course.getStartDate()));
	startMonth=Integer.parseInt(formatMonth.format(course.getStartDate()))-1;
	startYear=Integer.parseInt(formatYear.format(course.getStartDate()));
	startHour=Integer.parseInt(formatHour.format(course.getStartDate()));
	startMin=Integer.parseInt(formatMin.format(course.getStartDate()));
	endDay=Integer.parseInt(formatDay.format(course.getEndDate()));
	endMonth=Integer.parseInt(formatMonth.format(course.getEndDate()))-1;
	endYear=Integer.parseInt(formatYear.format(course.getEndDate()));
	endHour=Integer.parseInt(formatHour.format(course.getEndDate()));
	endMin=Integer.parseInt(formatMin.format(course.getEndDate()));
	%>
	<aui:model-context bean="<%= course %>" model="<%= Course.class %>" />
	<%
}
else
{
	%>
	<aui:model-context  model="<%= Course.class %>" />
	<%
}
%>

<aui:form name="fm" action="<%=savecourseURL%>"  method="post" >

	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="referringPortletResource" type="hidden" value="<%= referringPortletResource %>" />
	<aui:input name="courseId" type="hidden" value="<%=courseId %>"/>
	<liferay-ui:error key="title-required" message="title-required" />
	<liferay-ui:error key="title-empty" message="title-empty" />
	<aui:input name="title" label="title"></aui:input>
<%
	String value="";
	if(courseId!=0){
		value=course.getFriendlyURL();
	}
%>

	<aui:input name="friendlyURL" label="FriendlyURL" type="hidden" > <%=value %> </aui:input>

<aui:field-wrapper label="description">
			<liferay-ui:input-editor name="description" width="100%" />
			<aui:input name="description" type="hidden" />
				<script type="text/javascript">
        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(description) %>"; }
    </script>
		</aui:field-wrapper>
		
	<c:if test="<%= permissionChecker.hasPermission(themeDisplay.getScopeGroupId(),  Course.class.getName(),0,publishPermission) %>">
		<aui:input type="checkbox" name="visible" label="published-in-catalog" value="<%=visibleencatalogo %>" />
	</c:if>
	<aui:input type="textarea" cols="100" rows="4" name="summary" label="summary" value="<%=summary %>"/>
	
	<aui:select name="courseEvalId" label="course-correction-method">
	<%
	CourseEvalRegistry cer=new CourseEvalRegistry();
	for(CourseEval ce:cer.getCourseEvals())
	{
		boolean selected=false;
		if(course!=null&&course.getCourseEvalId()==ce.getTypeId())
		{
			selected=true;
		}
		
		%>
		<aui:option value="<%=ce.getTypeId() %>" selected="<%=selected %>"><%=ce.getName(locale) %></aui:option>
		<%
	}
	%>
	</aui:select>
	<%
	if(course==null)
	{
		String[] lspist=LmsPrefsLocalServiceUtil.getLmsPrefsIni(themeDisplay.getCompanyId()).getLmsTemplates().split(",");
		%>
		<aui:select name="courseTemplate" label="course-template">
		<%
		for(String lspis:lspist)
		{
			LayoutSetPrototype lsp=LayoutSetPrototypeLocalServiceUtil.getLayoutSetPrototype(Long.parseLong(lspis));
			%>
			<aui:option value="<%=lsp.getLayoutSetPrototypeId() %>" ><%=lsp.getName(themeDisplay.getLocale()) %></aui:option>
			<%
		}
		%>
		</aui:select>
		<%
	}
	%>

	
	<aui:field-wrapper label="start-inscription-date">
		<liferay-ui:input-date yearRangeEnd="2020" yearRangeStart="2012"  dayParam="startDay" monthParam="startMon"
				 yearParam="startYear"  yearNullable="false" dayNullable="false" monthNullable="false" yearValue="<%=startYear %>" monthValue="<%=startMonth %>" dayValue="<%=startDay %>"></liferay-ui:input-date>
		<liferay-ui:input-time minuteParam="startMin" amPmParam="startAMPM" hourParam="startHour" hourValue="<%=startHour %>" minuteValue="<%=startMin %>"></liferay-ui:input-time>
	</aui:field-wrapper>
	<aui:field-wrapper label="end-inscription-date">
		<liferay-ui:input-date yearRangeEnd="2020" yearRangeStart="2012" dayParam="stopDay" monthParam="stopMon"
				 yearParam="stopYear"  yearNullable="false" dayNullable="false" monthNullable="false"  yearValue="<%=endYear %>" monthValue="<%=endMonth %>" dayValue="<%=endDay %>"></liferay-ui:input-date>
		 <liferay-ui:input-time minuteParam="stopMin" amPmParam="stopAMPM" hourParam="stopHour"  hourValue="<%=endHour %>" minuteValue="<%=endMin %>"></liferay-ui:input-time></br>
	</aui:field-wrapper>
	<liferay-ui:custom-attributes-available className="<%= Course.class.getName() %>">
		<liferay-ui:custom-attribute-list 
			className="<%=com.liferay.lms.model.Course.class.getName()%>" classPK="<%=courseId %>" editable="true" label="true"></liferay-ui:custom-attribute-list>
	</liferay-ui:custom-attributes-available>
	<aui:input name="tags" type="assetTags" />
	<aui:input name="categories" type="assetCategories" />
	<aui:button-row>
	<%
		String extractCodeFromEditor = renderResponse.getNamespace() + "extractCodeFromEditor()";
	%>									
		<aui:button type="submit" onClick="<%=extractCodeFromEditor%>"></aui:button>
		<aui:button onClick="<%=cancel %>" type="cancel" />
	</aui:button-row>
</aui:form>