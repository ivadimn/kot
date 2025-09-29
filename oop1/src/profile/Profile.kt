package profile

fun main() {

    val persons: MutableSet<Person> = mutableSetOf()
    val p1 = Person("Pavel", "Cramer" , 180, 95)
    val p2 = Person("Pavel", "Cramer" , 180, 95)
    val p3 = Person("Petr", "Sydney" , 180, 95)
    persons.add(p1)
    persons.add(p2)
    persons.add(p3)
    for (person in persons)
        println(person.toString())

}