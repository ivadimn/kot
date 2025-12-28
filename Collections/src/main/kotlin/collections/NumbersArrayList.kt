package collections

class NumbersArrayList : NumbersMutableList {

    private var number: Int? = null

    override var size: Int = 0
        private set

    override fun add(element: Int) {
        this.number = element
        size++
    }

    override fun get(index: Int): Int {
        return number!!
    }
}