package com.hz6.stuff

class Basic {

    UUID id

    static mapping = {
        tablePerHierarchy false
    }

    static constraints = {
        id generator: 'uuid2'
    }
}
