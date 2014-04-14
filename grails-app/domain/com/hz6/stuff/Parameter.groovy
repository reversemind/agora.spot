package com.hz6.stuff

class Parameter {

    UUID id
    String title

    static hasMany = [parametrItems: ParameterItem]

    static mapping = {
        table 'parameter'
    }

    static constraints = {
        id generator: 'uuid2'
    }
}
