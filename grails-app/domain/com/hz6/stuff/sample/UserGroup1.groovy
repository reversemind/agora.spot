package com.hz6.stuff.sample

import com.hz6.stuff.Basic

class UserGroup1 extends Basic {

    String name
    Set<User1> users

    public UserGroup1(){
        users = new HashSet<User1>();
    }

    static hasMany = [users: User1]

    static mapping = {
        table 'user_groups_1'
    }

    static constraints = {

    }
}
