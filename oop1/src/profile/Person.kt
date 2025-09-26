package profile

class Person(
   private val name : String,
   var surname : String,
   private val height : Int,
   private val weight : Int
)
{
    val fullName: String
        get() = "$name $surname"

    var age : Int = 0
        set(value) {
            if (value > field)
                field = value
        }
        get() {
            println("О возрасте спрашивать неприлично")
            return field
        }
    fun sayHello() {
        println("Привет! Меня зовут $name")
    }

    fun printInfo() {
        println("Имя: $fullName, Возраст: $age, Рост: $height, Вес: $weight")
    }

    fun run() {
        println("Running Running Running...")
    }
}