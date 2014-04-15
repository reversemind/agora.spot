
<%@ page import="ru.agora.spot.model.sale.SaleItem" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'saleItem.label', default: 'SaleItem')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-saleItem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-saleItem" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="saleItem.sale.label" default="Sale" /></th>
					
						<th><g:message code="saleItem.stuff.label" default="Stuff" /></th>
					
						<g:sortableColumn property="count" title="${message(code: 'saleItem.count.label', default: 'Count')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${saleItemInstanceList}" status="i" var="saleItemInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${saleItemInstance.id}">${fieldValue(bean: saleItemInstance, field: "sale")}</g:link></td>
					
						<td>${fieldValue(bean: saleItemInstance, field: "stuff")}</td>
					
						<td>${fieldValue(bean: saleItemInstance, field: "count")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${saleItemInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
