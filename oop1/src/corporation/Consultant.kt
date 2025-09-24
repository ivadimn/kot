package corporation

import kotlin.random.Random

class Consultant(
    id: Int,
    name : String,
    age : Int = 0
) : Employee(id = id, name = name, age = age, Position.CONSULTANT), Cleaner
{
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