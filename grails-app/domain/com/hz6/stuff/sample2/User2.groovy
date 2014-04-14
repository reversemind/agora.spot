package com.hz6.stuff.sample2

import ru.agora.spot.model.Basic

class User2 extends Basic {

    String title

    static hasOne = [userGroups: UserGroup2]

    static mapping = {
        table 'user_2'
    }

    static constraints = {
    }
}
