package lessons.lesson07.homeworks

fun main() {
//    Задания для цикла for
//    Прямой диапазон
    println("Числа от 1 до 5")
    for (i in 1..5) {
        print("$i ")
    }

    println("\nЧетные числа от 1 до 10")
    for (i in 1..10) {
        if (i % 2 == 0) {
            print("$i ")
        }
    }

//    Обратный диапазон
    println("\nСоздайте цикл for, который выводит числа от 5 до 1")
    for (i in 5 downTo 1) {
        print("$i ")
    }

    println("\nСоздайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2")
    for (i in 10 downTo 1 step 2) {
        print("$i ")
    }

//    С шагом (step)
    println("\nИспользуйте цикл for с шагом 2 для вывода чисел от 1 до 9")
    for (i in 1..9 step 2) {
        print("$i ")
    }

    println("\nНапишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20")
    for (i in 1..20 step 3) {
        print("$i ")
    }

//    Использование до (until)
    println("\nСоздайте числовую переменную 'size'. Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size")
    var size = 23
    for (i in 1 until size step 2) {
        print("$i ")
    }

//    Задания для цикла while
//    Цикл while
    println("\nСоздайте цикл while, который выводит квадраты чисел от 1 до 5")
    var counter = 0
    var i = 0
    while (counter++ < 5) {
        i = counter * counter
        print("$i ")
    }

    println("\nНапишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль")
    var minuend = 10
    while (minuend-- > 5) {
        print("$minuend ")
    }

//    Цикл do while
    println("\nИспользуйте цикл do while, чтобы вывести числа от 5 до 1")
    counter = 5
    do {
        print("$counter ")
    } while (counter-- > 1)

    println("\nСоздайте цикл do while, который повторяется, пока счетчик меньше 10, начиная с 5")
    counter = 5
    do {
        print("$counter ")
        counter++
    } while (counter < 10)

//    Задания для прерывания и пропуска итерации
//    Использование break
    println("\nНапишите цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6")
    for (i in 1..10) {
        if (i == 6) break
        print("$i ")
    }
    println("\nСоздайте цикл while, который бесконечно выводит числа, начиная с 1, но прерывается при достижении 10")
    i = 1
    while (true) {
        if (i == 10) break
        print("$i ")
        i++
    }

//    Использование continue
    println("\nВ цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа")
    for (i in 1..10) {
        if (i % 2 == 0) continue
        print("$i ")
    }

    println("\nНапишите цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3")
    counter = 0
    while (counter++ < 10) {
        if (counter % 3 == 0) continue
            print("$counter ")
    }
}