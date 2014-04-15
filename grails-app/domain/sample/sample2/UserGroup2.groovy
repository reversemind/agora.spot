package sample.sample2

import ru.agora.spot.model.common.Base

class UserGroup2 extends Base {

    String name

    static hasMany = [users: User2]

    static mapping = {
        table 'user_groups_2'
    }

    static constraints = {
    }
}
