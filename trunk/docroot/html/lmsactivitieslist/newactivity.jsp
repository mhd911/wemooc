<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.lms.learningactivity.LearningActivityTypeRegistry"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetRendererFactory"%>
<%@page import="com.liferay.portal.security.permission.ResourceActionsUtil"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>

<%@ include file="/init.jsp"%>

<link href='http://fonts.googleapis.com/css?family=Nunito:400,300,700' rel='stylesheet' type='text/css'>

<ul class="activity-list">
<%
AssetRendererFactory arf=AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(LearningActivity.class.getName());
Map<Long,String> classTypes=arf.getClassTypes(new long[0], themeDisplay.getLocale());
LearningActivityTypeRegistry learningActivityTypeRegistry = new LearningActivityTypeRegistry();
String blacklistProp = PropsUtil.get("lms.learningactivity.invisibles");
List<String> blacklist = new ArrayList<String>();
if (blacklistProp != null) {
	String[] blacklistArray = blacklistProp.split(",");
	if (blacklistArray != null) {
		blacklist = ListUtil.fromArray(blacklistArray);
	}
}
for(Long key:classTypes.keySet())
{
	if (blacklist.contains(key.toString())) {
		break;
	}
	String classname=classTypes.get(key);
%>	
	<liferay-portlet:actionURL name="editactivityoptions" var="newactivityURL">
		<liferay-portlet:param name="resId" value="0" />
		<liferay-portlet:param name="resModuleId" value="<%=ParamUtil.getString(renderRequest, \"resModuleId\") %>" />
		<liferay-portlet:param name="type" value="<%=key.toString() %>" />
	</liferay-portlet:actionURL>
	
	<liferay-util:buffer var="activityMessage">
	    <%=classTypes.get(key) %>
	    <span class="activity-help">
			<liferay-ui:icon-help message="<%=learningActivityTypeRegistry.getLearningActivityType(key).getDescription() %>"  />
		</span>
	</liferay-util:buffer>

	<li class="activity_<%=key%>">
		<liferay-ui:icon image="add" label="<%=true%>" message="<%=activityMessage %>" url="<%=newactivityURL%>" cssClass="activity-icon" />
	</li>
<%
}
%>
</ul>
