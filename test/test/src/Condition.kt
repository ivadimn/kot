fun main() {
    val weight = readln().toInt()

    val cost = if (weight in 0 until 2 ) 150
    else if (weight in 2 until 5 ) 200
    else if (weight in 5 until 12 ) 250
    else if (weight in 12 until 18 ) 300
    else if (weight in 18 until 30 ) 350
    else if (weight in 30 until 200 ) 1000
    else 0
    if (cost == 0)
        println("Для расчета стоимости свяжитесь с менеджером.")
    else
        println("$cost руб./км.")
}