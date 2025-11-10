package lessons.lesson17.homework
abstract class BaseClass(
    // 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass
    // ОТВЕТ: Потому что в ChildrenClass объявлено СВОЕ поле с тем же именем (val privateVal: String).
    // Это два разных поля! BaseClass.privateVal недоступен, а ChildrenClass.privateVal - публичное поле самого ChildrenClass
    private val privateVal: String,

    // 2. объясни, почему это поле недоступно в main()
    // ОТВЕТ: Потому что protected модификатор разрешает доступ только внутри класса и его наследников.
    // main() находится вне иерархии наследования, поэтому доступ запрещен
    protected val protectedVal: String,

    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }

    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"

    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,           // privateVal из BaseClass
            "protectedVal" to protectedVal,       // protectedVal из BaseClass
            "publicVal" to publicVal,             // publicVal из BaseClass
            "publicField" to publicField,         // publicField из BaseClass
            "protectedField" to protectedField,   // protectedField из BaseClass
            "privateField" to privateField,       // privateField из BaseClass
            "generate" to generate(),             // переопределенный метод
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint() // Вызовет privatePrint из BaseClass, а не из ChildrenClass!
    }

    // 7. объясни, почему эта функция не может быть публичной
    // ОТВЕТ: Потому что она возвращает ProtectedClass, который имеет protected модификатор.
    // Если сделать функцию публичной, то извне можно будет получить ProtectedClass, но нельзя будет его использовать
    protected open fun getProtectedClass() = ProtectedClass()

    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3 // Разрешает только строки короче 3 символов!
    }

    // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст
    // ОТВЕТ: Потому что метод generate() переопределен в ChildrenClass и возвращает "Это генерация из дочернего класса"
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    // 9. объясни, почему эта функция не может быть публичной или protected
    // ОТВЕТ: Потому что она возвращает PrivateClass, который полностью приватный.
    // Даже наследники не должны знать о его существовании
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}
    private class PrivateClass() {}
}