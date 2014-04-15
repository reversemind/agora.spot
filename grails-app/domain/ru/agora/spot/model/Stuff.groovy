package ru.agora.spot.model

import ru.agora.spot.model.common.Base

/**
 *
 */
class Stuff extends Base {

    String title
    Brand brand
    Double price = 0.0d
    Set<Parameter> parameters;

    static hasMany = [parameters: Parameter]

    static mapping = {
        table 'stuff'
    }

    static constraints = {
        id generator: 'uuid2', length: 36
        title nullable: false, length: 256
        brand nullable: true
        price nullable: false
        parameters nullable: true
    }

    public Stuff() {
        this.title = null
        this.brand = null
        this.price = 0.0d
        this.parameters = new HashSet<Parameter>();
    }

    public Stuff(String title, Brand brand, Double price, Set<Parameter> parameters) {
        this.title = title
        this.brand = brand
        this.price = price
        this.parameters = new HashSet<Parameter>();
    }

    public Stuff(String title, Brand brand, Double price) {
        this.title = title
        this.brand = brand
        this.price = price
        this.parameters = new HashSet<Parameter>();
    }

    public Stuff(String title, Double price) {
        this.title = title
        this.brand = null
        this.price = price
        this.parameters = new HashSet<Parameter>();
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Stuff)) return false
        if (!super.equals(o)) return false

        Stuff stuff = (Stuff) o

        if (id != stuff.id) return false
        if (title != stuff.title) return false

        return true
    }

    int hashCode() {
        int result = super.hashCode()
        result = 31 * result + title.hashCode()
        return result
    }

    @Override
    public String toString() {
        return "Stuff{" +
                " id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", brand=" + brand +
                ", price=" + price +
                ", parameters=" + parameters +
                '}';
    }
}
