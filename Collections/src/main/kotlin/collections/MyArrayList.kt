package collections

class MyArrayList<T>(initialCapacity: Int = INITIAL_CAPACITY) : MyMutableList<T> {


    private var elements = arrayOfNulls<Any>(initialCapacity)
    private var  modCount = 0

    override var size: Int = 0
        private set

    override fun add(element: T) : Boolean {
        modCount++
        growIfNeeded()
        elements[size] = element
        size++
        return true
    }

    override fun plus(element: T) {
        add(element)
    }

    private fun growIfNeeded() {
        if (elements.size == size) {
            val newArray = arrayOfNulls<Any>(elements.size * 2)
            System.arraycopy(elements, 0, newArray, 0, size)
            elements = newArray
        }
    }

    override fun add(index: Int, element: T) :Boolean {
        checkIndexForAdding(index)
        modCount++
        growIfNeeded()
        System.arraycopy(elements, index, elements, index + 1, size - index)
        elements[index] = element
        size++
        return true
    }

    override fun get(index: Int): T {
        checkIndex(index)
        return elements[index] as T
    }

    override fun removeAt(index: Int) {
        checkIndex(index)
        modCount++
        System.arraycopy(elements, index + 1, elements, index, size - index - 1)
        size--
        elements[size] = null
    }

    override fun remove(element: T) {
        for (i in 0 until size) {
            if (element == elements[i]) {
                removeAt(i)
                return
            }
        }
    }

    override fun minus(element: T) {
        remove(element)
    }

    override fun clear() {
        modCount++
        elements = arrayOfNulls<Any>(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(element: T): Boolean {
        for (i in 0 until size) {
            if (element == elements[i]) {
                return true
            }
        }
        return false
    }

    private fun checkIndex(index: Int) {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index: $index Size: $size")
        }
    }

    private fun checkIndexForAdding(index: Int) {
        if (index < 0 || index > size) {
            throw IndexOutOfBoundsException("Index: $index Size: $size")
        }
    }

    override fun iterator(): MutableIterator<T> {
        return object : MutableIterator<T> {

            private var currentModCount = modCount
            private var nextIndex = 0

            override fun hasNext(): Boolean {
                return nextIndex < size
            }

            override fun next(): T {
                if (currentModCount != modCount) throw ConcurrentModificationException()
                return elements[nextIndex++] as T
            }

            override fun remove() {
                TODO("Not yet implemented")
            }
        }
    }

    companion object {
        private const val INITIAL_CAPACITY = 10
    }
}