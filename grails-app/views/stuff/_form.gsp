<%@ page import="ru.agora.spot.model.Stuff" %>



<div class="fieldcontain ${hasErrors(bean: stuffInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="stuff.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${stuffInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: stuffInstance, field: 'brand', 'error')} ">
	<label for="brand">
		<g:message code="stuff.brand.label" default="Brand" />
		
	</label>
	<g:select id="brand" name="brand.id" from="${ru.agora.spot.model.Brand.list()}" optionKey="id" value="${stuffInstance?.brand?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: stuffInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="stuff.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" value="${fieldValue(bean: stuffInstance, field: 'price')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: stuffInstance, field: 'parameters', 'error')} ">
	<label for="parameters">
		<g:message code="stuff.parameters.label" default="Parameters" />
		
	</label>
	<g:select name="parameters" from="${ru.agora.spot.model.Parameter.list()}" multiple="multiple" optionKey="id" size="5" value="${stuffInstance?.parameters*.id}" class="many-to-many"/>
</div>

