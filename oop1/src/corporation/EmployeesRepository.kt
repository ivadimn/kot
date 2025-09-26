package corporation


import java.io.File

class EmployeesRepository {

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
}