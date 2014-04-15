package ru.agora.spot.model.customer

import ru.agora.spot.model.common.Base

class User extends Base{

    String name
    String password
    Set<Role> roles

    static hasMany = [roles: Role]

    static mapping = {
        table 'a_user'
    }

    static constraints = {
        id generator: 'uuid2', length: 36
        name nullable: false, length: 256
        password nullable: false, length: 256
        roles nullable: false
    }

    User() {
        this.name = null
        this.password = null
        this.roles = new HashSet<Role>()
    }

    User(String name, String password) {
        this.name = name
        this.password = password
        this.roles = new HashSet<Role>()
    }

    User(String name, String password, Set<Role> roles) {
        this.name = name
        this.password = password
        this.roles = roles
    }

    User(UUID id, String name, String password, Set<Role> roles) {
        super(id)
        this.name = name
        this.password = password
        this.roles = roles
    }

    @Override
    public String toString() {
        return "name:" + name;

//        return "User{" +
//                "name='" + name + '\'' +
//                ", password='" + password + '\'' +
//                ", roles=" + roles +
//                '}';
    }
}
