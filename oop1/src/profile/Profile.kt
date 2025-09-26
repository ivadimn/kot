package profile

fun main() {

    print("Введите первое имя: ")
    val firstName = readln()
    print("Введите второе имя: ")
    val secondName = readln()

    print("Введите первую фамилию: ")
    val firstSurname = readln()
    print("Введите вторую фамилию: ")
    val secondSurname = readln()

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

    val first = Person(firstName, firstSurname, firstHeight, firstWeight)
    first.age = firstAge
    val second = Person(secondName, secondSurname, secondHeight, secondWeight)
    second.age = secondAge

    first.printInfo()
    second.printInfo()

    first.run()
    second.run()
}