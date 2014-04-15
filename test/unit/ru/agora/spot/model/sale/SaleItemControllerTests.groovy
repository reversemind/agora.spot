package ru.agora.spot.model.sale



import org.junit.*
import grails.test.mixin.*

@TestFor(SaleItemController)
@Mock(SaleItem)
class SaleItemControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/saleItem/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.saleItemInstanceList.size() == 0
        assert model.saleItemInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.saleItemInstance != null
    }

    void testSave() {
        controller.save()

        assert model.saleItemInstance != null
        assert view == '/saleItem/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/saleItem/show/1'
        assert controller.flash.message != null
        assert SaleItem.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/saleItem/list'

        populateValidParams(params)
        def saleItem = new SaleItem(params)

        assert saleItem.save() != null

        params.id = saleItem.id

        def model = controller.show()

        assert model.saleItemInstance == saleItem
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/saleItem/list'

        populateValidParams(params)
        def saleItem = new SaleItem(params)

        assert saleItem.save() != null

        params.id = saleItem.id

        def model = controller.edit()

        assert model.saleItemInstance == saleItem
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/saleItem/list'

        response.reset()

        populateValidParams(params)
        def saleItem = new SaleItem(params)

        assert saleItem.save() != null

        // test invalid parameters in update
        params.id = saleItem.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/saleItem/edit"
        assert model.saleItemInstance != null

        saleItem.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/saleItem/show/$saleItem.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        saleItem.clearErrors()

        populateValidParams(params)
        params.id = saleItem.id
        params.version = -1
        controller.update()

        assert view == "/saleItem/edit"
        assert model.saleItemInstance != null
        assert model.saleItemInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/saleItem/list'

        response.reset()

        populateValidParams(params)
        def saleItem = new SaleItem(params)

        assert saleItem.save() != null
        assert SaleItem.count() == 1

        params.id = saleItem.id

        controller.delete()

        assert SaleItem.count() == 0
        assert SaleItem.get(saleItem.id) == null
        assert response.redirectedUrl == '/saleItem/list'
    }
}
