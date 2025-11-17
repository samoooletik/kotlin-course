package lessons.lesson20.homewroks

import kotlin.math.absoluteValue

fun main() {
    // 1. Проверка массива чисел
    val nums = arrayOf(10, 20, 30, 40)
    val emptyNums = emptyArray<Int>()

    println(nums.firstAndLastOrNull())
    println(emptyNums.firstAndLastOrNull())


    // 2. Проверка расширения для списка
    val list = mutableListOf(3, 1, 4, 2)
    val ascendingList = list.sortAndToImmutable(true)
    println("После сортировки по возрастанию: $list")
    println("Неизменяемый список (asc): $ascendingList")

    val list2 = mutableListOf(3, 1, 4, 2)
    val descendingList = list2.sortAndToImmutable(false)
    println("После сортировки по убыванию: $list2")
    println("Неизменяемый список (desc): $descendingList")


    // 3. Проверка расширения для nullable Map
    val map: Map<Int, List<String>>? = mapOf(
        1 to listOf("a", "b", "c"),
        2 to listOf("x"),
        3 to listOf("k", "l")
    )

    val extracted0 = map.extractByIndex(0)
    val extracted1 = map.extractByIndex(1)
    val extracted5 = map.extractByIndex(5)

    println("index 0: $extracted0")
    println("index 1: $extracted1")
    println("index 5: $extracted5")

    val nullMap: Map<Int, List<String>>? = null
    println(nullMap.extractByIndex(0))


    // 4. Проверка within на разных типах
    println(5.within(7, 3))
    println(5.within(10, 3))
    println(5.0.within(5.2, 0.3))
    println(5.0.within(5.5, 0.3))
    println(10L.within(8L, 2L))


    // 5. Проверка encrypt / decrypt
    val original = "Hello, Kotlin!"
    val base = 3

    val encrypted = original.encrypt(base)
    val decrypted = encrypted.decrypt(base)

    println("Оригинал:  $original")
    println("Зашифровано: $encrypted")
    println("Расшифровано: $decrypted")
}

// 1. Расширение для массива чисел.
// Не принимает аргументов и возвращает пару (первый, последний).
// Если массив пустой – возвращаем (null, null).
fun <T : Number> Array<T>.firstAndLastOrNull(): Pair<T?, T?> {
    if (this.isEmpty()) {
        return Pair(null, null)
    }
    val first = this.first()
    val last = this.last()

    return Pair(first, last)
}


// 2. Расширение для изменяемого списка с T : Comparable<T>.
// Принимает Boolean: true – сортируем по возрастанию, false – по убыванию.
// Возвращает Неизменяемый список (List<T>), а сам MutableList сортирует.
fun <T : Comparable<T>> MutableList<T>.sortAndToImmutable(ascending: Boolean): List<T> {
    if (ascending) {
        this.sort()
    } else {
        this.sortDescending()
    }
    return this.toList()
}


// 3. Расширение для nullable словаря:
// Map<K, List<V>>?  -> возвращаем Map<String, V?>?
//
// Принимает индекс (Int).
// - Ключи превращаем в String через toString()
// - Значение берём из списка по индексу; если индекса нет – null.
// - Если словарь был null – возвращаем null.
fun <K, V> Map<K, List<V>>?.extractByIndex(index: Int): Map<String, V?>? {
    if (this == null) {
        return null
    }

    val result = mutableMapOf<String, V?>()

    for ((key, list) in this) {
        val valueAtIndex: V? = if (index in list.indices) {
            list[index]
        } else {
            null
        }

        result[key.toString()] = valueAtIndex
    }

    return result
}


// 4. Расширение within для Number.
// Проверяет, что |this - other| <= deviation.
fun Number.within(other: Number, deviation: Number): Boolean {
    val diff = this.toDouble() - other.toDouble()
    val maxDeviation = deviation.toDouble()
    return diff.absoluteValue <= maxDeviation.absoluteValue
}


// 5. Расширения encrypt и decrypt для String.
// encrypt: сдвигаем каждый символ вперёд на base по Unicode.
// decrypt: сдвигаем назад на base по Unicode.
fun String.encrypt(base: Int): String {
    val resultChars = this.map { ch ->
        val shiftedCode = ch.code + base
        shiftedCode.toChar()
    }
    return resultChars.joinToString("")
}

fun String.decrypt(base: Int): String {
    val resultChars = this.map { ch ->
        val shiftedCode = ch.code - base
        shiftedCode.toChar()
    }
    return resultChars.joinToString("")
}
