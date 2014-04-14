package com.hz6.stuff

/**
 *
 */
class Brand {

    UUID id
    String name

    static mapping = {
        table 'brand'
    }

    static constraints = {
        id generator: 'uuid2'
        name nullable: false
    }
}
