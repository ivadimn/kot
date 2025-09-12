fun main() {
    val power = readln().toInt()
    val rate = if (power <= 100) 10
    else if (power <= 150) 34
    else if (power <= 200) 49
    else if (power <= 250) 75
    else 150
    println("Вид ТС: легковой автомобиль")
    println("Мощность двигателя: $power л.с.\nНалоговая ставка: $rate руб./л.с.\n" +
            "Сумма налога: ${rate * power} руб.")

}