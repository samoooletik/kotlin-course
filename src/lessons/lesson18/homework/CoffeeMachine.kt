package lessons.lesson18.homework

abstract class CoffeeMachine :
    Interfaces.Powerable,
    Interfaces.WaterContainer,
    Interfaces.WaterConnection,
    Interfaces.TemperatureRegulatable,
    Interfaces.Drainable,
    Interfaces.Programmable,
    Interfaces.Timable {

    override val capacity: Int = 2000
    override val maxTemperature: Int = 95
}