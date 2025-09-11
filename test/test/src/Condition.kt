fun main() {
    print("Введите возраст первого человека: ")
    val firstMan = readln().toInt()
    print("Введите возраст второго человека: ")
    val secondMan = readln().toInt()
    if (firstMan > secondMan) {
        println("Первый старше второго")
    }
    else if (firstMan < secondMan) {
        println("Второй старше первого")
    }
    else {
        println("Они ровесники")
    }
}