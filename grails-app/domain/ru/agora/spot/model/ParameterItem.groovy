package ru.agora.spot.model

class ParameterItem extends Basic{

//    UUID id
    String name
    String value
    String type

    static hasOne = [parameter: Parameter]

    static mapping = {
        table 'parameter_item'
//        value column: "value", name: "value", type: "blob"
    }

    static constraints = {
        id generator: 'uuid2'
        name nullable: false
        value nullable: false
        type nullable: false
    }

}
