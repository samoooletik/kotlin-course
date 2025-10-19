package lessons.lesson13.homewroks

fun main() {
//1.  Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах. Определите среднее время выполнения теста.
    val testTimes = mapOf("test1" to 12.5, "test2" to 8.3, "test3" to 15.7)
    println(testTimes.values.average())

//2. Имеется словарь с метаданными автоматизированных тестов, где ключи — это имена тестовых методов а значения - строка с метаданными. Выведите список всех тестовых методов.
    val testMetadata = mapOf("testLogin" to "priority: high", "testLogout" to "priority: medium")
    println(testMetadata.keys.toList())

//3. В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
    val testResults = mutableMapOf("test1" to "passed", "test2" to "failed")
    testResults["test3"] = "passed"
    println(testResults)

//4. Посчитайте количество успешных тестов в словаре с результатами (ключ - название, значение - результат из passed, failed, skipped).
    val results = mapOf("test1" to "passed", "test2" to "failed", "test3" to "passed")
    println(results.values.count { it == "passed" })

//5. Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен (ключ - название, значение - статус исправления).
    val bugTracker = mutableMapOf("bug1" to "fixed", "bug2" to "open", "bug3" to "fixed")
    println(bugTracker.entries.removeAll { it.value == "fixed" })

//6. Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа), выведите сообщение о странице и статусе её проверки.
    val pageStatuses = mapOf("home" to 200, "about" to 404, "contact" to 500)
    pageStatuses.forEach { (url, status) -> println("Страница $url: статус $status") }

//7. Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает заданный порог.
    val serviceTimes = mapOf("api1" to 120, "api2" to 80, "api3" to 200)
    println(serviceTimes.filterValues { it > 100 })

//8. В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в виде строки). Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите, что он не был протестирован.
    val apiResults = mapOf("/users" to "200", "/posts" to "404")
    println(apiResults.getOrDefault("/comments", "не тестирован"))

//9. Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации, значение - сама конфигурация), получите значение для "browserType". Ответ не может быть null.
    val testConfig = mapOf("browserType" to "Chrome", "timeout" to "30")
    println(testConfig.getValue("browserType"))

//10. Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, добавив новую версию.
    val softwareVersions = mapOf("v1.0" to "stable", "v1.1" to "beta")
    println(softwareVersions + ("v1.2" to "alpha"))

//11. Используя словарь с настройками тестирования для различных мобильных устройств (ключ — модель устройства, значение - строка с настройками), получите настройки для конкретной модели или верните настройки по умолчанию.
    val deviceSettings = mapOf("iPhone12" to "iOS14", "SamsungS21" to "Android11")
    println(deviceSettings.getOrElse("iPhone13") { "default_settings" })

//12. Проверьте, содержит ли словарь с ошибками тестирования (ключ - код ошибки, значение - описание ошибки) определенный код ошибки.
    val errorCodes = mapOf("ERR001" to "Timeout", "ERR002" to "Memory leak")
    println(errorCodes.containsKey("ERR001"))

//13. Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version", а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped"). Отфильтруйте словарь, оставив только те сценарии, идентификаторы которых соответствуют определённой версии тестов, то-есть в ключе содержится требуемая версия.
    val testScenarios = mapOf("T001_v1" to "Passed", "T002_v2" to "Failed", "T003_v1" to "Skipped")
    println(testScenarios.filterKeys { it.contains("_v1") })

//14. У вас есть словарь, где ключи — это названия функциональных модулей приложения, а значения — результаты их тестирования. Проверьте, есть ли модули с неудачным тестированием.
    val moduleResults = mapOf("auth" to "passed", "payment" to "failed", "profile" to "passed")
    println(moduleResults.containsValue("failed"))

//15. Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.
    val testEnv = mutableMapOf("db" to "localhost", "port" to "8080")
    val additionalSettings = mapOf("cache" to "redis", "log" to "file")
    println(testEnv.putAll(additionalSettings))

//16. Объедините два неизменяемых словаря с данными о багах.
    val bugs1 = mapOf("bug1" to "critical", "bug2" to "minor")
    val bugs2 = mapOf("bug3" to "major", "bug4" to "trivial")
    val allBugs = bugs1 + bugs2
    println(allBugs)

//17. Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.
    val tempTestData = mutableMapOf("run1" to "data1", "run2" to "data2")
    tempTestData.clear()

//18. Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены (имеют статус “skipped”). Ключи - название теста, значения - статус.
    val testReport = mapOf("test1" to "passed", "test2" to "skipped", "test3" to "failed")
    println(testReport.filterValues { it != "skipped" })

//19. Создайте копию словаря с конфигурациями тестирования удалив из него несколько конфигураций.
    val testConfigs = mapOf("browser" to "Chrome", "os" to "Windows", "db" to "MySQL")
    println(testConfigs - listOf("os", "db"))

//20. Создайте отчет о тестировании, преобразовав словарь с результатами тестирования (ключ — идентификатор теста, значение — результат) в список строк формата "Test ID: результат".
    val testResultsReport = mapOf("T001" to "passed", "T002" to "failed")
    val report = testResultsReport.map { (id, result) -> "Test $id: $result" }
    println(report)

//21. Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.
    val lastRunResults = mutableMapOf("test1" to "passed", "test2" to "failed")
    println(lastRunResults.toMap())

//22. Преобразуйте словарь, содержащий числовой ID теста и данные о времени выполнения тестов, заменив идентификаторы тестов на их строковый аналог (например через toString()).
    val performanceData = mapOf(1 to 12.5, 2 to 8.3, 3 to 15.7)
    println(performanceData.mapKeys { it.key.toString() })

//23. Для словаря с оценками производительности различных версий приложения (ключи - строковая версия, значения - дробное число времени ответа сервера) увеличьте каждую оценку на 10%, чтобы учесть новые условия тестирования.
    val performanceScores = mapOf("v1.0" to 100.0, "v1.1" to 95.5, "v1.2" to 110.2)
    println(performanceScores.mapValues { it.value * 1.1 })

//24. Проверьте, пуст ли словарь с ошибками компиляции тестов.
    val compilationErrors = mapOf<String, String>()
    println(compilationErrors.isEmpty())

//25. Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.
    val loadTestResults = mapOf("response_time" to 150, "throughput" to 1000)
    println(loadTestResults.isNotEmpty())

//26. Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.
    val automatedTests = mapOf("test1" to true, "test2" to true, "test3" to true)
    println(automatedTests.all { it.value })

//27. Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.
    val testResultsMap = mapOf("test1" to "passed", "test2" to "error", "test3" to "passed")
    println(testResultsMap.any { it.value == "error" })

//28. Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты, которые не прошли успешно и содержат в названии “optional”.
    val serviceTests = mapOf(
        "login_optional" to "failed",
        "payment_core" to "passed",
        "export_optional" to "failed"
    )
    val failedOptional = serviceTests.filter {
        it.key.contains("optional") && it.value == "failed"
    }
    println(failedOptional)
}