import ru.agora.spot.model.Parameter
import ru.agora.spot.model.ParameterItem

class BootStrap {

    def init = { servletContext ->

        // Create default Stuff
        def parameter = new Parameter(title: "Size")

        Set<ParameterItem> set = new HashSet<ParameterItem>()

        set.add(new ParameterItem(name: "40", value: 40, type: ParameterItem.Type.INTEGER, parameter: parameter))
        set.add(new ParameterItem(name: "41", value: 41, type: ParameterItem.Type.INTEGER, parameter: parameter))
    }
    def destroy = {
    }
}
