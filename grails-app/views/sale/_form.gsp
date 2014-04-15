<%@ page import="ru.agora.spot.model.sale.Sale" %>



<div class="fieldcontain ${hasErrors(bean: saleInstance, field: 'author', 'error')} required">
	<label for="author">
		<g:message code="sale.author.label" default="Author" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="author" name="author.id" from="${ru.agora.spot.model.customer.User.list()}" optionKey="id" required="" value="${saleInstance?.author?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: saleInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="sale.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${saleInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: saleInstance, field: 'start', 'error')} required">
	<label for="start">
		<g:message code="sale.start.label" default="Start" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="start" precision="day"  value="${saleInstance?.start}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: saleInstance, field: 'stop', 'error')} required">
	<label for="stop">
		<g:message code="sale.stop.label" default="Stop" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="stop" precision="day"  value="${saleInstance?.stop}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: saleInstance, field: 'saleItems', 'error')} ">
	<label for="saleItems">
		<g:message code="sale.saleItems.label" default="Sale Items" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${saleInstance?.saleItems?}" var="s">
    <li><g:link controller="saleItem" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="saleItem" action="create" params="['sale.id': saleInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'saleItem.label', default: 'SaleItem')])}</g:link>
</li>
</ul>

</div>

