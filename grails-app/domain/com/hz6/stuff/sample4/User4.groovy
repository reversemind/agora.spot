package com.hz6.stuff.sample4

import com.hz6.stuff.Basic

class User4 extends Basic{

    String title

    static belongsTo = UserGroup4

    static mapping = {
        table 'user_4'
    }

    static constraints = {
    }
}
