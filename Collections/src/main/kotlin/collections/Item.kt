package collections

data class Item(val value: Int): Comparable<Item>  {

    override fun equals(other: Any?): Boolean {
        if (other !is Item) return false
        return this.value == other.value
    }

    override fun hashCode(): Int {
        return value
    }

    override fun compareTo(other: Item): Int {
        return if (value > other.value) 1
        else if (value < other.value) -1
        else 0
    }
}