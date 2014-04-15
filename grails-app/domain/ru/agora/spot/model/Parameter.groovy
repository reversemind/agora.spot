package ru.agora.spot.model

import ru.agora.spot.model.common.Base
import ru.agora.spot.model.customer.User

/**
 *
 */
class Parameter extends Base{

    User user
    String title
    Set<ParameterItem> parameterItems

    static hasMany = [parameterItems: ParameterItem]

    static mapping = {
        table 'parameter'
    }

    static constraints = {
        id generator: 'uuid2', length: 36
        title nullable: false, length: 256
    }

    public Parameter(){
        this.title = null;
        this.parameterItems = new HashSet<ParameterItem>();
    }

    public Parameter(String title){
        this.title = title;
        this.parameterItems = new HashSet<ParameterItem>();
    }

    public Parameter(String title, Set<ParameterItem> parameterItems){
        this.title = title;
        this.parameterItems = parameterItems;
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Parameter)) return false
        if (!super.equals(o)) return false

        Parameter parameter = (Parameter) o

        if (id != parameter.id) return false
        if (title != parameter.title) return false

        return true
    }

    int hashCode() {
        int result = super.hashCode()
        result = 31 * result + title.hashCode()
        return result
    }

    @Override
    public String toString() {
        return "Parameter{" +
                " id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", parameterItems=" + parameterItems +
                '}';
    }
}
