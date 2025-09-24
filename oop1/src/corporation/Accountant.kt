package corporation

import java.io.File

class Accountant(
    id: Int,
    name : String,
    age : Int = 0
) : Employee(id = id, name = name, age = age, Position.ACCOUNTANT), Supplier, Cleaner
{
    val file = File("product_cards.txt")
    val shtat = File("employees.txt")

    override fun supply() {
        println("Моя должность ${position.title}. Я поставляю товары ...")
    }

    override fun clean() {
        println("Моя должность бухгалтер. Я убираю помещение...")
    }

    override fun printInfo() {
        println("Должность: ${this.position} Табельный номер: ${this.id}, Имя: ${this.name}, Возраст: ${this.age}")
    }

    override fun work() {
        val operationCode = OperationCode.entries
        while (true) {
            println("Введите код операции.")
            for ((i, code) in operationCode.withIndex()) {
                println(", $i - ${code.title}")
            }
            print("$> ")
            val index: Int = readln().toInt()
            when(operationCode[index]) {
                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_ITEM -> removeItem()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_EMPLOYEE -> fireEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
            }
        }
    }
    fun removeItem() {
        val items = loadAllItems()
        print("Введите наименование продукта для удаления: ")
        val name = readln()
        for ((index, item) in items.withIndex()) {
            if (name == item.name) {
                items.removeAt(index)
                break
            }
        }
        file.writeText("")
        for (item in items)
            saveItem(item)
    }

    fun fireEmployee() {
        val employees = loadAllEmployees()
        print("Введите табельный номер для удаления: ")
        val id = readln().toInt()
        for ((index, employee) in employees.withIndex()) {
            if (id == employee.id) {
                employees.removeAt(index)
                break
            }
        }
        shtat.writeText("")
        for (employee in employees)
            saveEmployee(employee)
    }

    fun saveItem(item: ProductCard) {
        file.appendText("${item.name}%${item.brand}%${item.price}")
        when (item) {
            is FoodProducts -> file.appendText("%${item.energyValue}")
            is Household -> file.appendText("%${item.power}")
            is Shoes -> file.appendText("%${item.size}")
        }
        file.appendText("%${item.productType}\n")
    }

    fun saveEmployee(employee: Employee) {
        shtat.appendText("${employee.id}%${employee.name}%${employee.age}%${employee.position}\n")
    }


    fun loadAllItems() : MutableList<ProductCard> {
        val cards = mutableListOf<ProductCard>()
        if (!file.exists())
            return cards
        val lines = file.readLines()
        for (line in lines) {
            val properties = line.split("%")
            val productType = ProductType.valueOf(properties[properties.size - 1])
            val product = when(productType) {
                ProductType.FOOD -> {
                    FoodProducts(properties[0],
                        properties[1],
                        properties[2].toInt(),
                        properties[3].toInt())
                }
                ProductType.HOUSEHOLD -> {
                    Household(properties[0],
                        properties[1],
                        properties[2].toInt(),
                        properties[3].toInt())
                }
                ProductType.SHOE -> {
                    Shoes(properties[0],
                        properties[1],
                        properties[2].toInt(),
                        properties[3].toFloat())
                }
            }
            cards.add(product)
        }
        return cards
    }

    fun loadAllEmployees() : MutableList<Employee> {
        val employees = mutableListOf<Employee>()
        if (!shtat.exists())
            return employees
        val lines = shtat.readLines()
        for (line in lines) {
            val properties = line.split("%")
            val position = Position.valueOf(properties[properties.size - 1])
            val id = properties[0].toInt()
            val name = properties[1]
            val age = properties[2].toInt()
            val employee = when(position) {
                Position.DIRECTOR -> Director(id, name, age)
                Position.ACCOUNTANT -> Accountant(id, name, age)
                Position.ASSISTANT -> Assistant(id, name, age)
                Position.CONSULTANT -> Consultant(id, name, age)
            }
            employees.add(employee)
        }
        return employees
    }

    fun registerNewItem ()  {
        val productTypes = ProductType.entries
        print("Введите тип продукта")
        for ((index, type) in productTypes.withIndex()) {
            print(", $index - ${type.title}")
        }
        print(": ")
        val index : Int = readln().toInt()
        print("Введите наименование продукта: ")
        val name = readln()
         print("Введите производителя продукта: ")
        val brand = readln()
        print("Введите цену: ")
        val price = readln().toInt()
        val item = when(productTypes[index]) {
            ProductType.FOOD -> {
                print("Введите энергетическую ценность продукта: ")
                val energyValue = readln().toInt()
                FoodProducts(name, brand, price, energyValue)
            }
            ProductType.HOUSEHOLD -> {
                print("Введите мощность: ")
                val power = readln().toInt()
                Household(name, brand, price, power)
            }
            ProductType.SHOE -> {
                print("Введите размер: ")
                val size = readln().toFloat()
                Shoes(name, brand, price, size)
            }
        }
        saveItem(item)
    }

    fun registerNewEmployee() {
        val positions = Position.entries
        print("Введите должность")
        for ((index, position) in positions.withIndex()) {
            print(", $index - ${position.title}")
        }
        print(": ")
        val index : Int = readln().toInt()
        print("Введите табельный номер: ")
        val id = readln().toInt()
        print("Введите имя: ")
        val name = readln()
        print("Введите возраст: ")
        val age = readln().toInt()
        val employee = when(positions[index]) {
            Position.DIRECTOR -> Director(id, name, age)
            Position.ACCOUNTANT -> Accountant(id, name, age)
            Position.ASSISTANT -> Assistant(id, name, age)
            Position.CONSULTANT -> Consultant(id, name, age)
        }
        saveEmployee(employee)
    }

    fun showAllItems() {
        val items = loadAllItems()
        for (item in items)
            item.printInfo()

    }
    fun showAllEmployees() {
        val employees = loadAllEmployees()
        for (employee in employees)
            employee.printInfo()
    }
}