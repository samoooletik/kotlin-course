package lessons.lesson18.homework

abstract class SmartSpeaker :
    Interfaces.Powerable,
    Interfaces.BatteryOperated,
    Interfaces.SoundEmitting,
    Interfaces.LightEmitting,
    Interfaces.Programmable,
    Interfaces.Rechargeable {

    override fun getCapacity(): Double = 5000.0
    override fun getChargeLevel(): Double = 100.0
}