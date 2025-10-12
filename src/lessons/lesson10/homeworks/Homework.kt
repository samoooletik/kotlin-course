package lessons.lesson10.homeworks

fun main (){
//    Задачи на работу со словарём
//    1. Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
    val emptyMap = mapOf<String,String>()

//    2. Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
    val numbersDouble = mapOf(1.0f to 2.5, 2.5f to 6.25, 3.3f to 10.89)

//    3. Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
    val mutableNumbers = mutableMapOf(1 to "a", 2 to "b", 3 to "c")

//    4. Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
    mutableNumbers[4] = "d"

//    5. Используя словарь из предыдущего задания, извлеките значение, используя ключ.
    //    Попробуй получить значение с ключом, которого в словаре нет.
    val c = mutableNumbers[3]
    val err = mutableNumbers[5]

//    6. Удалите определенный элемент из изменяемого словаря по его ключу.
    mutableNumbers.remove(3)

//    7. Создайте словарь (ключи Double, значения Int) и выведи в цикле результат деления ключа на значение.
    //    Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)
    val numbersInt = mapOf(0.0 to 0, 1.0 to 1, 2.0 to 4, 3.0 to 9)
    for ((numDouble, numInt) in numbersInt){
        if (numInt == 0){
            println("бесконечность")
        } else {
        println(numDouble/numInt)
    }
    }

//    8. Измените значение для существующего ключа в изменяемом словаре.
    mutableNumbers[4] = "c"
    println(mutableNumbers[4])

//    9. Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
    val map1 = mapOf(1 to "a", 2 to "b", 3 to "c")
    val map2 = mapOf(4 to "d", 5 to "e", 6 to "f")
    val map3 = mutableMapOf<Int,String>()
    for ((key, value ) in map1){
        map3[key]=value
    }
    for ((key, value ) in map2){
        map3[key]=value
    }
    println("Объединенный массив:\n$map3")

//    10. Создайте словарь, где ключами являются строки, а значениями - списки целых чисел. Добавьте несколько элементов в этот словарь.
    val mapStrngs = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
    mapStrngs["d"] = 4
    mapStrngs["e"] = 5
    println(mapStrngs)

//    11. Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк. Добавь данные в словарь.
    //    Получи значение по ключу (это должно быть множество строк) и добавь в это множество ещё строку. Распечатай полученное множество.
    val data = mutableMapOf<Int, MutableSet<String>>()
    data[1] = mutableSetOf("а", "б")
    data[2] = mutableSetOf("a", "b")
    val set = data[1]
    if (set != null) {
        set.add("в")
        println("Обновлённое множество: $set")
    } else {
        println("Ключ не найден")
    }
    println("Обновлённый словарь: $data")

//    12. Создай словарь, где ключами будут пары чисел. Через перебор найди значение
    //    у которого пара будет содержать цифру 5 в качестве первого или второго значения.
    val numbers = mapOf( Pair(1, 2) to "Первый", Pair(5, 3) to "Второй", Pair(4, 5) to "Третий", Pair(7, 8) to "Четвёртый")
    for ((key, value) in numbers) {
        val first = key.first
        val second = key.second
        if (first == 5 || second == 5) {
            println("Пара ключ: $key значение: $value")
        }
    }

//    Задачи на подбор оптимального типа для словаря
//    1. Словарь библиотека: Ключи - автор книги, значения - список книг
    val library = mutableMapOf<String, MutableList<String>>()
    library["Толстой"] = mutableListOf("Война и мир", "Анна Каренина")
    library["Достоевский"] = mutableListOf("Преступление и наказание", "Идиот")

//    2. Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
    val plantsBook = mutableMapOf<String, MutableList<String>>()
    plantsBook["Цветы"] = mutableListOf("Роза", "Тюльпан", "Ромашка")
    plantsBook["Деревья"] = mutableListOf("Дуб", "Берёза", "Сосна")

//    3. Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды
    val quarterFinal = mutableMapOf<String, MutableList<String>>()
    quarterFinal["BMS"] = mutableListOf("Алекс", "Шайло", "Тэд")
    quarterFinal["Реал Мадрид"] = mutableListOf("Роналду", "Гарсия Фран")

//    4. Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату
    val treatmentCourse = mutableMapOf<String, MutableList<String>>()
    treatmentCourse["2025-10-01"] = mutableListOf("Витамин D", "Магний")
    treatmentCourse["2025-10-02"] = mutableListOf("Железо", "Коллаген")

//    5. Словарь путешественника: Ключи - страны, значения - словари из городов со списком интересных мест.
    val travelGuide = mutableMapOf<String, MutableMap<String, MutableList<String>>>()
    travelGuide["Испания"] = mutableMapOf(
        "Мадрид" to mutableListOf("Музей Прадо", "Королевский дворец"),
        "Валенсия" to mutableListOf("Океанариум", "Пляж")
    )
    travelGuide["Япония"] = mutableMapOf(
        "Токио" to mutableListOf("Синдзюку", "Шибуя"),
        "Осака" to mutableListOf("Глико мэн", "Юниверсал студио")
    )
}