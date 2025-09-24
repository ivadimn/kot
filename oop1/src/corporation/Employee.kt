package corporation

abstract class Employee(
    val id: Int,
    val name: String,
    val age: Int,
    val position: Position
) {
    abstract fun work()

    abstract fun printInfo()
}