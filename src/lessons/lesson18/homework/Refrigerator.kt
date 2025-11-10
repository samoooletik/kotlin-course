package lessons.lesson18.homework

abstract class Refrigerator :
    Interfaces.Powerable,
    Interfaces.TemperatureRegulatable,
    Interfaces.Openable,
    Interfaces.Cleanable {

    override val maxTemperature: Int = 5
}
