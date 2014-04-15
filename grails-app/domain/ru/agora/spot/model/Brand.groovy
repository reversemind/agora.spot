package ru.agora.spot.model

import ru.agora.spot.model.common.Base

/**
 *
 */
class Brand extends Base{

    String name

    static mapping = {
        table 'brand'
    }

    static constraints = {
        id generator: 'uuid2', length: 36
        name nullable: false, length: 256
    }

    public Brand(String name) {
        this.name = name
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Brand)) return false
        if (!super.equals(o)) return false

        Brand brand = (Brand) o

        if (id != brand.id) return false
        if (name != brand.name) return false

        return true
    }

    int hashCode() {
        int result = super.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    @Override
    public String toString() {
        return "Brand{" +
                " id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
