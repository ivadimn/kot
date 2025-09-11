fun main() {
    val dollars = readln().toInt()
    val count100 = dollars / 100
    var otherDollars = dollars % 100
    val count50 = otherDollars / 50
    otherDollars %= 50
    val count20 = otherDollars / 20
    otherDollars %= 20
    val count10 = otherDollars / 10
    otherDollars %= 10
    val count5 = otherDollars / 5
    otherDollars %= 5
    val count2 = otherDollars / 2
    otherDollars %= 2
    val count1 = otherDollars
    println("Вам доступно:")
    println("100$ - ${count100}шт\n50$ - ${count50}шт\n20$ - ${count20}шт\n" +
            "10$ - ${count10}шт\n5$ - ${count5}шт\n2$ - ${count2}шт\n1$ - ${otherDollars}шт\n")
}