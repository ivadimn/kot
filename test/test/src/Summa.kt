fun main() {
    val number = readln().toInt()
    var summa = 0
    var localNumber = 1
    while (localNumber <= number)
    {
        summa += localNumber++
        //localNumber++
    }
    println("Сумма чисел от 1 до $number равна $summa")
}