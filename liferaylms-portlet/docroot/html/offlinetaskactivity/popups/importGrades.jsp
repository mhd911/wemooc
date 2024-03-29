<%@page import="com.liferay.lms.model.TestQuestion"%>
<%@page import="com.liferay.lms.service.TestQuestionLocalServiceUtil"%>
<%@page import="com.liferay.lms.service.LearningActivityLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.io.FileNotFoundException"%>
<%@ include file="/init.jsp" %>
<%
LearningActivity learnact=null;
if(request.getAttribute("activity")!=null)
{
	
 	learnact=(LearningActivity)request.getAttribute("activity");
}
else
{
	learnact=LearningActivityLocalServiceUtil.getLearningActivity(ParamUtil.getLong(request,"actId"));
}

%>

<portlet:renderURL var="importGradesURL"  windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="actId" value="<%=String.valueOf(learnact.getActId()) %>" /> 
	<portlet:param name="ajaxAction" value="importGrades" /> 
	<portlet:param name="jspPage" value="/html/offlinetaskactivity/popups/importGrades.jsp" /> 
</portlet:renderURL>

<iframe name="<portlet:namespace />import_frame" src="" id="<portlet:namespace />import_frame" style="display:none;" onload="<portlet:namespace />doImportGrades();" ></iframe>
<aui:form name="fm" action="<%=importGradesURL%>"  method="post" enctype="multipart/form-data" target='<%=renderResponse.getNamespace() +"import_frame" %>' >
	<aui:fieldset>
		<aui:field-wrapper label="offlinetaskactivity.file"  helpMessage="offlinetaskactivity.file.help">
	    			<aui:input inlineLabel="left" inlineField="true"
					  	name="fileName" label="" id="fileName" type="file" value="" />
		</aui:field-wrapper>
	</aui:fieldset>
	<aui:button-row>
	<aui:button type="submit" value="offlinetaskactivity.save"></aui:button>
	<button name="Close" value="close" onclick="<portlet:namespace />doClosePopupImportGrades();" type="button">
		<liferay-ui:message key="offlinetaskactivity.cancel" />
	</button>
	</aui:button-row>
	<div id="<portlet:namespace />importErrors" >
	<% List<String> errorsInCSV = (List<String>)renderRequest.getAttribute("errorsInCSV"); 
	   if(errorsInCSV!=null) {
		   if(errorsInCSV.isEmpty()) {
			%>
				<div class="portlet-msg-success"><liferay-ui:message key="offlinetaskactivity.correct.saved" /></div>
			<%		   
		   }
		   else {
		   for(String errorInCSV:errorsInCSV) {
	%>
		<div class="portlet-msg-error"><%=errorInCSV %></div>
	<% }}} %>
	</div>
</aui:form>