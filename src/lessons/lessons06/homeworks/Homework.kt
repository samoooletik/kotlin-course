package lessons.lessons06.homeworks

fun main() {
    println("Задача 1")
    printSeason(1)   // Январь → Зима
    printSeason(5)   // Май → Весна
    printSeason(8)   // Август → Лето
    printSeason(11)  // Ноябрь → Осень

    print("\n")
    println("Задача 2")
    printDogAge(1)  // 10.5
    printDogAge(5)  //33.0

    print("\n")
    println("Задача 3")
    printTransport(0.5)  // пешком
    printTransport(3.0)  // велосипед
    printTransport(10.0) // автотранспорт

    print("\n")
    println("Задача 4")
    printBonusPoints(555)   // 10
    printBonusPoints(1000)  // 20
    printBonusPoints(1500)  // 45

    print("\n")
    println("Задача 5")
    printDocumentType("txt")   // Текстовый документ
    printDocumentType("jpg")   // Изображение
    printDocumentType("xlsx")  // Таблица
    printDocumentType("mp3")   // Неизвестный тип

    print("\n")
    println("Задача 6")
    convertTemperature(0.0, "C")     // 32.0F
    convertTemperature(232.79, "C")     // 451.0F
    convertTemperature(451.0, "F")   // 100.0C

    print("\n")
    println("Задача 7")
    recommendClothes(-35) // не выходить из дома
    recommendClothes(5)   // куртка и шапка
    recommendClothes(15)  // ветровка
    recommendClothes(25)  // футболка и шорты
    recommendClothes(40)  // не выходить из дома

    print("\n")
    println("Задача 8")
    println(getMovieCategory(5))   // детские
    println(getMovieCategory(15))  // подростковые
    println(getMovieCategory(25))  // 18+

}

//задача 1
fun printSeason(month: Int) {
    if (month == 12 || month == 1 || month == 2) {
        println("Зима")
    } else if (month == 3 || month == 4 || month == 5) {
        println("Весна")
    } else if (month == 6 || month == 7 || month == 8) {
        println("Лето")
    } else if (month == 9 || month == 10 || month == 11) {
        println("Осень")
    } else {
        println("Некорректный номер месяца")
    }
}

//задача 2
fun printDogAge(dogYears: Int) {
    var humanYears = 0.0
    if (dogYears <= 2) {
        dogYears * 10.5
    } else {
        2 * 10.5 + (dogYears - 2) * 4
    }

    println("Возраст собаки $dogYears лет = $humanYears человеческих лет")
}

//задача 3
fun printTransport(distanceKm: Double) {
    if (distanceKm <= 1) {
        println("пешком")
    } else if (distanceKm <= 5) {
        println("велосипед")
    } else {
        println("автотранспорт")
    }
}

// задача 4
fun printBonusPoints(amount: Int) {
    var points = 0
    if (amount <= 1000) {
        points = (amount / 100) * 2
    } else {
        points = (amount / 100) * 3
    }
    println("Сумма покупки: $amount руб. → Бонусные баллы: $points")
}

//задача 5
fun printDocumentType(extension: String) {
    when (extension) {
        "txt" -> println("Текстовый документ")
        "jpg", "png" -> println("Изображение")
        "xls", "xlsx" -> println("Таблица")
        else -> println("Неизвестный тип")
    }
}

//задача 6
fun convertTemperature(value: Double, unit: String) {
    if (unit == "C") {
        val result = value * 9 / 5 + 32
        println("$result F")
    } else if (unit == "F") {
        val result = (value - 32) * 5 / 9
        println("$result C")
    } else {
        println("Неизвестная единица измерения: $unit")
    }
}

//задача 7
fun recommendClothes(temp: Int) {
    if (temp < -30 || temp > 35) {
        println("Лучше не выходить из дома")
    } else if (temp < 10) {
        println("Куртка и шапка")
    } else if (temp in 10..18) {
        println("Ветровка")
    } else {
        println("Футболка и шорты")
    }
}

//задача 8
fun getMovieCategory(age: Int): String {
    return when (age) {
        in 0..9 -> "детские"
        in 10..18 -> "подростковые"
        else -> "18+"
    }
}
