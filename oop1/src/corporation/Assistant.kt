package corporation

class Assistant(
    id: Int,
    name: String,
    age: Int = 0
) : Employee(id = id, name = name, age = age, Position.ASSISTANT), Supplier, Cleaner
{
    override fun supply() {
        println("Моя должность ${position.title}. Я поставляю товары ...")
    }

    override fun clean() {
        println("Моя должность Секретарь. Я убираю помещение...")
    }

    override fun work() {
        println("Я приношу кофе...")
    }

    override fun printInfo() {
        println("Должность: ${this.position} Табельный номер: ${this.id}, Имя: ${this.name}, Возраст: ${this.age}")
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