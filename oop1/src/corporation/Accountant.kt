package corporation

import java.io.File

class Accountant(
    id: Int,
    name : String,
    age : Int = 0,
    salary : Int = 15000
) : Employee(id = id, name = name, age = age, salary = salary, Position.ACCOUNTANT), Supplier, Cleaner
{
    val productRepository = ProductRepository
    val employeesRepository = EmployeesRepository

    override fun copy(age: Int, salary: Int): Accountant {
        return Accountant(this.id, this.name, age, salary)
    }

    override fun supply() {
        println("Моя должность ${position.title}. Я поставляю товары ...")
    }

    override fun clean() {
        println("Моя должность бухгалтер. Я убираю помещение...")
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
                OperationCode.EXIT -> {
                    productRepository.saveChanges()
                    employeesRepository.saveChanges()
                    break
                }
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_ITEM -> removeItem()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_EMPLOYEE -> fireEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                OperationCode.CHANGE_SALARY -> changeSalary()
                OperationCode.CHANGE_AGE -> changeAge()
            }
        }
    }


    fun removeItem() {
        print("Введите наименование продукта для удаления: ")
        val name = readln()
        productRepository.removeItem(name)
    }

    fun fireEmployee() {
        print("Введите табельный номер для увольнения: ")
        val id = readln().toInt()
        employeesRepository.fireEmployee(id);
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
        productRepository.addNewItem(item)
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
        print("Введите зарплату: ")
        val salary = readln().toInt()
        val employee = when(positions[index]) {
            Position.DIRECTOR -> Director(id, name, age, salary)
            Position.ACCOUNTANT -> Accountant(id, name, age, salary)
            Position.ASSISTANT -> Assistant(id, name, age, salary)
            Position.CONSULTANT -> Consultant(id, name, age, salary)
        }
        employeesRepository.addNewEmployee(employee)
    }

    fun showAllItems() {
        val items = productRepository.items
        for (item in items)
            item.printInfo()

    }
    fun showAllEmployees() {
        val employees = employeesRepository.employees
        for (employee in employees)
            employee.printInfo()
    }
    fun changeSalary() {
        print("Введите табельный номер: ")
        val id = readln().toInt()
        print("Введите новую зарплату: ")
        val salary = readln().toInt()
        employeesRepository.changeSalary(id, salary)
    }

    fun changeAge() {
        print("Введите табельный номер: ")
        val id = readln().toInt()
        print("Введите новую зарплату: ")
        val age = readln().toInt()
        employeesRepository.changeAge(id, age)
    }
}