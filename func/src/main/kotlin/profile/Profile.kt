package profile


fun main() {
    val persons = PersonRepository.items
    var filtered = filter1(persons)
    filtered = filter(filtered, StartWithA())
    for (person in filtered)
    //cats.add(product.category)
        println(person)
}

fun filter(persons : List<Person>, condition: Condidtion) : List<Person>{
    val list = mutableListOf<Person>()
    for (person in persons) {
        if (condition.isSuitable(person))
            list.add(person)
    }
    return  list
}

fun filter1(persons: List<Person>) : List<Person> {
    return persons.filter {it.age > 25}
}