package ru.agora.spot.model

class Stuff {

    UUID id
    String title
    Brand brand
    Double price = 0.0d

    static hasMany = [parameters: Parameter]

    static mapping = {
        table 'stuff'
    }

    static constraints = {
        id generator: 'uuid2'
        title nullable: false, length: 127
        brand nullable: true
        price nullable: false
        parameters nullable: true
    }
}
