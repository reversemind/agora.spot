package com.hz6.stuff.sample2

import com.hz6.stuff.Basic
import com.hz6.stuff.sample.User1

class UserGroup2 extends Basic {

    String name

    static hasMany = [users: User2]

    static mapping = {
        table 'user_groups_2'
    }

    static constraints = {
    }
}
