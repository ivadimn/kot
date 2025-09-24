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

    override fun printInfo() {
        println("Должность: ${this.position} Табельный номер: ${this.id}, Имя: ${this.name}, Возраст: ${this.age}")
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