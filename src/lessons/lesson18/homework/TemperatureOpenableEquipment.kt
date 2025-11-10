package lessons.lesson18.homework
abstract class TemperatureOpenableEquipment : ProgrammableEquipment(), Interfaces.TemperatureRegulatable, Interfaces.Openable {
    protected var currentTemp = 20
    protected var isOpened = false
    abstract override val maxTemperature: Int

    override fun setTemperature(temp: Int) {
        if (!isOn) return println("$name: выключен")
        if (temp > maxTemperature) return println("$name: максимум $maxTemperature°C")
        currentTemp = temp
        println("$name: $temp°C")
    }

    override fun open() {
        if (isOpened) return println("$name: уже открыт")
        isOpened = true
        println("$name: открыт")
    }

    override fun close() {
        if (!isOpened) return println("$name: уже закрыт")
        isOpened = false
        println("$name: закрыт")
    }

    override fun executeProgramAction(action: String, step: Int) {
        when (action.lowercase()) {
            "открыть" -> open()
            "закрыть" -> close()
            "нагрев" -> setTemperature(maxTemperature)
            else -> executeCustomAction(action, step)
        }
    }

    protected abstract fun executeCustomAction(action: String, step: Int)
}