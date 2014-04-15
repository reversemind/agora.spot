package ru.agora.spot.model



import org.junit.*
import grails.test.mixin.*

@TestFor(ParameterItemController)
@Mock(ParameterItem)
class ParameterItemControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/parameterItem/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.parameterItemInstanceList.size() == 0
        assert model.parameterItemInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.parameterItemInstance != null
    }

    void testSave() {
        controller.save()

        assert model.parameterItemInstance != null
        assert view == '/parameterItem/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/parameterItem/show/1'
        assert controller.flash.message != null
        assert ParameterItem.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/parameterItem/list'

        populateValidParams(params)
        def parameterItem = new ParameterItem(params)

        assert parameterItem.save() != null

        params.id = parameterItem.id

        def model = controller.show()

        assert model.parameterItemInstance == parameterItem
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/parameterItem/list'

        populateValidParams(params)
        def parameterItem = new ParameterItem(params)

        assert parameterItem.save() != null

        params.id = parameterItem.id

        def model = controller.edit()

        assert model.parameterItemInstance == parameterItem
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/parameterItem/list'

        response.reset()

        populateValidParams(params)
        def parameterItem = new ParameterItem(params)

        assert parameterItem.save() != null

        // test invalid parameters in update
        params.id = parameterItem.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/parameterItem/edit"
        assert model.parameterItemInstance != null

        parameterItem.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/parameterItem/show/$parameterItem.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        parameterItem.clearErrors()

        populateValidParams(params)
        params.id = parameterItem.id
        params.version = -1
        controller.update()

        assert view == "/parameterItem/edit"
        assert model.parameterItemInstance != null
        assert model.parameterItemInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/parameterItem/list'

        response.reset()

        populateValidParams(params)
        def parameterItem = new ParameterItem(params)

        assert parameterItem.save() != null
        assert ParameterItem.count() == 1

        params.id = parameterItem.id

        controller.delete()

        assert ParameterItem.count() == 0
        assert ParameterItem.get(parameterItem.id) == null
        assert response.redirectedUrl == '/parameterItem/list'
    }
}
