package collections

import java.security.Key
import kotlin.collections.get
import kotlin.math.abs

class MyHashMap<K, V> : MyMutableMap<K, V> {

    public var elements = arrayOfNulls<Node<K, V>>(INITIAL_CAPACITY)

    private var  modCount = 0
    override var size: Int = 0
        private set

    private fun addNodeToChain(newElement: Node<K, V>, before: Node<K, V>): V? {
        var node = before
        while (true) {
            if (node.next == null) {
                node.next = newElement
                return null
            } else {
                if (node.key == newElement.key) {
                    return node.value.also {
                        node.value = newElement.value
                    }
                } else {
                    node = node.next!!
                }
            }
        }
    }

    override fun put(key: K, value: V): V? {
        modCount++
        if (size >= elements.size * LOAD_FACTOR) {
            increaseArray()
        }

        return put(key, value, elements).also { oldValue ->
            if (oldValue == null) size++
        }
    }

    private fun put(key: K, value: V, array: Array<Node<K, V>?>): V? {

        val newElement = Node(key, value)
        val position = getElementPosition(key, array.size)
        val existedElement = array[position]
        if (existedElement == null) {
            array[position] = newElement
            return null
        }
        else {
            if (existedElement.key == key) {
                return existedElement.value.also {
                    existedElement.value = value
                }
            } else {
                return addNodeToChain(newElement, existedElement)
            }
        }
    }

    private fun increaseArray() {
        val newArray = arrayOfNulls<Node<K, V>>(elements.size * 2)
        for (node in elements) {
            var currentElement = node
            while (currentElement != null) {
                put(currentElement.key, currentElement.value, newArray)
                currentElement = currentElement.next
            }
        }
        elements = newArray
    }

    override fun remove(key: K) :V? {
        modCount++
        val index = getElementPosition(key, elements.size)
        val existedElement = elements[index] ?: return null
        if (existedElement.key == key) {
            elements[index] = existedElement.next
            size--
            return existedElement.value
        }

        var before: Node<K, V>? = existedElement
        while (before?.next != null) {
            val removingElement = before.next
            if (removingElement?.key == key) {
                before.next = removingElement.next
                size--
                return removingElement.value
            }
            else {
                before = before.next
            }
        }
        return null
    }

    override fun clear() {
        modCount++
        elements = arrayOfNulls(INITIAL_CAPACITY)
        size = 0
    }

    override fun get(key: K): V? {
        val index = getElementPosition(key, elements.size)
        var existedElement: Node<K, V>? = elements[index]
        while (existedElement != null) {
            if (existedElement.key == key) {
                return existedElement.value
            }
            else {
                existedElement = existedElement.next
            }
        }
        return null
    }

    private inline fun foreach(operation: (Node<K, V>) -> Unit) {
        for (node in elements) {
            var currentElement = node
            while (currentElement != null) {
                operation(currentElement)
                currentElement = currentElement.next
            }
        }
    }

    override fun containsValue(value: V): Boolean {
        foreach { node ->
            if (node.value == value) return true
        }
        return false
    }


    override val keys: MySet<K>
        get() = MyHashSet<K>().apply {
            foreach {
                add(it.key)
            }
        }

    override val values: MyCollection<V>
        get() = MyArrayList<V>().apply {
            foreach {
                add(it.value)
            }
        }

    override fun containsKey(key: K): Boolean {
        val index = getElementPosition(key, elements.size)
        var existedElement: Node<K, V>? = elements[index]
        while (existedElement != null) {
            if (existedElement.key == key) {
                return true
            }
            else {
                existedElement = existedElement.next
            }
        }
        return false
    }

    private fun getElementPosition(key: K, arraySize: Int): Int {
        return abs(key.hashCode() % arraySize)
    }

    fun keyIterator(): MutableIterator<K> {
        return object : MutableIterator<K> {

            var nextIndex = 0
            var nodeIndex = 0
            var node = elements[nextIndex]
            private var currentModCount = modCount

            override fun hasNext(): Boolean {
                return nodeIndex < size
            }

            override fun next(): K {
                if (currentModCount != modCount) throw ConcurrentModificationException()
                while (node == null) {
                    node = elements[++nextIndex]
                }
                //return array[nextIndex++]?.item!! as T
                return node?.key!!.also {
                    nodeIndex++
                    node = node?.next
                }
            }

            override fun remove() {
                TODO("Not yet implemented")
            }
        }
    }

    data class Node<K, V>(
        val key: K,
        var value: V,
        var next: Node<K, V>? = null
    )

    companion object {
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_FACTOR = 0.75
    }
}