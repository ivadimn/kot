package profile

class Person {
    val name : String
    val age : Int
    val height : Int
    val weight : Int

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