package lessons.lesson18.homework

abstract class ProgrammableEquipment : PowerableEquipment(), Interfaces.Programmable {
    protected val actions = mutableListOf<String>()

    override fun programAction(action: String) {
        actions.add(action)
        println("$equipmentName: + '$action' (всего: ${actions.size})")
    }

    override fun execute() {
        if (!isPoweredOn) return println("$equipmentName: выключен")
        if (actions.isEmpty()) return println("$equipmentName: нет действий")

        println("$equipmentName: запуск программы...")
        actions.forEachIndexed { i, action ->
            executeProgramAction(action, i)
        }
        println("$equipmentName: готово!")
    }

    fun clearProgram() {
        actions.clear()
        println("$equipmentName: программа очищена")
    }

    protected abstract fun executeProgramAction(action: String, step: Int)
}