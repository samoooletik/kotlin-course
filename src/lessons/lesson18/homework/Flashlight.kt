package lessons.lesson18.homework

abstract class Flashlight :
    Interfaces.Powerable,
    Interfaces.BatteryOperated,
    Interfaces.LightEmitting,
    Interfaces.WaterContainer {

    override val capacity: Int = 0
    override fun getCapacity(): Double = 1500.0
}