package lessons.lesson18.homework
abstract class PowerableEquipment : Interfaces.Powerable {
    protected var isOn = false
    protected abstract val name: String

    override fun powerOn() {
        if (isOn) return println("$name: уже включен")
        isOn = true
        println("$name: включен")
    }

    override fun powerOff() {
        if (!isOn) return println("$name: уже выключен")
        isOn = false
        println("$name: выключен")
    }
}