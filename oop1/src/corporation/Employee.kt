package corporation

abstract class Employee(
    val id: Int,
    val name: String,
    val age: Int,
    val salary: Int = 15000,
    val position: Position
) {
    abstract fun work()

    abstract fun copy(age: Int = this.age, salary: Int = this.salary): Employee

    fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return "Должность: ${this.position} Табельный номер: ${this.id}, " +
                "Имя: ${this.name}, Возраст: ${this.age} Зарплата: ${this.salary}"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Employee) return false
        return this.id == other.id && this.name == other.name && this.age == other.age
    }
}