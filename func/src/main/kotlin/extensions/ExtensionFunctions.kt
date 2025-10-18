package extensions

fun <R> Iterable<R>.filter(isSuitable : (R) -> Boolean) : List<R> {
    val result = mutableListOf<R>()
    for (product in this) {
        if (isSuitable(product))
            result.add(product)
    }
    return result
}

fun  <T, R> Iterable<T>.transform( operation: (T) -> R ): List<R> {
    val result = mutableListOf<R>()
    for (item in this) {
        result.add(operation(item))
    }
    return result
}

inline fun <T> Iterable<T>.myForEach(  operation : (T) -> Unit) {
    for (item in this) {
        operation(item)
    }
}
fun <T> T.myAlso(operation: () -> Unit) : T {
    operation()
    return this
}

/**
 * Расширение для преобразования значений в `Map`.
 * @param transform Функция для преобразования значений.
 * @return Новый `Map` с теми же ключами, но преобразованными значениями.
 */
fun <K, V, R> Map<K, V>.transformValues(transform: (V) -> R): Map<K, R> {
    // Реализуйте функцию здесь
    //val result = mutableMapOf<K, R>()
//    for ((key, value) in this.entries) {
//        result[key] = transform(value)
//   }
    //val result = this.map { it.key to transform(it.value) }
    return this.map { it.key to transform(it.value) }.toMap()
}

fun  <T, R> myWidth(value : T, operation : T.() -> R) : R {
    return value.operation()
}