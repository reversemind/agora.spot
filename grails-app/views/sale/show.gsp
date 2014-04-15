
<%@ page import="ru.agora.spot.model.sale.Sale" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'sale.label', default: 'Sale')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-sale" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-sale" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list sale">
			
				<g:if test="${saleInstance?.author}">
				<li class="fieldcontain">
					<span id="author-label" class="property-label"><g:message code="sale.author.label" default="Author" /></span>
					
						<span class="property-value" aria-labelledby="author-label"><g:link controller="user" action="show" id="${saleInstance?.author?.id}">${saleInstance?.author?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${saleInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="sale.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${saleInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${saleInstance?.start}">
				<li class="fieldcontain">
					<span id="start-label" class="property-label"><g:message code="sale.start.label" default="Start" /></span>
					
						<span class="property-value" aria-labelledby="start-label"><g:formatDate date="${saleInstance?.start}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${saleInstance?.stop}">
				<li class="fieldcontain">
					<span id="stop-label" class="property-label"><g:message code="sale.stop.label" default="Stop" /></span>
					
						<span class="property-value" aria-labelledby="stop-label"><g:formatDate date="${saleInstance?.stop}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${saleInstance?.saleItems}">
				<li class="fieldcontain">
					<span id="saleItems-label" class="property-label"><g:message code="sale.saleItems.label" default="Sale Items" /></span>
					
						<g:each in="${saleInstance.saleItems}" var="s">
						<span class="property-value" aria-labelledby="saleItems-label"><g:link controller="saleItem" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${saleInstance?.id}" />
					<g:link class="edit" action="edit" id="${saleInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
