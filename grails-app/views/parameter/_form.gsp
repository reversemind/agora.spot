<%@ page import="ru.agora.spot.model.Parameter" %>



<div class="fieldcontain ${hasErrors(bean: parameterInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="parameter.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${parameterInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: parameterInstance, field: 'parameterItems', 'error')} ">
	<label for="parameterItems">
		<g:message code="parameter.parameterItems.label" default="Parameter Items" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${parameterInstance?.parameterItems?}" var="p">
    <li><g:link controller="parameterItem" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="parameterItem" action="create" params="['parameter.id': parameterInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'parameterItem.label', default: 'ParameterItem')])}</g:link>
</li>
</ul>

</div>

