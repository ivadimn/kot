package corporation

fun main() {
    val director = Director("Vadim", 60)
    val assistant = corporation.Assistant("Helen", 25)
    val consultant = Consultant("Pete")
    val accountant = Accountant("Elvira", 50)
    //val employees = listOf<Employee>(director, assistant, consultant)
    val employees : List<Employee> = arrayListOf(director, assistant, consultant, accountant)

    for (employee in employees) {
        employee.work()
    }

}