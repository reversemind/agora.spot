package ru.agora.spot.model

class Basic {

    UUID id

    static mapping = {
        tablePerHierarchy false
    }

    static constraints = {
        id generator: 'uuid2', length: 36
    }
}
