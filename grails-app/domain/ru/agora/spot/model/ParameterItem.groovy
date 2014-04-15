package ru.agora.spot.model

import ru.agora.spot.model.common.Base

class ParameterItem extends Base{

    String name
    String value
    Type type

    static hasOne = [parameter: Parameter]

    static mapping = {
        table 'parameter_item'
    }

    static constraints = {
        id generator: 'uuid2', length: 36
        name nullable: false, length: 256
        value nullable: false
        type nullable: false
    }

    enum Type{
        STRING, INTEGER, DOUBLE
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof ParameterItem)) return false
        if (!super.equals(o)) return false

        ParameterItem that = (ParameterItem) o

        if (id != that.id) return false
        if (name != that.name) return false
        if (type != that.type) return false
        if (value != that.value) return false

        return true
    }

    int hashCode() {
        int result = super.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + value.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }

    @Override
    public String toString() {
        return "ParameterItem{" +
                " id='" + name + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}
