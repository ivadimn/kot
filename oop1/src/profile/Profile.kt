package profile

fun main() {

    print("Введите первое имя: ")
    val firstName = readln()
    print("Введите второе имя: ")
    val secondName = readln()

    print("Введите первый возраст: ")
    val firstAge = readln().toInt()
    print("Введите второй возраст: ")
    val secondAge = readln().toInt()

    print("Введите первый вес: ")
    val firstWeight = readln().toInt()
    print("Введите второй вес: ")
    val secondWeight = readln().toInt()

    print("Введите первый рост: ")
    val firstHeight = readln().toInt()
    print("Введите второй рост: ")
    val secondHeight = readln().toInt()

    val first = Person(firstName, firstAge, firstHeight, firstWeight)
    val second = Person(secondName, secondAge, secondHeight, secondWeight)

    println("1 Имя: ${first.name}\nВозраст: ${first.age}\nРост: ${first.height}\nВес: ${first.weight}")
    println("1 Имя: ${second.name}\nВозраст: ${second.age}\nРост: ${second.height}\nВес: ${second.weight}")

    first.run()
    second.run()
}