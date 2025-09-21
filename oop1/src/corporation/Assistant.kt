package corporation

class Assistant(
    name: String,
    age: Int = 0
) : Employee(name = name, age = age)
{
    override fun work() {
        println("Я приношу кофе...")
    }

    fun bringCoffee(drinkName: String = "Cappuccino", count: Int = 1) : String {
        repeat(count) {
            println("Get up")
            println("Go to the coffee machine")
            println("Press the \"$drinkName\" button")
            println("Wait for the $drinkName to be prepared" )
            println("Take coffee")
            println("Bring coffee to the director")
            println("Put coffee on the table")
            println("Return to the workplace")
        }
        return "Espresso"
    }

}