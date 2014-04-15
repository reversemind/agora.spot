package ru.agora.spot.model.customer

import ru.agora.spot.model.common.Base

class Role extends Base{

    String name

    static mapping = {
        table 'a_role'
    }

    static constraints = {
        id generator: 'uuid2', length: 36
        name nullable: false, length: 256
    }
}
