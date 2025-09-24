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

    first.printInfo()
    second.printInfo()

    first.run()
    second.run()
}