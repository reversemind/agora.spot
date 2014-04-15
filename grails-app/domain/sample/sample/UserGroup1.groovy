package sample.sample

import ru.agora.spot.model.common.Base

class UserGroup1 extends Base {

    String name
    Set<User1> users

    public UserGroup1(){
        users = new HashSet<User1>();
    }

    static hasMany = [users: User1]

    static mapping = {
        table 'user_groups_1'
    }

    static constraints = {

    }
}
