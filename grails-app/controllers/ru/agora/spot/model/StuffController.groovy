package ru.agora.spot.model

import org.springframework.dao.DataIntegrityViolationException

class StuffController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [stuffInstanceList: Stuff.list(params), stuffInstanceTotal: Stuff.count()]
    }

    def create() {
        [stuffInstance: new Stuff(params)]
    }

    def save() {
        def stuffInstance = new Stuff(params)
        if (!stuffInstance.save(flush: true)) {
            render(view: "create", model: [stuffInstance: stuffInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'stuff.label', default: 'Stuff'), stuffInstance.id])
        redirect(action: "show", id: stuffInstance.id)
    }

    def show(String id) {
        def stuffInstance = Stuff.get(id)
        if (!stuffInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'stuff.label', default: 'Stuff'), id])
            redirect(action: "list")
            return
        }

        [stuffInstance: stuffInstance]
    }

    def edit(String id) {
        def stuffInstance = Stuff.get(id)
        if (!stuffInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'stuff.label', default: 'Stuff'), id])
            redirect(action: "list")
            return
        }

        [stuffInstance: stuffInstance]
    }

    def update(String id, Long version) {
        def stuffInstance = Stuff.get(id)
        if (!stuffInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'stuff.label', default: 'Stuff'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (stuffInstance.version > version) {
                stuffInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'stuff.label', default: 'Stuff')] as Object[],
                          "Another user has updated this Stuff while you were editing")
                render(view: "edit", model: [stuffInstance: stuffInstance])
                return
            }
        }

        stuffInstance.properties = params

        if (!stuffInstance.save(flush: true)) {
            render(view: "edit", model: [stuffInstance: stuffInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'stuff.label', default: 'Stuff'), stuffInstance.id])
        redirect(action: "show", id: stuffInstance.id)
    }

    def delete(String id) {
        def stuffInstance = Stuff.get(id)
        if (!stuffInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'stuff.label', default: 'Stuff'), id])
            redirect(action: "list")
            return
        }

        try {
            stuffInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'stuff.label', default: 'Stuff'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'stuff.label', default: 'Stuff'), id])
            redirect(action: "show", id: id)
        }
    }
}
