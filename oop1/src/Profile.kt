fun main() {
    val first = Person()
    val second = Person()
    print("Введите первое имя: ")
    first.name = readln()
    print("Введите второе имя: ")
    second.name = readln()

    print("Введите первый возраст: ")
    first.age = readln().toInt()
    print("Введите второй возраст: ")
    second.age = readln().toInt()

    print("Введите первый вес: ")
    first.weight = readln().toInt()
    print("Введите второй вес: ")
    second.weight = readln().toInt()

    print("Введите первый рост: ")
    first.height = readln().toInt()
    print("Введите второй рост: ")
    second.height = readln().toInt()

    println("1 Имя: ${first.name}\nВозраст: ${first.age}\nРост: ${first.height}\nВес: ${first.weight}")
    println("1 Имя: ${second.name}\nВозраст: ${second.age}\nРост: ${second.height}\nВес: ${second.weight}")
}