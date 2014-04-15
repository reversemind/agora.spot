package ru.agora.spot.model.common

/**
 * Common parts for entities
 */
class Base {

    UUID id

    static mapping = {
        tablePerHierarchy false
    }

    static constraints = {
        id generator: 'uuid2', length: 36
    }

    public Base() {
        this.id = UUID.randomUUID()
    }

    public Base(UUID id) {
        this.id = id
    }

    UUID getId() {
        return id
    }

    void setId(UUID id) {
        this.id = id
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Base)) return false

        Base base = (Base) o

        if (id != base.id) return false

        return true
    }

    int hashCode() {
        return id.hashCode()
    }

    @Override
    public String toString() {
        return "id=" + id
    }
}
