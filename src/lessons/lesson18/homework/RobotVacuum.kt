package lessons.lesson18.homework

abstract class RobotVacuum :
    Interfaces.Powerable,
    Interfaces.BatteryOperated,
    Interfaces.Movable,
    Interfaces.Cleanable,
    Interfaces.Programmable,
    Interfaces.AutomaticShutdown {

    override val sensorType: String = "LIDAR"
    override val maxSensoredValue: Int = 100
    override fun getCapacity(): Double = 3000.0
}