package lessons.lesson18.homework
abstract class ProgrammableEquipment : PowerableEquipment(), Interfaces.Programmable {
    protected val actions = mutableListOf<String>()

    override fun programAction(action: String) {
        actions.add(action)
        println("$name: + '$action' (всего: ${actions.size})")
    }

    override fun execute() {
        if (!isOn) return println("$name: выключен")
        if (actions.isEmpty()) return println("$name: нет действий")

        println("$name: запуск...")
        actions.forEachIndexed { i, action ->
            executeProgramAction(action, i)
        }
        println("$name: готово!")
    }

    fun clearProgram() {
        actions.clear()
        println("$name: очищена")
    }

    protected abstract fun executeProgramAction(action: String, step: Int)
}