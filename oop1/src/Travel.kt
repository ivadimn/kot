fun main() {
    val paramCar = readln().split(" ")
    val car = Car(paramCar[0], paramCar[1], paramCar[2].toInt(), paramCar[3])
    car.printInfo()

}