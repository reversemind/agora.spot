<%@ page import="ru.agora.spot.model.customer.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="user.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${userInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		
	</label>
	<g:textField name="password" value="${userInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'roles', 'error')} required">
	<label for="roles">
		<g:message code="user.roles.label" default="Roles" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="roles" from="${ru.agora.spot.model.customer.Role.list()}" multiple="multiple" optionKey="id" size="5" required="" value="${userInstance?.roles*.id}" class="many-to-many"/>
</div>

