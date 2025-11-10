package lessons.lesson18.homework

abstract class TemperatureOpenableEquipment : ProgrammableEquipment(), Interfaces.TemperatureRegulatable, Interfaces.Openable {
    protected var currentTemp: Int = 20
    protected var isOpened: Boolean = false

    override fun setTemperature(temp: Int) {
        if (!isPoweredOn) {
            println("$equipmentName: выключен")
            return
        }
        if (temp > maxTemperature) {
            println("$equipmentName: максимум $maxTemperature°C")
            return
        }
        currentTemp = temp
        println("$equipmentName: установлена $temp°C")
    }

    override fun open() {
        isOpened = true
        println("$equipmentName: открыт")
    }

    override fun close() {
        isOpened = false
        println("$equipmentName: закрыт")
    }

    override fun executeProgramAction(action: String, step: Int) {
        when (action) {
            "открыть" -> open()
            "закрыть" -> close()
            "нагрев" -> setTemperature(maxTemperature)
            else -> executeCustomAction(action, step)
        }
    }

    protected abstract fun executeCustomAction(action: String, step: Int)
}