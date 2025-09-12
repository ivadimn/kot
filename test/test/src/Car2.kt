fun main() {
    val isTruc = readln().toBoolean()
    val carType = if (isTruc) "грузовой автомобиль"
    else "легковой автомобиль"
    val power = readln().toInt()
    val rate = if (isTruc)
        if (power <= 100) 25
        else if (power <= 150) 40
        else if (power <= 200) 50
        else if (power <= 250) 65
        else 85
    else
        if (power <= 100) 10
        else if (power <= 150) 34
        else if (power <= 200) 49
        else if (power <= 250) 75
        else 150
    println("Вид ТС: $carType")
    println("Мощность двигателя: $power л.с.\nНалоговая ставка: $rate руб./л.с.\n" +
            "Сумма налога: ${rate * power} руб.")

}