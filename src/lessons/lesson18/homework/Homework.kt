package lessons.lesson18.homework
fun main() {
    // Тест PowerableEquipment
    val device1 = object : PowerableEquipment() {
        override val name = "Прибор1"
    }
    device1.powerOn()
    device1.powerOn()
    device1.powerOff()

    // Тест ProgrammableEquipment
    val device2 = object : ProgrammableEquipment() {
        override val name = "Прибор2"
        override fun executeProgramAction(action: String, step: Int) {
            println("$name: $action")
        }
    }
    device2.powerOn()
    device2.programAction("действие1")
    device2.programAction("действие2")
    device2.execute()

    // Тест TemperatureOpenableEquipment
    val device3 = object : TemperatureOpenableEquipment() {
        override val name = "Холодильник"
        override val maxTemperature = 5
        override fun executeCustomAction(action: String, step: Int) {
            setTemperature(2)
        }
    }
    device3.powerOn()
    device3.setTemperature(3)
    device3.programAction("охлаждение")
    device3.execute()
}