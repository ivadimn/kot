package corporation

import kotlin.random.Random

class Consultant(
    name : String,
    age : Int = 0
) : Employee(name = name, age = age)
{
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