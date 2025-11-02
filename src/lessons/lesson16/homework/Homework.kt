package lessons.lesson16.homework

fun main() {
    val dog = Dog()
    val cat = Cat()
    val bird = Bird()
    val animal = Animal()

    dog.makeSound()
    cat.makeSound()
    bird.makeSound()
    animal.makeSound()

    val krug = Circle(5.0)
    val kvadrat = Square(4.0)
    val treugolnik = Triangle(3.0, 4.0, 90.0)

    println("Площадь круга: ${krug.area()}")
    println("Площадь квадрата: ${kvadrat.area()}")
    println("Площадь треугольника: ${treugolnik.area()}")

    val laser = LaserPrinter()
    laser.print("Привет от лазерного принтера")

    val inkjet = InkjetPrinter()
    inkjet.print("Привет от струйного принтера")

    val cart = ShoppingCart()
    cart.addToCart("item1")
    cart.addToCart("item2", 3)
    cart.addToCart(listOf("item3", "item4"))
    cart.addToCart(mapOf("item5" to 2))
    println(cart)

    val logger = Logger()
    logger.log("Просто сообщение")
    logger.log("WARNING", "Внимание!")
    logger.log(listOf("сообщение 1", "сообщение 2"))
    logger.log(Exception("Ошибка какая-то"))
}
open class Animal {
    open fun makeSound() {
        println("This animal makes no sound.")
    }
}

class Dog : Animal() {
    override fun makeSound() {
        println("Bark")
    }
}

class Cat : Animal() {
    override fun makeSound() {
        println("Meow")
    }
}

class Bird : Animal() {
    override fun makeSound() {
        println("Tweet")
    }
}

open class Shape {
    open fun area(): Double {
        return 0.0
    }
}

class Circle(val r: Double) : Shape() {
    override fun area(): Double {
        return 3.14 * r * r
    }
}

class Square(val a: Double) : Shape() {
    override fun area(): Double {
        return a * a
    }
}

class Triangle(val a: Double, val b: Double, val ugol: Double) : Shape() {
    override fun area(): Double {
        return 0.5 * a * b * Math.sin(ugol * 3.14 / 180)
    }
}

open class Printer {
    open fun print(text: String) {
        println(text)
    }
}

class LaserPrinter : Printer() {
    override fun print(text: String) {
        val slova = text.split(" ")
        for (slovo in slova) {
            println(slovo)
        }
    }
}

class InkjetPrinter : Printer() {
    override fun print(text: String) {
        val slova = text.split(" ")
        val cveta = listOf("красный", "синий", "зеленый")
        for ((i, slovo) in slova.withIndex()) {
            println("${cveta[i % cveta.size]}: $slovo")
        }
    }
}

class ShoppingCart {
    val tovari = mutableMapOf<String, Int>()

    fun addToCart(itemId: String) {
        if (tovari.containsKey(itemId)) {
            tovari[itemId] = tovari[itemId]!! + 1
        } else {
            tovari[itemId] = 1
        }
    }

    fun addToCart(itemId: String, amount: Int) {
        if (tovari.containsKey(itemId)) {
            tovari[itemId] = tovari[itemId]!! + amount
        } else {
            tovari[itemId] = amount
        }
    }

    fun addToCart(items: Map<String, Int>) {
        for ((id, kolvo) in items) {
            if (tovari.containsKey(id)) {
                tovari[id] = tovari[id]!! + kolvo
            } else {
                tovari[id] = kolvo
            }
        }
    }

    fun addToCart(items: List<String>) {
        for (id in items) {
            if (tovari.containsKey(id)) {
                tovari[id] = tovari[id]!! + 1
            } else {
                tovari[id] = 1
            }
        }
    }

    override fun toString(): String {
        var result = "Корзина:\n"
        for ((id, kolvo) in tovari) {
            result += "$id: $kolvo\n"
        }
        result += "Всего товаров: ${tovari.values.sum()}"
        return result
    }
}

class Logger {
    fun log(message: String) {
        println("INFO: $message")
    }

    fun log(level: String, message: String) {
        when (level) {
            "WARNING" -> println("WARNING: $message")
            "ERROR" -> println("ERROR: $message")
            else -> println("$level: $message")
        }
    }

    fun log(messages: List<String>) {
        for (msg in messages) {
            println("INFO: $msg")
        }
    }

    fun log(e: Exception) {
        println("ERROR: ${e.message}")
    }
}