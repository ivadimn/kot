package profile

class Person {
   private val name : String
   private val age : Int
   private val height : Int
   private val weight : Int

    constructor(name: String, age: Int, height: Int, weight: Int) {
        this.name = name
        this.age = age
        this.height = height
        this.weight = weight
    }

    fun sayHello() {
        println("Привет! Меня зовут $name")
    }

    fun printInfo() {
        println("Имя: $name, Возраст: $age, Рост: $height, Вес: $weight")
    }

    fun run() {
        println("Running Running Running...")
    }
}