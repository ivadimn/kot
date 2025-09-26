package corporation

import kotlin.random.Random

class Consultant(
    id: Int,
    name : String,
    age : Int = 0,
    salary : Int = 15000
) : Employee(id = id, name = name, age = age, salary = salary, Position.CONSULTANT), Cleaner
{
    override fun copy(age: Int, salary: Int): Consultant {
        return Consultant(this.id, this.name, age, salary)
    }

    override fun clean() {
        println("Моя должность Консультант. Я убираю помещение...")
    }

    override fun work() {
        println("Я консультирую клиентов...")
    }

    fun hello() {
        print("Привет меня зовут $name.")
        if (age > 0)
            println(" Мне $age лет.")
        else
            println()
    }

    fun serveCustomers() : Int{
        val count = Random.Default.nextInt(0, 100)
        repeat(count){
            println("Customer was served")
        }
        return count
    }
}