package lessons.lesson17.homework

class GameMachine(
    val color: String,
    val model: String,
    val hasJoystick: Boolean,
    val owner: String,
    val supportPhone: String,
    val sessionCost: Double,
    private val pinCode: String
) {
    var isOn: Boolean = false
    var isOSLoaded: Boolean = false
    var installedGames: List<String> = listOf()
    var balance: Double = 0.0
    var isSessionPaid: Boolean = false

    // Методы
    fun turnOn() {
        isOn = true
        println("Автомат включен")
    }

    fun turnOff() {
        isOn = false
        isOSLoaded = false
        println("Автомат выключен")
    }

    fun loadOS() {
        if (isOn) {
            isOSLoaded = true
            println("ОС загружена")
        }
    }

    fun shutdownOS() {
        isOSLoaded = false
        println("ОС завершила работу")
    }

    fun showGamesList() {
        println("Доступные игры: $installedGames")
    }

    fun startGame(gameName: String) {
        if (isSessionPaid && installedGames.contains(gameName)) {
            println("Запускаем игру: $gameName")
        }
    }

    fun payForSession() {
        isSessionPaid = true
        balance += sessionCost
        println("Сеанс оплачен")
    }

    fun collectCash(inputPin: String): Double {
        if (inputPin == pinCode) {
            val collectedAmount = balance
            balance = 0.0
            return collectedAmount
        }
        return 0.0
    }

    private fun openSafe(): Double {
        return balance
    }
}