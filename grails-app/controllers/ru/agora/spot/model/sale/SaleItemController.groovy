package ru.agora.spot.model.sale

import org.springframework.dao.DataIntegrityViolationException

class SaleItemController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [saleItemInstanceList: SaleItem.list(params), saleItemInstanceTotal: SaleItem.count()]
    }

    def create() {
        [saleItemInstance: new SaleItem(params)]
    }

    def save() {
        def saleItemInstance = new SaleItem(params)
        if (!saleItemInstance.save(flush: true)) {
            render(view: "create", model: [saleItemInstance: saleItemInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'saleItem.label', default: 'SaleItem'), saleItemInstance.id])
        redirect(action: "show", id: saleItemInstance.id)
    }

    def show(String id) {
        def saleItemInstance = SaleItem.get(id)
        if (!saleItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'saleItem.label', default: 'SaleItem'), id])
            redirect(action: "list")
            return
        }

        [saleItemInstance: saleItemInstance]
    }

    def edit(String id) {
        def saleItemInstance = SaleItem.get(id)
        if (!saleItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'saleItem.label', default: 'SaleItem'), id])
            redirect(action: "list")
            return
        }

        [saleItemInstance: saleItemInstance]
    }

    def update(String id, Long version) {
        def saleItemInstance = SaleItem.get(id)
        if (!saleItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'saleItem.label', default: 'SaleItem'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (saleItemInstance.version > version) {
                saleItemInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'saleItem.label', default: 'SaleItem')] as Object[],
                          "Another user has updated this SaleItem while you were editing")
                render(view: "edit", model: [saleItemInstance: saleItemInstance])
                return
            }
        }

        saleItemInstance.properties = params

        if (!saleItemInstance.save(flush: true)) {
            render(view: "edit", model: [saleItemInstance: saleItemInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'saleItem.label', default: 'SaleItem'), saleItemInstance.id])
        redirect(action: "show", id: saleItemInstance.id)
    }

    def delete(String id) {
        def saleItemInstance = SaleItem.get(id)
        if (!saleItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'saleItem.label', default: 'SaleItem'), id])
            redirect(action: "list")
            return
        }

        try {
            saleItemInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'saleItem.label', default: 'SaleItem'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'saleItem.label', default: 'SaleItem'), id])
            redirect(action: "show", id: id)
        }
    }
}
