package lessons.lesson18.homework

abstract class SmartLamp :
    Interfaces.Powerable,
    Interfaces.LightEmitting,
    Interfaces.TemperatureRegulatable,
    Interfaces.Programmable {

    override val maxTemperature: Int = 40
}