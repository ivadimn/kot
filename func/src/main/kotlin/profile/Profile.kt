package profile


fun main() {
    val persons = PersonRepository.items.filter { it.age in 26..<30 }
        .sortedBy { it.firstName }
    persons.myForEach { println(it) }
}

inline fun <T> Iterable<T>.myForEach(  operation : (T) -> Unit) {
    for (item in this) {
        operation(item)
    }
}