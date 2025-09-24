package corporation

abstract class Employee(
    val id: Int,
    val name: String,
    val age: Int,
    val position: Position
) {
    abstract fun work()

    fun printInfo() {
        println(this)
    }
    override fun toString(): String {
        return "Должность: ${this.position} Табельный номер: ${this.id}, Имя: ${this.name}, Возраст: ${this.age}"
    }
}