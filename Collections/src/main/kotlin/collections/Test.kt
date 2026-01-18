package collections


fun main() {
    val map = MyHashMap<String, Int>()

    repeat(50) {
        map.put("key$it", it)
    }
    map.keys.forEach(::println)


}