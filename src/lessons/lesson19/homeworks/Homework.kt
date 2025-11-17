package lessons.lesson19.homeworks

fun main() {
    // getMiddleElement
    val oddList = listOf(1, 2, 3, 4, 5)
    val evenList = listOf(1, 2, 3, 4)

    println(getMiddleElement(oddList))  // 3
    println(getMiddleElement(evenList)) // null

    // ListHolder
    val holder = ListHolder<String>()
    holder.addElement("Hello")
    holder.addElement("World")
    println(holder.getAllElements())

    // PhrasesToListOfStrings
    val mapper = PhrasesToListOfStrings()
    println(mapper.mapItem("hello world from kotlin"))
    println(mapper.mapList(listOf("one two", "three four five")))

    // transposition
    val originalMap = mapOf(1 to "one", 2 to "two")
    val transposedMap = transposition(originalMap)
    println(transposedMap)

    // Validators
    val stringValidator = StringValidator()
    println(stringValidator.isValid("  ")) // false
    println(stringValidator.isValid("test")) // true

    val oddValidator = OddValidator()
    println(oddValidator.isValid(2)) // true
    println(oddValidator.isValid(3)) // false

    val listValidator = ListValidator<Int>()
    println(listValidator.isValid(listOf(1, 2, 3))) // true
    println(listValidator.isValid(listOf(0, 1, 2))) // false
    println(listValidator.isValid(listOf(1, null, 3))) // false
}

// 1. Функция getMiddleElement с дженериком.
// Принимает список и возвращает средний элемент, если он есть, иначе возвращает null.
fun <T> getMiddleElement(list: List<T>): T? {
    if (list.isEmpty()) {
        return null
    }
    if (list.size % 2 == 0) {
        return null
    }
    val middleIndex = list.size / 2
    return list[middleIndex]
}


// 2. Класс ListHolder, который хранит список элементов типа T.
// Есть метод для добавления элемента и получения всех элементов в виде неизменяемого списка.
class ListHolder<T> {
    private val items: MutableList<T> = mutableListOf()

    fun addElement(element: T) {
        items.add(element)
    }

    fun getAllElements(): List<T> {
        return items.toList()
    }
}

// 3. Интерфейс Mapper с двумя дженериками.
// F - из какого типа мы преобразуем, T - в какой тип.
interface Mapper<F, T> {
    fun mapItem(from: F): T

    fun mapList(fromList: List<F>): List<T>
}

// 4. Класс PhrasesToListOfStrings, который имплементирует Mapper<String, List<String>>.
class PhrasesToListOfStrings : Mapper<String, List<String>> {

    override fun mapItem(from: String): List<String> {
        // split(" ") вернёт список слов, разделённых пробелами
        return from.split(" ")
    }

    override fun mapList(fromList: List<String>): List<List<String>> {
        val result: MutableList<List<String>> = mutableListOf()

        for (phrase in fromList) {
            val words: List<String> = mapItem(phrase)
            result.add(words)
        }

        return result
    }
}

// 5. Функция transposition с двумя дженериками.
fun <K, V> transposition(input: Map<K, V>): Map<V, K> {
    val result: MutableMap<V, K> = mutableMapOf()

    for ((key, value) in input) {
        // Если значения повторяются, последний перезапишет предыдущий
        result[value] = key
    }

    return result
}

// 6. Интерфейс Validator с дженериком.
interface Validator<T> {
    fun isValid(value: T): Boolean
}

// 7. Класс StringValidator, имплементирует Validator<String?>.
class StringValidator : Validator<String?> {

    override fun isValid(value: String?): Boolean {
        if (value == null) {
            return false
        }
        if (value.isEmpty()) {
            return false
        }
        if (value.isBlank()) {
            return false
        }

        return true
    }
}

// 8. Класс OddValidator (по названию "odd", но в задании написано, что нужно проверять, что число ЧЁТНОЕ, так и сделаем).
class OddValidator : Validator<Int> {

    override fun isValid(value: Int): Boolean {
        // Чётное число, если остаток от деления на 2 равен 0
        return value % 2 == 0
    }
}

// 9. Класс ListValidator с дженериком, ограниченным типом Number.
// Имплементирует Validator<List<T?>>.
// Проверки:
// - ни один элемент списка не является null
// - ни один элемент, приведённый к Double, не равен 0.0
class ListValidator<T : Number> : Validator<List<T?>> {

    override fun isValid(value: List<T?>): Boolean {
        for (item in value) {
            if (item == null) {
                return false
            }
            val asDouble: Double = item.toDouble()
            if (asDouble == 0.0) {
                return false
            }
        }
        return true
    }
}