package corporation

open class Employee(
    val name: String,
    val age: Int = 0
) {
    open fun work() {
        println("Я работаю...")
    }
}