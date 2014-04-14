package com.hz6.stuff.sample4

import com.hz6.stuff.Basic

class UserGroup4 extends Basic{

    String name

    static hasMany = [users: User4]

    static mapping = {
        table 'user_groups_4'
    }

    static constraints = {
    }
}
