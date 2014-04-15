package sample.sample4

import ru.agora.spot.model.common.Base

class User4 extends Base{

    String title

    static belongsTo = UserGroup4

    static mapping = {
        table 'user_4'
    }

    static constraints = {
    }
}
