package com.hz6.stuff

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
        title nullable: false
        brand nullable: true
        price nullable: false
        parameters nullable: true
    }
}
