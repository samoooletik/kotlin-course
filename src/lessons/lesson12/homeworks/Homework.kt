package lessons.lesson12.homeworks

fun main() {
    val numbers = listOf(-1, 2, -3, 4, -5, 8, 25, 19, 264)
    val texts = listOf(null, "Hello world", null, "Kotlin", "course", "course")

//    Задачи на приведение коллекции к значению
//    Проверить, что размер коллекции больше 5 элементов.
//    Проверить, что коллекция пустая
//    Проверить, что коллекция не пустая
//    Взять элемент по индексу или создать значение если индекса не существует
//    Собрать коллекцию в строку
//    Посчитать сумму всех значений
//    Посчитать среднее
//    Взять максимальное число
//    Взять минимальное число
//    Взять первое число или null
//    Проверить что коллекция содержит элемент

    println(isSizeMoreThan5(numbers))
    println(numbers.isEmpty())
    println(numbers.isNotEmpty())
    val elementOrElse = numbers.getOrElse(7) { 144 }
    println(elementOrElse)
    println(numbers.joinToString(separator = ", "))
    println(numbers.sum())
    println(numbers.average())
    println(numbers.maxOrNull())
    println(numbers.minOrNull())
    println(numbers.firstOrNull())
    println(numbers.contains(144))

//    Задачи на обработку коллекций
//    Отфильтровать коллекцию по диапазону 18-30
//    Выбрать числа, которые не делятся на 2 и 3 одновременно
//    Очистить текстовую коллекцию от null элементов
//    Преобразовать текстовую коллекцию в коллекцию длин слов
//    Преобразовать текстовую коллекцию в мапу, где ключи - перевёрнутые слова, а значения - длина слов
//    Отсортировать список в алфавитном порядке
//    Взять первые 3 элемента списка
//    Распечатать квадраты элементов списка
//    Группировать список по первой букве слов
//    Очистить список от дублей
//    Отсортировать список по убыванию
//    Взять последние 3 элемента списка

    println(numbers.filter { 18 < it }.filter { it < 30 })
    println(numbers.filterNot { it % 2 == 0 }.filterNot { it % 3 == 0 })
    println(texts.filterNotNull())
    println(texts.mapNotNull { it?.length })
    println(texts.associate { it?.reversed() to it?.length })
    println(texts.filterNotNull().sorted())
    println(texts.take(3))
    println(numbers.map { it * it })
    println(texts.groupBy { it?.get(0) })
    println(texts.distinct())
    println(texts.filterNotNull().sortedDescending())
    println(texts.takeLast(3))

//    Задача 24. Характеристика числовой коллекции
    println(analyzeIntCollection(emptyList<Int>())) // Пусто
    println(analyzeIntCollection(listOf(1, 2, 3))) // Короткая
    println(analyzeIntCollection(numbers))

//    Задача 25. Анализ учебных оценок
    val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
    println(analyzeGrades(grades))

// Задача 26. Создание каталога по первой букве
    val list = listOf(
        "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра", "подушка",
        "Картина", "столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка", "светильник", "Коврик", "вешалка",
        "Подставка", "телевизор", "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница",
        "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба", "игрушка", "Настенные часы", "подсвечник",
        "Журнальный столик", "сувенир", "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка"
    )
    println(groupByFirstLetter(list))

//    Задание 27. Подсчёт средней длины слов в списке
    println(calculateAverageWordLength(list))

//    Задание 28: Категоризация чисел
    val numbers28 = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
    println(groupNumbers(numbers28))

//    Задание 29: Поиск первого подходящего элемента
    val ages = listOf(22, 18, 30, 45, 17, null, 60)
    println(findFirstValidAge(ages, 18))
}

fun isSizeMoreThan5(collection: List<Int>): Boolean {
    val isSizeMoreThanFive = collection.size > 5
    return isSizeMoreThanFive
}

fun analyzeIntCollection(collection: Collection<Int>): String {
    return when {
        collection.isEmpty() -> "Пусто"
        collection.size < 5 -> "Короткая"
        collection.firstOrNull() == 0 -> "Стартовая"
        collection.sum() > 10000 -> "Массивная"
        collection.average() == 10.0 -> "Сбалансированная"
        collection.joinToString("").length == 20 -> "Клейкая"
        collection.maxOrNull()?.let { it < -10 } == true -> "Отрицательная"
        collection.minOrNull()?.let { it > 1000 } == true -> "Положительная"
        collection.contains(3) && collection.contains(14) -> "Пи***тая"
        else -> "Уникальная"
    }
}

fun analyzeGrades(grades: List<Int>): List<Int> {
    return grades
        .filter { it >= 60 }
        .sorted()
        .take(3)
}

fun groupByFirstLetter(list: List<String>): Map<Char, List<String>> {
    return list
        .map { it.lowercase() }
        .groupBy { it.first() }
}

fun calculateAverageWordLength(words: List<String>): String {
    val averageLength = words
        .map { it.length }
        .average()

    return "Средняя длина: ${"%.2f".format(averageLength)}"
}

fun groupNumbers(numbers: List<Int>): Map<String, List<Int>> {
    val sortedNumbers = numbers.toSet().sortedDescending()
    val grouped = sortedNumbers.groupBy {
        if (it % 2 == 0) "четные" else "нечетные"
    }
    return grouped
}

fun findFirstValidAge(ages: List<Int?>, minAge: Int): Int? {
    return ages
        .filterNotNull()
        .firstOrNull { it > minAge }
}