package files

class Person(val id: Int, val name: String) {

    override fun hashCode(): Int {
        return id
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Person) return false
        return this.id == other.id
    }
}