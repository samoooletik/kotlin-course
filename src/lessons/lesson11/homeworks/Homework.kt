package lessons.lesson11.homeworks

fun main() {
}

//    Задачи на сигнатуру метода
//    1. Не принимает аргументов и не возвращает значения.
fun helloWorld() {
    println("Hello, world!")
}

//    2. Принимает два целых числа и возвращает их сумму.
fun summ(a: Int, b: Int): Int {
    return a + b
}

//    3. Принимает строку и ничего не возвращает.
fun sayHello(name: String) {
    println("Hello, $name")
}

//    4. Принимает список целых чисел и возвращает среднее значение типа Double.
fun averageVal(listOfInt: List<Int>): Double {
    if (listOfInt.isEmpty()) return 0.0
    var averageValue = 0
    for (i in listOfInt) {
        averageValue += i
    }
    return averageValue.toDouble() / listOfInt.size
}

//    5. Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun stringLength(str: String?): Int? {
    return str?.length
}

//    6. Не принимает аргументов и возвращает nullable вещественное число.
fun returnNullableDouble(): Double? {
    return null
}

//    7. Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun listInts(numbers: List<Int>?) {
    return
}

//    8. Принимает целое число и возвращает nullable строку.
fun returnNullableString(numers: Int): String? {
    return null
}

//    9. Не принимает аргументов и возвращает список nullable строк.
fun returnNullableListOfString(): List<String?> {
    return listOf(null, null, "Katya")
}

//    10. Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun returnBoolean(str: String?, int: Int?): Boolean? {
    return null
}

//    Задачи на написание кода
//    11. Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo(int: Int): Int = int * 2

//    12. Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.
fun isEven (num : Int): Boolean{
    if (num%2==0) {
        return true
    }else return false
}
//    13. Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n.
//    Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil(n: Int) : String? {
    if (n<1) return null
    var str = ""
    for (i in 1 ..n){
        str+="$i"
    }
    return str
}

//    14. Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке.
//    Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative(numbers: List<Int>): Int? {
    for (num in numbers) {
        if (num < 0) {
            return num
        }
    }
    return null
}
//    15. Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить каждую строку.
//    Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
fun processList(words: List<String?>) {
    for (word in words) {
        if (word == null) {
            return
        }
        println(word)
    }
}