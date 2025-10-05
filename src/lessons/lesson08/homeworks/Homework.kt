package lessons.lesson08.homeworks

fun main() {
//    1. Преобразование строк

    val originalString = "Это невозможно выполнить за один день"
//    val originalString = "Я не уверен в успехе этого проекта"
//    val originalString = "Произошла катастрофа на сервере"
//    val originalString = "Этот код работает без проблем"
//    val originalString = "Удача"

    var replacedString = ""

    if (originalString.contains("невозможно")) {
        replacedString = originalString.replace("невозможно", "совершенно точно возможно, просто требует времени")
    } else if (originalString.startsWith("Я не уверен")) {
        replacedString = originalString + ", но моя интуиция говорит об обратном"
    } else if (originalString.contains("катастрофа")) {
        replacedString = originalString.replace("катастрофа", "интересное событие")
    } else if (originalString.endsWith("без проблем")) {
        replacedString = originalString.replace("без проблем", "с парой интересных вызовов на пути")
    } else if (!originalString.contains(" ")) {
        replacedString = "Иногда, " + originalString + ", но не всегда"
    }

    println(replacedString)

//    Извлечение даты из строки лога
    val logString = "Пользователь вошел в систему -> 2021-12-01 09:48:23"

    val dataString = logString.split("->")
    val dataAndTime = dataString[1].trim()
    val date = dataAndTime.split(" ")[0]
    val time = dataAndTime.split(" ")[1]

    println(date + " " + time)

//    3. Маскирование личных данных
    val cardNumber = "4539 1488 0343 6467"
    val maskNumber = "**** **** **** " + cardNumber.split(" ")[3]

    println(maskNumber)

//    4. Форматирование адреса электронной почты
    val emailString = "username@example.com"
    val indexOFAt = emailString.indexOf("@") + 1
    val indexOFDot = emailString.indexOf(".")
    val replacedEmail = emailString.split("@")[0] +
            "[at]" +
            emailString.substring(indexOFAt, indexOFDot) +
            "[dot]" +
            emailString.split(".")[1]

    println(replacedEmail)

//    5. Извлечение имени файла из пути.

    val filePath = "C:/Пользователи/Документы/report.txt"
//    val filePath = "D:/good.themes/dracula.theme"
    val fileName = filePath.reversed().split("/")[0].reversed()

    println(fileName)

// 6. Создание аббревиатуры из фразы.

    val phrase = "Котлин лучший язык программирования"
    val words = phrase.split(" ")
    var abbreviation = ""
    for (word in words) {
        abbreviation = abbreviation + word[0].uppercaseChar()
    }

    println(abbreviation)
}
