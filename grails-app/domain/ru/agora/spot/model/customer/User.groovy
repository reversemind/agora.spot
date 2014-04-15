package ru.agora.spot.model.customer

import ru.agora.spot.model.common.Base

class User extends Base{

    String name
    String password
    Set<Role> roles

    static hasMany = [roles: Role]

    static mapping = {
        table 'a_user'
    }

    static constraints = {
        id generator: 'uuid2', length: 36
        name nullable: false, length: 256
        password nullable: false, length: 256
        roles nullable: false
    }


}
