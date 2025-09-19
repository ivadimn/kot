class Car {
    var brand: String = ""
    var model: String = ""
    var enginePower : Int = 0
    var bodyColor: String = ""

    fun init(brand: String, model: String, enginePower: Int, bodyColor: String) {
        this.brand = brand
        this.model = model
        this.enginePower = enginePower
        this.bodyColor = bodyColor
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