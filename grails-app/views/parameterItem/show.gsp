
<%@ page import="ru.agora.spot.model.ParameterItem" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'parameterItem.label', default: 'ParameterItem')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-parameterItem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-parameterItem" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list parameterItem">
			
				<g:if test="${parameterItemInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="parameterItem.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${parameterItemInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${parameterItemInstance?.value}">
				<li class="fieldcontain">
					<span id="value-label" class="property-label"><g:message code="parameterItem.value.label" default="Value" /></span>
					
						<span class="property-value" aria-labelledby="value-label"><g:fieldValue bean="${parameterItemInstance}" field="value"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${parameterItemInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="property-label"><g:message code="parameterItem.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${parameterItemInstance}" field="type"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${parameterItemInstance?.parameter}">
				<li class="fieldcontain">
					<span id="parameter-label" class="property-label"><g:message code="parameterItem.parameter.label" default="Parameter" /></span>
					
						<span class="property-value" aria-labelledby="parameter-label"><g:link controller="parameter" action="show" id="${parameterItemInstance?.parameter?.id}">${parameterItemInstance?.parameter?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${parameterItemInstance?.id}" />
					<g:link class="edit" action="edit" id="${parameterItemInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
