package lessons.lesson15.homeworks

// ========================== ГЕОМЕТРИЧЕСКИЕ ФИГУРЫ ==========================

open class GeometricFigure(open val name: String) {
    open fun area(): Double = 0.0
    open fun perimeter(): Double = 0.0
}

open class Polygon(
    override val name: String,
    open val sides: Int
) : GeometricFigure(name)

class Circle(val radius: Double) : GeometricFigure("Circle") {
    override fun area() = Math.PI * radius * radius
    override fun perimeter() = 2 * Math.PI * radius
}

class Triangle(val a: Double, val b: Double, val c: Double) : Polygon("Triangle", 3) {
    override fun perimeter() = a + b + c
}

open class Quadrilateral(val a: Double, val b: Double, val c: Double, val d: Double)
    : Polygon("Quadrilateral", 4) {
    override fun perimeter() = a + b + c + d
}

class Rectangle(val width: Double, val height: Double)
    : Quadrilateral(width, height, width, height) {
    override fun area() = width * height
}


// ========================== УЧЕБНЫЕ ЗАВЕДЕНИЯ ==========================

open class EducationalInstitution(open val title: String, open val city: String) {
    open fun description(): String = "$title in $city"
}

open class School(
    override val title: String,
    override val city: String,
    val grades: IntRange
) : EducationalInstitution(title, city)

class ElementarySchool(title: String, city: String) : School(title, city, 1..4)
class HighSchool(title: String, city: String) : School(title, city, 9..11)

open class University(
    override val title: String,
    override val city: String,
    val faculties: Int
) : EducationalInstitution(title, city)

class ResearchUniversity(title: String, city: String, faculties: Int, val hIndex: Double)
    : University(title, city, faculties)


// ========================== МЕБЕЛЬ ==========================

open class Furniture(open val model: String, open val material: String)

open class Chair(
    override val model: String,
    override val material: String,
    val hasArmrests: Boolean
) : Furniture(model, material)

class OfficeChair(model: String, material: String, hasArmrests: Boolean, val wheels: Int)
    : Chair(model, material, hasArmrests)

class GamingChair(model: String, material: String, hasArmrests: Boolean, val reclineDeg: Int)
    : Chair(model, material, hasArmrests)

open class Table(
    override val model: String,
    override val material: String,
    val length: Double,
    val width: Double
) : Furniture(model, material)

class DiningTable(model: String, material: String, length: Double, width: Double, val seats: Int)
    : Table(model, material, length, width)

class WorkDesk(model: String, material: String, length: Double, width: Double, val hasCableTray: Boolean)
    : Table(model, material, length, width)


// ========================== КОНТЕЙНЕРЫ ==========================

abstract class Materials {
    protected val materials = mutableListOf<String>()
    fun add(material: String) {
        materials.add(material)
    }

    fun printContainer() {
        for (i in materials.indices) {
            println("[$i]: ${materials[i]}")
        }
    }
}

// 1️⃣ Добавляет строку в начало (на дно контейнера)
class BottomInsertMaterials : Materials() {
    fun addToBottom(material: String) {
        materials.add(0, material)
    }
}

// 2️⃣ Добавляет список строк, чередуя их со старыми
class InterleaveHeadMaterials : Materials() {
    fun addInterleaved(newItems: List<String>) {
        val oldItems = materials.toList()
        materials.clear()

        var i = 0
        var j = 0
        while (i < newItems.size || j < oldItems.size) {
            if (i < newItems.size) {
                materials.add(newItems[i])
                i++
            }
            if (j < oldItems.size) {
                materials.add(oldItems[j])
                j++
            }
        }
    }
}

// 3️⃣ Добавляет строку и сортирует список по алфавиту
class SortedMaterials : Materials() {
    fun addAndSort(material: String) {
        materials.add(material)
        materials.sort()
    }
}

// 4️⃣ Добавляет пары ключ–значение: ключи в начало (в обратном порядке), значения в конец
class KeyValueMaterials : Materials() {
    fun addKeyValuePairs(map: Map<String, String>) {
        val old = materials.toList()
        materials.clear()

        val keys = map.keys.toList().reversed()
        val values = map.values.toList()

        for (k in keys) materials.add(k)
        for (o in old) materials.add(o)
        for (v in values) materials.add(v)
    }
}


// ========================== ПРОВЕРКА ==========================

fun main() {
    println("Геометрические фигуры:")
    val circle = Circle(3.0)
    val rect = Rectangle(2.0, 5.0)
    val tri = Triangle(3.0, 4.0, 5.0)
    println("Circle perimeter = ${circle.perimeter()}")
    println("Rectangle area = ${rect.area()}")
    println("Triangle perimeter = ${tri.perimeter()}")

    println("\nУчебные заведения:")
    val es = ElementarySchool("School #12", "Prague")
    val hs = HighSchool("Gymnasium #1", "Vienna")
    val ru = ResearchUniversity("Tech U", "Berlin", 12, 24.5)
    println(es.description())
    println(hs.description())
    println(ru.description())

    println("\nМебель:")
    val oc = OfficeChair("Ergo X", "Mesh", true, 5)
    val gc = GamingChair("ProGamer", "Leather", true, 170)
    val dt = DiningTable("Nordic", "Oak", 180.0, 90.0, 6)
    val wd = WorkDesk("Focus", "Birch", 140.0, 70.0, true)
    println("${oc.model}, ${gc.model}, ${dt.model}, ${wd.model}")

    println("\nКонтейнеры:")

    println("\n1. BottomInsertMaterials")
    val bottom = BottomInsertMaterials()
    bottom.addToBottom("C")
    bottom.addToBottom("B")
    bottom.addToBottom("A")
    bottom.printContainer()

    println("\n2. InterleaveHeadMaterials")
    val inter = InterleaveHeadMaterials()
    inter.addInterleaved(listOf("A", "B", "C"))
    inter.addInterleaved(listOf("X", "Y"))
    inter.printContainer()

    println("\n3. SortedMaterials")
    val sorted = SortedMaterials()
    sorted.addAndSort("pear")
    sorted.addAndSort("apple")
    sorted.addAndSort("banana")
    sorted.printContainer()

    println("\n4. KeyValueMaterials")
    val keyValue = KeyValueMaterials()
    keyValue.add("old") // немного старых данных
    keyValue.addKeyValuePairs(mapOf("k1" to "v1", "k2" to "v2"))
    keyValue.printContainer()
}
