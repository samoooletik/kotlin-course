package lessons.lesson18.homework

class WashingMachine {
    abstract class WashingMachine :
        Interfaces.Powerable,
        Interfaces.WaterContainer,
        Interfaces.WaterConnection,
        Interfaces.Drainable,
        Interfaces.TemperatureRegulatable,
        Interfaces.Timable,
        Interfaces.Programmable {

        override val capacity: Int = 50
        override val maxTemperature: Int = 90
    }

}