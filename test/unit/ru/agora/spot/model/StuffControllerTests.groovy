package ru.agora.spot.model



import org.junit.*
import grails.test.mixin.*

@TestFor(StuffController)
@Mock(Stuff)
class StuffControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/stuff/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.stuffInstanceList.size() == 0
        assert model.stuffInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.stuffInstance != null
    }

    void testSave() {
        controller.save()

        assert model.stuffInstance != null
        assert view == '/stuff/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/stuff/show/1'
        assert controller.flash.message != null
        assert Stuff.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/stuff/list'

        populateValidParams(params)
        def stuff = new Stuff(params)

        assert stuff.save() != null

        params.id = stuff.id

        def model = controller.show()

        assert model.stuffInstance == stuff
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/stuff/list'

        populateValidParams(params)
        def stuff = new Stuff(params)

        assert stuff.save() != null

        params.id = stuff.id

        def model = controller.edit()

        assert model.stuffInstance == stuff
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/stuff/list'

        response.reset()

        populateValidParams(params)
        def stuff = new Stuff(params)

        assert stuff.save() != null

        // test invalid parameters in update
        params.id = stuff.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/stuff/edit"
        assert model.stuffInstance != null

        stuff.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/stuff/show/$stuff.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        stuff.clearErrors()

        populateValidParams(params)
        params.id = stuff.id
        params.version = -1
        controller.update()

        assert view == "/stuff/edit"
        assert model.stuffInstance != null
        assert model.stuffInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/stuff/list'

        response.reset()

        populateValidParams(params)
        def stuff = new Stuff(params)

        assert stuff.save() != null
        assert Stuff.count() == 1

        params.id = stuff.id

        controller.delete()

        assert Stuff.count() == 0
        assert Stuff.get(stuff.id) == null
        assert response.redirectedUrl == '/stuff/list'
    }
}
