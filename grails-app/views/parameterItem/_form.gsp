<%@ page import="ru.agora.spot.model.ParameterItem" %>



<div class="fieldcontain ${hasErrors(bean: parameterItemInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="parameterItem.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${parameterItemInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: parameterItemInstance, field: 'value', 'error')} ">
	<label for="value">
		<g:message code="parameterItem.value.label" default="Value" />
		
	</label>
	<g:textField name="value" value="${parameterItemInstance?.value}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: parameterItemInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="parameterItem.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="type" from="${ru.agora.spot.model.ParameterItem$Type?.values()}" keys="${ru.agora.spot.model.ParameterItem$Type.values()*.name()}" required="" value="${parameterItemInstance?.type?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: parameterItemInstance, field: 'parameter', 'error')} required">
	<label for="parameter">
		<g:message code="parameterItem.parameter.label" default="Parameter" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="parameter" name="parameter.id" from="${ru.agora.spot.model.Parameter.list()}" optionKey="id" required="" value="${parameterItemInstance?.parameter?.id}" class="many-to-one"/>
</div>

