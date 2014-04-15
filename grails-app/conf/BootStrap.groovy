import ru.agora.spot.model.Parameter
import ru.agora.spot.model.ParameterItem
import ru.agora.spot.model.Stuff

class BootStrap {

    def init = { servletContext ->

        // Create default Stuff parameters: size + color


        // Size
        def parameterSize = new Parameter(title: "Size")

        parameterSize.getParameterItems().add(new ParameterItem(name: "40", value: 40, type: ParameterItem.Type.INTEGER, parameter: parameterSize))
        parameterSize.getParameterItems().add(new ParameterItem(name: "41", value: 41, type: ParameterItem.Type.INTEGER, parameter: parameterSize))
        parameterSize.getParameterItems().add(new ParameterItem(name: "42", value: 42, type: ParameterItem.Type.INTEGER, parameter: parameterSize))

        parameterSize.save(flush: true, failOnError: true)


        // Color
        def parameterColor = new Parameter(title: "Color")
        parameterColor.getParameterItems().add(new ParameterItem(name: "Red", value: "Red", type: ParameterItem.Type.STRING, parameter: parameterColor))
        parameterColor.getParameterItems().add(new ParameterItem(name: "Blue", value: "Blue", type: ParameterItem.Type.STRING, parameter: parameterColor))
        parameterColor.getParameterItems().add(new ParameterItem(name: "Green", value: "Green", type: ParameterItem.Type.STRING, parameter: parameterColor))

        parameterColor.save(flush: true, failOnError: true)
        println "parameterColor:" + parameterColor


        // Stuff
        def stuff = new Stuff(title: "T-shirt", price: new Double(0.0d));

        println "Stuff:" + stuff
        println "Stuff parameters:" + stuff.parameters

        stuff.getParameters().add(parameterColor)
        stuff.getParameters().add(parameterSize)

        stuff.save(flush: true, failOnError: true)
    }
    def destroy = {
    }
}
