package com.hz6.stuff.sample2

import ru.agora.spot.model.Basic

class UserGroup2 extends Basic {

    String name

    static hasMany = [users: User2]

    static mapping = {
        table 'user_groups_2'
    }

    static constraints = {
    }
}
