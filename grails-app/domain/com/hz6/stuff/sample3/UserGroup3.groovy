package com.hz6.stuff.sample3

import ru.agora.spot.model.Basic

class UserGroup3 extends Basic {

    String name

    static hasMany = [users: User3]

    static mapping = {
        table 'user_groups_3'
        users column: 'usergroup3_user3_id'
    }

    static constraints = {

    }
}
