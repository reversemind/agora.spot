package com.hz6.stuff.sample3

import com.hz6.stuff.Basic

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
