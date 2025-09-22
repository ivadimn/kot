package corporation

class Accountant(
    name : String,
    age : Int = 0
) : Employee(name = name, age = age)
{
    override fun work() {
        registerNewItem()
    }

    private fun registerFood() : FoodProducts {
        print("Введите наименование продукта: ")
        val name = readln()
        print("Введите производителя продукта: ")
        val brand = readln()
        print("Введите цену: ")
        val price = readln().toInt()
        print("Введите энергетическую ценность продукта: ")
        val energyValue = readln().toInt()
        return FoodProducts(name, brand, price, energyValue)
    }

    private fun registerHousehold() : Household {
        print("Введите наименование техники: ")
        val name = readln()
        print("Введите производителя техники: ")
        val brand = readln()
        print("Введите цену: ")
        val price = readln().toInt()
        print("Введите мощность техники: ")
        val power = readln().toInt()
        return Household(name, brand, price, power)
    }

    private fun registerShoes() : Shoes {
        print("Введите наименование обуви: ")
        val name = readln()
        print("Введите производителя обуви: ")
        val brand = readln()
        print("Введите цену: ")
        val price = readln().toInt()
        print("Введите размер обуви: ")
        val size = readln().toFloat()
        return Shoes(name, brand, price, size)
    }

    fun registerNewItem ()  {
        var code : Int
        while (true) {
            print("Введите код операции, 0 - выход, 1 - регистрация нового товара: ")
            code = readln().toInt()
            if (code == 0)
                break;
            print("Введите тип продукта, 0 - Продукты питания, 1 - Бытовая техника, 2 - Обувь: ")
            code = readln().toInt()
            when(code) {
                0 -> registerFood().printInfo()
                1 -> registerHousehold().printInfo()
                2 -> registerShoes().printInfo()
                else -> println("Неверный тип продукта")
            }
        }
    }
}