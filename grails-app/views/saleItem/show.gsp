
<%@ page import="ru.agora.spot.model.sale.SaleItem" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'saleItem.label', default: 'SaleItem')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-saleItem" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-saleItem" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list saleItem">
			
				<g:if test="${saleItemInstance?.sale}">
				<li class="fieldcontain">
					<span id="sale-label" class="property-label"><g:message code="saleItem.sale.label" default="Sale" /></span>
					
						<span class="property-value" aria-labelledby="sale-label"><g:link controller="sale" action="show" id="${saleItemInstance?.sale?.id}">${saleItemInstance?.sale?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${saleItemInstance?.stuff}">
				<li class="fieldcontain">
					<span id="stuff-label" class="property-label"><g:message code="saleItem.stuff.label" default="Stuff" /></span>
					
						<span class="property-value" aria-labelledby="stuff-label"><g:link controller="stuff" action="show" id="${saleItemInstance?.stuff?.id}">${saleItemInstance?.stuff?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${saleItemInstance?.id}" />
					<g:link class="edit" action="edit" id="${saleItemInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
