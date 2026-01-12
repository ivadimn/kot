package collections


fun main() {
    val numbers = MyHashSet<Int>()
    repeat(50) {
        numbers.add(it + 9)
    }

//    val iterator = numbers.iterator()
//    while (iterator.hasNext()) {
//        val next = iterator.next()
//        println(next)
//    }

    for (number in numbers) {
        println(number)
    }
}