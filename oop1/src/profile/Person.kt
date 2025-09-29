package profile

class Person(
   val name : String,
   var surname : String,
   val height : Int,
   val weight : Int
)
{
    val fullName: String
        get() = "$name $surname"

    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is Person) return false
        return this.name == other.name && this.surname == other.surname
                && this.height == other.height && this.weight ==other.weight
    }

    override fun toString(): String {
        return "Имя: $fullName, Рост: $height, Вес: $weight"
    }


    fun sayHello() {
        println("Привет! Меня зовут $name")
    }

    fun printInfo() {
        this.toString()
    }

    fun run() {
        println("Running Running Running...")
    }

    override fun hashCode(): Int {
        var result = height
        result = 31 * result + weight
        result = 31 * result + name.hashCode()
        result = 31 * result + surname.hashCode()
        return result
    }
}