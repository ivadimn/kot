package corporation

class Director(
    id: Int,
    name: String,
    age: Int
) : Employee(id = id, name = name, age = age, Position.DIRECTOR), Supplier
{
    override fun supply() {
        println("Моя должность ${position.title}. Я поставляю товары ...")
    }

    override fun work() {
        println("Я пью кофе...")
    }

    fun getConsultantToWork(consultant: Consultant) {
        val count = consultant.serveCustomers()
        println("corporation.Consultant ${consultant.name} served $count customers")
    }

    fun takeCoffee(assistant: Assistant) {
        val drinkName = assistant.bringCoffee()
        println("Thank you ${assistant.name}! The $drinkName is very tasty")
    }
}