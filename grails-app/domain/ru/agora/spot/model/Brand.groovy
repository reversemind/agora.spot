package ru.agora.spot.model

/**
 *
 */
class Brand extends Basic{

//    UUID id
    String name

    static mapping = {
        table 'brand'
    }

    static constraints = {
        id generator: 'uuid2', length: 36
        name nullable: false, length: 128
    }
}
