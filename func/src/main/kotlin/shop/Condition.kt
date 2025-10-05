package shop

interface Condition {
    fun isSuitable(product: ProductCard): Boolean
}