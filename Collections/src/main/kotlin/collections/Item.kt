package collections

class Item(val value: Int)  {
    override fun equals(other: Any?): Boolean {
        if (other !is Item) return false
        return this.value == other.value
    }

    override fun hashCode(): Int {
        return value
    }
}