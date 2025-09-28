package corporation


import java.io.File

object EmployeesRepository {

    val shtat = File("employees.txt")
    private val _employees = loadAllEmployees()
    val employees : List<Employee>
        get() = _employees.toList()

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
            val salary = properties[3].toInt()
            val employee = when(position) {
                Position.DIRECTOR -> Director(id, name, age, salary)
                Position.ACCOUNTANT -> Accountant(id, name, age, salary)
                Position.ASSISTANT -> Assistant(id, name, age, salary)
                Position.CONSULTANT -> Consultant(id, name, age, salary)
            }
            employees.add(employee)
        }
        return employees
    }

    fun fireEmployee(id: Int) {
        for (employee in _employees) {
            if (employee.id == id) {
                _employees.remove(employee)
                break
            }
        }
    }

    fun addNewEmployee(employee: Employee) {
        _employees.add(employee)
    }

    fun changeSalary(id: Int, salary: Int) {
        for ((index, employee) in _employees.withIndex()) {
            if (employee.id == id && salary > employee.salary) {
                val newEmployee = employee.copy(salary = salary)
                _employees[index] = newEmployee
                break
            }
        }
    }

    fun changeAge(id: Int, age: Int) {
        for ((index, employee) in _employees.withIndex()) {
            if (employee.id == id && age > employee.age) {
                val newEmployee = employee.copy(age = age)
                _employees[index] = newEmployee
                break
            }
        }
    }

    fun saveChanges() {
        val content = StringBuilder()
        for (employee in _employees) {
            content.append("${employee.id}%${employee.name}%${employee.age}" +
                    "%${employee.salary}%${employee.position}\n")
        }
        shtat.writeText(content.toString())
    }
}