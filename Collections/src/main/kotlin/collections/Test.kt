package collections


fun main() {
    val numbers = hashSetOf<Int>()
    repeat(1000) {
        numbers.add(it)
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