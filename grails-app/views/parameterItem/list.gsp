
<%@ page import="ru.agora.spot.model.ParameterItem" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'parameterItem.label', default: 'ParameterItem')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-parameterItem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-parameterItem" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'parameterItem.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="value" title="${message(code: 'parameterItem.value.label', default: 'Value')}" />
					
						<g:sortableColumn property="type" title="${message(code: 'parameterItem.type.label', default: 'Type')}" />
					
						<th><g:message code="parameterItem.parameter.label" default="Parameter" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${parameterItemInstanceList}" status="i" var="parameterItemInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${parameterItemInstance.id}">${fieldValue(bean: parameterItemInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: parameterItemInstance, field: "value")}</td>
					
						<td>${fieldValue(bean: parameterItemInstance, field: "type")}</td>
					
						<td>${fieldValue(bean: parameterItemInstance, field: "parameter")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${parameterItemInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
