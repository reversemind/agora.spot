
<%@ page import="ru.agora.spot.model.Stuff" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'stuff.label', default: 'Stuff')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-stuff" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-stuff" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'stuff.title.label', default: 'Title')}" />
					
						<th><g:message code="stuff.brand.label" default="Brand" /></th>
					
						<g:sortableColumn property="price" title="${message(code: 'stuff.price.label', default: 'Price')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${stuffInstanceList}" status="i" var="stuffInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${stuffInstance.id}">${fieldValue(bean: stuffInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: stuffInstance, field: "brand")}</td>
					
						<td>${fieldValue(bean: stuffInstance, field: "price")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${stuffInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
