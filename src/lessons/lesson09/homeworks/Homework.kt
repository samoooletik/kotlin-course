package lessons.lesson09.homeworks

fun main() {
//    Работа с массивами Array
//    1. Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    println("Работа с массивами Array\nЗадача 1")
    val numbers = arrayOf(1, 2, 3, 4, 5)
    for (num in numbers) {
        print("$num ")
    }

    println("\nЗадача 2")
//    2. Создайте пустой массив строк размером 10 элементов.
    val strings = Array(10) { "" }

    println("\nЗадача 3")
//    3. Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
    val doubles = arrayOfNulls<Double>(5)
    for (i in 0 until doubles.size) {
        doubles[i] = i * 2.0
    }
    for (num in doubles) {
        print("$num ")
    }

    println("\nЗадача 4")
//    4. Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу,
//    умноженному на 3.
    val ints = arrayOfNulls<Int>(5)
    for (i in 0 until ints.size) {
        ints[i] = i * 3
    }
    for (num in ints) {
        print("$num ")
    }

    println("\nЗадача 5")
//    5. Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
    val nullableStrings = arrayOfNulls<String>(3)
    nullableStrings[0] = "Привет"
    nullableStrings[1] = null
    nullableStrings[2] = "мир!"

    for (word in nullableStrings) {
        print("$word ")
    }

    println("\nЗадача 6")
//    6. Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    val intArray = arrayOf(1, 2, 3, 4, 5)
    var copyOfIntArray = arrayOfNulls<Int>(5)
    for (i in 0 until intArray.size) {
        copyOfIntArray[i] = intArray[i]
    }
    for (num in copyOfIntArray) {
        print("$num ")
    }

    println("\nЗадача 7")
//    7. Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого. Распечатайте полученные значения.
    val first = intArrayOf(10, 20, 30, 40, 50)
    val second = intArrayOf(1, 2, 3, 4, 5)
    val result = IntArray(first.size)
    for (i in 0 until first.size) {
        result[i] = first[i] - second[i]
    }
    println("Результат вычитания:")
    for (num in result) {
        print("$num ")
    }

    println("\nЗадача 8")
//    8. Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.
    val intNumbers = intArrayOf(2, 7, 5, 9, 3)
    var index = 0
    var foundIndex = -1

    while (index < intNumbers.size) {
        if (intNumbers[index] == 5) {
            foundIndex = index
            break
        }
        index++
    }

    println(foundIndex)

    println("\nЗадача 9")
//    9. Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль. Напротив каждого элемента
//    должно быть написано “чётное” или “нечётное”.
    val numbersInt = intArrayOf(1, 2, 3, 4, 5, 6)
    for (num in numbersInt) {
        if (num % 2 == 0) {
            println("$num — чётное")
        } else {
            println("$num — нечётное")
        }
    }

    println("\nЗадача 10")
//    10. Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в котором принятая
//    строка является подстрокой (метод contains()). Распечатай найденный элемент.
    val words = arrayOf("Котлин", "программирование", "язык", "мир")
    val search = "грамм"

    findString(words, search)

//    Работа со списками List
//    1. Создайте пустой неизменяемый список целых чисел.
    val readOnlyListInts: List<Int>

//    2. Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
    val readOnlyListAtrings: List<String> = listOf("Hello", "World", "Kotlin")

//    3. Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
    val mutableListInts: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)

//    4. Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
    mutableListInts.add(6)
    mutableListInts.add(7)
    mutableListInts.add(8)

    println("\nРабота со списками List\nЗадача 5")
//    5. Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
    val mutableListStrings: MutableList<String> = mutableListOf("Hello", "World", "Kotlin")
    mutableListStrings.remove("World")
    for (i in mutableListStrings) {
        print("$i ")
    }

    println("\nЗадача 6")
//    6. Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    val listInts: List<Int> = listOf(1, 2, 3, 4, 5)
    for (i in listInts) {
        print("$i ")
    }

    println("\nЗадача 7")
//    7. Создайте список строк и получите из него второй элемент, используя его индекс.
    println(readOnlyListAtrings.get(1))

    println("\nЗадача 8")
//    8. Имея изменяемый список чисел, измените значение элемента на определенной позиции (например, замените элемент с индексом 2 на новое
//    значение).
    mutableListInts[2] = 444
    for (i in mutableListInts) {
        print("$i ")
    }

    println("\nЗадача 9")
//    9. Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков. Реши задачу с помощью циклов.
    val list1 = listOf("Привет", "Котлин", "Учусь")
    val list2 = listOf("Писать", "Код", "Каждый день")
    val list3 = mutableListOf<String>()

    for (item in list1) {
        list3.add(item)
    }
    for (item in list2) {
        list3.add(item)
    }
    println("Объединённый список:")
    for (item in list3) {
        print("$item ")
    }

    println("\nЗадача 10")
//    10. Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
    val intsList = listOf(5, 12, 3, 19, 7, 1, 9)
    var min = intsList[0]
    var max = intsList[0]

    for (num in intsList) {
        if (num < min) {
            min = num
        }
        if (num > max) {
            max = num
        }
    }

    println("Min element: $min")
    println("Max element: $max")

    println("\nЗадача 11")
//    11. Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
    val listOfInts = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val LisrOfEvenInts = mutableListOf<Int>()

    for (num in listOfInts) {
        if (num % 2 == 0) {
            LisrOfEvenInts.add(num)
        }
    }

    println("Чётные числа: $LisrOfEvenInts")

//    Работа с Множествами Set
//    1. Создайте пустое неизменяемое множество целых чисел.
    val numbersSet: Set<Int> = emptySet()

//    2. Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
    val setInts: Set<Int> = setOf(1, 2, 3)

//    3. Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
    var mutableSetStrngs: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")

//    4. Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    mutableSetStrngs.add("Swift")
    mutableSetStrngs.add("Go")

    println("\nРабота с Множествами Set\nЗадача 5")
//    5. Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
    val mutableSetInts: MutableSet<Int> = mutableSetOf(1, 2, 3, 4, 5)
    mutableSetInts.remove(2)
    print(mutableSetInts)

    println("\nЗадача 6")
//    6. Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
    val setNums: Set<Int> = setOf(1, 2, 3, 5, 6, 7, 8)
    for (i in setNums) {
        println(i)
    }

    println("\nЗадача 7")
//    7. Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка. Нужно вернуть
//    булево значение true если строка есть. Реши задачу через цикл.
    val mySet = setOf("Котлин", "Java", "Python", "C++")

    findStringInSet(mySet, "Python")
    findStringInSet(mySet, "Swift")

    println("\nЗадача 8")
//    8. Создайте множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
    var myMutableSet: MutableSet<String> = mutableSetOf()
    for (i in mySet){
        myMutableSet.add(i)
    }
    println(myMutableSet)
}

fun findString(array: Array<String>, query: String) {
    var index = 0
    var found = false

    while (index < array.size) {
        if (array[index].contains(query)) {
            println("Найден элемент: ${array[index]}")
            found = true
            break
        }
        index++
    }

    if (!found) {
        println("Совпадений не найдено")
    }
}

fun findStringInSet(set: Set<String>, query: String){
    var found = false
    for (i in set){
        if(i == query){
            found = true
            break
        }
    }
    if(found) {
        println(found)
    }
}