<%@ page import="ru.agora.spot.model.sale.SaleItem" %>



<div class="fieldcontain ${hasErrors(bean: saleItemInstance, field: 'sale', 'error')} required">
	<label for="sale">
		<g:message code="saleItem.sale.label" default="Sale" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="sale" name="sale.id" from="${ru.agora.spot.model.sale.Sale.list()}" optionKey="id" required="" value="${saleItemInstance?.sale?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: saleItemInstance, field: 'stuff', 'error')} required">
	<label for="stuff">
		<g:message code="saleItem.stuff.label" default="Stuff" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="stuff" name="stuff.id" from="${ru.agora.spot.model.Stuff.list()}" optionKey="id" required="" value="${saleItemInstance?.stuff?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: saleItemInstance, field: 'count', 'error')} required">
	<label for="count">
		<g:message code="saleItem.count.label" default="Count" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="count" type="number" value="${saleItemInstance.count}" required=""/>
</div>

