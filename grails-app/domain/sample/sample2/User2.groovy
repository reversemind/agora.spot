package sample.sample2

import ru.agora.spot.model.common.Base

class User2 extends Base {

    String title

    static hasOne = [userGroups: UserGroup2]

    static mapping = {
        table 'user_2'
    }

    static constraints = {
    }
}
