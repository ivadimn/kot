fun main() {
    print("Сколько денег? ")
    val money = readln().toInt()
    print("Голоден? ")
    val isHungry = readln().toBoolean()
    val isMuchMoney = money >= 500;
    if (isHungry && isMuchMoney)
        println("Купи пицу!")
    else if (isHungry)
        println("Купи доширак!")
    else if (isMuchMoney)
        println("Сходи в кино")
    else println("Сходи на прогулку")
}