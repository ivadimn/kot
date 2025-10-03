package db

fun main() {
    val repository = UserRepository()
    val uvm = UserViewModel(repository)
    val list = uvm.getUserDescriptions()
    for (user in list)
        println(user)
}