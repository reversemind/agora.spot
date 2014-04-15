package sample.sample4

import ru.agora.spot.model.common.Base

class UserGroup4 extends Base{

    String name

    static hasMany = [users: User4]

    static mapping = {
        table 'user_groups_4'
    }

    static constraints = {
    }
}
