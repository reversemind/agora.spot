package sample

import ru.agora.spot.model.Parameter
import ru.agora.spot.model.ParameterItem
import ru.agora.spot.model.Stuff
import sample.sample.User1
import sample.sample.UserGroup1
import sample.sample4.UserGroup4

class SimpleController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {

        def parameter = new Parameter(title: "Size")

        Set<ParameterItem> set = new HashSet<ParameterItem>()

        set.add(new ParameterItem(name: "40", value: 40, type: "INTEGER", parameter: parameter))
        set.add(new ParameterItem(name: "41", value: 41, type: "INTEGER", parameter: parameter))

        parameter.parametrItems = set;

        def stuff = new Stuff(title: 'Шуба' )

        Set<Parameter> stuffParameterSet = new HashSet<Parameter>()
        stuffParameterSet.add(parameter)

        stuff.parameters = stuffParameterSet
        stuff.save(flush: true, failOnError: true)


    }

    def user1(){

        def user1 = new User1(title: 'User1')
        def user2 = new User1(title: 'User2')

        def userGroup = new UserGroup1(name: "G1")

        userGroup.users.add(user1)
        userGroup.users.add(user2)

        userGroup.save(flush: true, failOnError: true)



        userGroup = new UserGroup1(name: "G5")
        userGroup.save(flush: true, failOnError: true)


        def user3 = new User1(title: 'User3')
        user3.save(flash: true, failOnError: true)

        userGroup.users.add(user3)
        userGroup.save(flush: true, failOnError: true)
    }

    def user2(){

    }

    def user3(){

    }

    def user4(){

        def user1 = new User1(title: 'User1')
        def user2 = new User1(title: 'User2')

        def userGroup = new UserGroup4(name: "G4")

        userGroup.users.add(user1)
        userGroup.users.add(user2)

        userGroup.save(flush: true, failOnError: true)



        userGroup = new UserGroup1(name: "G5")
        userGroup.save(flush: true, failOnError: true)


        def user3 = new User1(title: 'User3')
        user3.save(flash: true, failOnError: true)

        userGroup.users.add(user3)
        userGroup.save(flush: true, failOnError: true)
    }
}
