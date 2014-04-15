package ru.agora.spot.model

import org.springframework.dao.DataIntegrityViolationException

class ParameterItemController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [parameterItemInstanceList: ParameterItem.list(params), parameterItemInstanceTotal: ParameterItem.count()]
    }

    def create() {
        [parameterItemInstance: new ParameterItem(params)]
    }

    def save() {
        def parameterItemInstance = new ParameterItem(params)
        if (!parameterItemInstance.save(flush: true)) {
            render(view: "create", model: [parameterItemInstance: parameterItemInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'parameterItem.label', default: 'ParameterItem'), parameterItemInstance.id])
        redirect(action: "show", id: parameterItemInstance.id)
    }

    def show(String id) {
        def parameterItemInstance = ParameterItem.get(id)
        if (!parameterItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'parameterItem.label', default: 'ParameterItem'), id])
            redirect(action: "list")
            return
        }

        [parameterItemInstance: parameterItemInstance]
    }

    def edit(String id) {
        def parameterItemInstance = ParameterItem.get(id)
        if (!parameterItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'parameterItem.label', default: 'ParameterItem'), id])
            redirect(action: "list")
            return
        }

        [parameterItemInstance: parameterItemInstance]
    }

    def update(String id, Long version) {
        def parameterItemInstance = ParameterItem.get(id)
        if (!parameterItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'parameterItem.label', default: 'ParameterItem'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (parameterItemInstance.version > version) {
                parameterItemInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'parameterItem.label', default: 'ParameterItem')] as Object[],
                        "Another user has updated this ParameterItem while you were editing")
                render(view: "edit", model: [parameterItemInstance: parameterItemInstance])
                return
            }
        }

        parameterItemInstance.properties = params

        if (!parameterItemInstance.save(flush: true)) {
            render(view: "edit", model: [parameterItemInstance: parameterItemInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'parameterItem.label', default: 'ParameterItem'), parameterItemInstance.id])
        redirect(action: "show", id: parameterItemInstance.id)
    }

    def delete(String id) {
        def parameterItemInstance = ParameterItem.get(id)
        if (!parameterItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'parameterItem.label', default: 'ParameterItem'), id])
            redirect(action: "list")
            return
        }

        try {
            parameterItemInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'parameterItem.label', default: 'ParameterItem'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'parameterItem.label', default: 'ParameterItem'), id])
            redirect(action: "show", id: id)
        }
    }
}
