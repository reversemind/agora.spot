package sample.sample3

import ru.agora.spot.model.common.Base

class UserGroup3 extends Base {

    String name

    static hasMany = [users: User3]

    static mapping = {
        table 'user_groups_3'
        users column: 'usergroup3_user3_id'
    }

    static constraints = {

    }
}
