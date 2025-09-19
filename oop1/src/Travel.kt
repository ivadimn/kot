fun main() {
    val car = Car()
    val paramCar = readln().split(" ")
    car.init(paramCar[0], paramCar[1], paramCar[2].toInt(), paramCar[3])
    car.drive()

}