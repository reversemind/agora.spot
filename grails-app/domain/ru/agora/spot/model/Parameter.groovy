package ru.agora.spot.model

class Parameter extends Basic{

//    UUID id
    String title

    static hasMany = [parametrItems: ParameterItem]

    static mapping = {
        table 'parameter'
    }

    static constraints = {
        id generator: 'uuid2'
    }
}
