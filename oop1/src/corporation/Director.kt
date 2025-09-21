package corporation

class Director(
    name: String,
    age: Int
) : Employee(name = name, age = age)
{
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