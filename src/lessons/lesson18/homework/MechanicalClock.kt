package lessons.lesson18.homework

abstract class MechanicalClock :
    Interfaces.Mechanical,
    Interfaces.BatteryOperated {

    override fun getCapacity(): Double = 500.0
}