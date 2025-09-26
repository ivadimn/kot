package corporation

class Director(
    id: Int,
    name: String,
    age: Int,
    salary : Int = 15000
) : Employee(id = id, name = name, age = age, salary = salary, Position.DIRECTOR), Supplier
{
    override fun copy(age: Int, salary: Int): Director {
        return Director(this.id, this.name, age, salary)
    }

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