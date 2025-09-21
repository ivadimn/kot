import corporation.Assistant
import corporation.Consultant

class Car {
    val brand: String
    val model: String
    val enginePower : Int
    val bodyColor: String

    constructor(brand: String, model: String, enginePower: Int, bodyColor: String) {
        this.brand = brand
        this.model = model
        this.enginePower = enginePower
        this.bodyColor = bodyColor
    }

    fun printInfo() {
        println("$brand $model $enginePower л.с. $bodyColor")
    }

    fun drive() {
        if (enginePower >= 120)
            println("Еду быстро, но недалеко на $brand $model")
        else
            println("Еду далеко, но небыстро на $brand $model")
    }

    fun refuel(azs: String, typeFuel: String, count: Int) {
        println("Произведена заправка на АЗС \"$azs\"")
        println("Марка бензина: $typeFuel")
        println("Кол-во литров: $count")
    }
}