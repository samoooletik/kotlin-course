package lessons.lesson18.homework

abstract class ElectronicClock :
    Interfaces.Powerable,
    Interfaces.BatteryOperated,
    Interfaces.Timable,
    Interfaces.LightEmitting,
    Interfaces.SoundEmitting {

    override fun getCapacity(): Double = 2000.0
}