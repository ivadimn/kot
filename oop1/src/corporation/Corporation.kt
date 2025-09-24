package corporation

fun main() {

    val accountant = Accountant(4, "Elvira", 50)
    println(accountant)
    accountant.work()

//    val employees = accountant.loadAllEmployees()
//
//    for (employee in employees) {
//        if (employee is Supplier)
//            employee.supply()
//        if (employee is Cleaner)
//            employee.clean()
//    }
}