package corporation

fun main() {

    val repository = EmployeesRepository
    val assistant = repository.findAssistant()
    assistant?.printInfo()

    val director = repository.findDirector()
    director?.printInfo()
    if (assistant != null)
        director?.takeCoffee(assistant)
}