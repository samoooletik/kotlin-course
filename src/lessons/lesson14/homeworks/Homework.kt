package lessons.lesson14.homeworks

fun main() {
    val party = Party("Стадион", 233)
    party.details()

    val emotion = Emotion("Невероятная радость", 10)
    emotion.express()

    Moon.moon()
    Moon.showPhase()

    val product = Product("Шоколадка Аленка", 70.55, 2)
    println(product)

    val concert = Concert("Kasabian", "Коломенское", 4000, 250, 233)
    concert.concertInformation()
    concert.buyTicket()
    concert.buyTicket()


    val rack = Rack(maxShelves = 3)
    val s1 = Shelf(15)
    val s2 = Shelf(10)

    rack.addShelf(s1)
    rack.addShelf(s2)

    rack.addItem("молоток")
    rack.addItem("гвозди")
    rack.addItem("клей")
    rack.addItem("пила")

    rack.printContents()

    // Сложное удаление первой полки
    val notPlaced = rack.advancedRemoveShelf(0)
    println("Не удалось разместить: $notPlaced")
    rack.printContents()
}

//Событие: вечеринка. Создайте класс Party, который описывает вечеринку. У него должны быть свойства location (String) и attendees (Int).
// Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.
class Party(val location: String, var attendees: Int) {
    fun details() {
        println("Мероприятие будет проводиться в $location, количество гостей $attendees")
    }
}

//Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию. У него должно быть свойство type (String) и intensity (Int).
// Добавьте метод express(), который выводит описание эмоции в зависимости от её типа и интенсивности.
class Emotion(var type: String, var intensity: Int) {
    fun express() {
        println("Эмоция $type с интенсивностью $intensity")
    }
}

//Природное явление: луна. Создайте объект Moon, который будет представлять Луну.
// Добавьте свойства isVisible (Boolean), чтобы отображать, видна ли Луна в данный момент, и phase (String), чтобы отображать текущую фазу Луны (например, "Full Moon", "New Moon").
//Добавьте метод showPhase(), который выводит текущую фазу Луны.
object Moon {
    var isVisible: Boolean = true
    var phase: String = "Full Moon"
    fun moon() {
        println("Луна")
    }

    fun showPhase() {
        if (isVisible) {
            println("Текущая фаза Луны :$phase")
        } else {
            println("Луну не видно")
        }
    }
}

//Покупка: продукт. Создайте дата класс для продукта, который будет представлять продукт в магазине. У него должны быть свойства “название”, “цена”, “количество”.
data class Product(val name: String, var cost: Double, var count: Int) {
}

//Мероприятие: концерт. Создайте класс, который будет представлять концерт. У него должны быть свойства “группа”, “место проведения”, “стоимость”, “вместимость зала”.
//Также приватное поле “проданные билеты”. Добавьте метод, который выводит информацию о концерте и метод “купить билет”, который увеличивает количество проданных билетов на один.
class Concert(
    val group: String,
    val location: String,
    var cost: Int,
    val capacity: Int,
    private var saledTickets: Int
) {
    fun concertInformation() {
        println("Спешл концерт от $group пройдет в $location. Билеты можно купить за $cost рублей")
    }

    fun buyTicket() {
        if (saledTickets < capacity) {
            saledTickets++
        }
        println(saledTickets)
    }
}

//Стеллаж и полки.
//Цель задания: Создать систему управления складским пространством с использованием классов "Стеллаж" и "Полка стеллажа".
// Характеристики:
//Вместимость полки (capacity): максимальная сумма букв всех названий предметов, которые могут быть размещены на полке.
//Список предметов (items): хранит названия предметов на полке.

// Класс "Полка стеллажа"
class Shelf(val capacity: Int) {
    init {
        require(capacity >= 0) { "Вместимость должна быть неотрицательной" }
    }

    private val items: MutableList<String> = mutableListOf()

    private fun used(): Int = items.sumOf { it.length }

    fun remainingCapacity(): Int = capacity - used()

    fun addItem(name: String): Boolean {
        require(name.isNotEmpty()) { "Название предмета не может быть пустым" }
        return if (canAccommodate(name)) {
            items += name
            println("Предмет '$name' добавлен на полку (осталось места: ${remainingCapacity()})")
            true
        } else {
            println("Недостаточно места, чтобы добавить '$name' на полку.")
            false
        }
    }

    fun removeItem(name: String): Boolean {
        val idx = items.indexOf(name)
        return if (idx >= 0) {
            items.removeAt(idx)
            println("Предмет '$name' удален с полки.")
            true
        } else {
            println("Предмет '$name' не найден на полке.")
            false
        }
    }

    // Проверка, поместится ли предмет на полку по длине названия
    fun canAccommodate(name: String): Boolean = remainingCapacity() >= name.length

    // Проверка наличия предмета на полке
    fun containsItem(name: String): Boolean = items.contains(name)

    // Возвращает неизменяемый список предметов
    fun getItems(): List<String> = items.toList()

    override fun toString(): String = "Полка(вместимость=$capacity, остаток=${remainingCapacity()}, предметы=$items)"
}

// Класс "Стеллаж", содержащий несколько полок
class Rack(private val maxShelves: Int) {
    init {
        require(maxShelves >= 0) { "Максимальное количество полок должно быть неотрицательным" }
    }

    private val shelves: MutableList<Shelf> = mutableListOf()

    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.size >= maxShelves) {
            println("Невозможно добавить полку: стеллаж уже заполнен.")
            return false
        }
        if (shelves.contains(shelf)) {
            println("Эта полка уже установлена в стеллаж.")
            return false
        }
        shelves += shelf
        println("Полка добавлена. Всего полок: ${shelves.size} из $maxShelves")
        return true
    }

    fun removeShelf(index: Int): List<String> {
        if (index !in shelves.indices) {
            println("Полка с индексом $index не найдена.")
            return emptyList()
        }
        val shelf = shelves.removeAt(index)
        println("Полка #$index удалена. Предметы с неё возвращены.")
        return shelf.getItems()
    }

    fun addItem(name: String): Boolean {
        for (s in shelves) {
            if (s.canAccommodate(name)) {
                println("Добавляем '$name' на полку...")
                return s.addItem(name)
            }
        }
        println("На всех полках недостаточно места для '$name'.")
        return false
    }

    fun removeItem(name: String): Boolean {
        for (s in shelves) {
            if (s.containsItem(name)) {
                return s.removeItem(name)
            }
        }
        println("Предмет '$name' не найден ни на одной полке.")
        return false
    }

    // Проверка наличия предмета на стеллаже
    fun containsItem(name: String): Boolean = shelves.any { it.containsItem(name) }

    // Возвращает список всех полок (только для чтения)
    fun getShelves(): List<Shelf> = shelves.toList()

    fun printContents() {
        if (shelves.isEmpty()) {
            println("[Стеллаж пуст] (максимум полок: $maxShelves)")
            return
        }
        println("Стеллаж: ${shelves.size}/$maxShelves полок")
        shelves.forEachIndexed { idx, shelf ->
            val items = shelf.getItems()
            val used = items.sumOf { it.length }
            val remaining = shelf.remainingCapacity()

            println(
                "Полка $idx вместимость: ${shelf.capacity} использовано: $used доступно:   $remaining  Предметы:     ${
                    items.joinToString()}"
            )
        }
    }

    //    Сложное удаление полки (advancedRemoveShelf):
//    Принимает индекс полки для удаления
//    Перераспределяет предметы по имеющимся полкам, начиная с самых длинных. Если очередной предмет никуда не вмещается, его нужно пропустить и попробовать разместить следующий.
//    Удаляет полку с оставшимися предметами
//    Возвращает неизменяемый список предметов, которые не удалось удалить или пустой список если полки с таким индексом нет.
    fun advancedRemoveShelf(index: Int): List<String> {
        if (index !in shelves.indices) {
            return emptyList()
        }
        val target = shelves[index]
        val otherShelves = shelves.filterIndexed { i, _ -> i != index }
        val notReplacedItems = mutableListOf<String>()


        for (item in target.getItems().sortedByDescending { it.length }) {
            if (otherShelves.none { it.addItem(item) }) {
                notReplacedItems += item
            }
        }
        shelves.removeAt(index)
        return notReplacedItems.toList()
    }

}

