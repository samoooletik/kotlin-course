import lessons.lesson17.homework.BaseClass


class ChildrenClass(
    val privateVal: String, // Это поле ChildrenClass, а не BaseClass!
    protectedVal: String,

    // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
    // ОТВЕТ: Потому что publicVal передается в конструктор BaseClass как publicVal: String,
    // а в BaseClass это поле объявлено как val publicVal: String - то есть публичное поле
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {

    // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет
    // ОТВЕТ: Потому что getAll() унаследована от BaseClass и имеет публичный модификатор доступа

    // 12. проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределение метода privatePrint()
    // ОТВЕТ: Будет выведено "Печать из класса BaseClass", потому что private методы НЕ виртуальные
    // и не могут быть переопределены. Здесь создается НОВАЯ функция с тем же именем
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }

    // 4. Доработка для изменения publicField из main()
    override fun verifyPublicField(value: String): Boolean {
        // Разрешаем любые значения, чтобы можно было установить "Антонио Бандераса"
        return true
    }

    // 5. Публичный сеттер для protectedField - переименовываем чтобы избежать конфликта
    fun updateProtectedField(value: String) {
        protectedField = value // protectedField доступен в наследнике
    }

    // 6. Сеттер для privateField НЕВОЗМОЖНО создать!
    // privateField объявлен в BaseClass как private, поэтому наследники не имеют к нему доступа
    // Это ограничение языка для обеспечения инкапсуляции

    // Дополнительный метод для демонстрации работы с protected полем
    fun getProtectedFieldValue(): String {
        return protectedField // protectedField доступен для чтения в наследнике
    }
}

// Тестирующая функция
fun main() {
    val child = ChildrenClass("private_child", "protected_child", "public_child")

    // 1. Доступ к privateVal ChildrenClass
    println("1. child.privateVal = ${child.privateVal}") // Доступно потому что это поле ChildrenClass

    // 2. protectedVal недоступен
    // println(child.protectedVal) // ОШИБКА: Cannot access 'protectedVal'

    // 3. Изменение publicField
    println("\n3. Изменение publicField:")
    println("До: ${child.publicField}")
    child.publicField = "Антонио Бандераса" // Теперь сработает благодаря переопределению verifyPublicField
    println("После: ${child.publicField}")

    // 5. Изменение protectedField через сеттер
    println("\n5. Изменение protectedField:")
    println("До: ${child.getProtectedFieldValue()}")
    child.updateProtectedField("Измененное protected поле")
    println("После: ${child.getProtectedFieldValue()}")

    // 6. privateField невозможно изменить извне - это правильно!
    println("\n6. privateField невозможно изменить из main() - это правильная инкапсуляция")

    // 8. Проверка generate()
    println("\n8. Проверка метода generate():")
    println(child.getAll())

    // 12. Проверка printText()
    println("\n12. Проверка printText():")
    child.printText() // Выведет "Печать из класса BaseClass"

    // Дополнительная проверка всех полей
    println("\n=== ВСЕ ПОЛЯ ===")
    println(child.getAll())
}