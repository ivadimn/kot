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