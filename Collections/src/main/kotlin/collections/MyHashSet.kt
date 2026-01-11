package collections

import org.jetbrains.annotations.Nullable
import kotlin.math.abs

class MyHashSet<T> : MyMutableSet<T> {

    public var elements = arrayOfNulls<Node<T>>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set

    private fun addNodeToChain(newElement: Node<T>, before: Node<T>): Boolean {
        var node = before
        while (true) {
            if (node.next == null) {
                node.next = newElement
                return true
            } else {
                if (node.item == newElement.item) {
                    return false
                } else {
                    node = node.next!!
                }
            }
        }
    }

    override fun add(element: T): Boolean {
        if (size >= elements.size * LOAD_FACTOR) {
            increaseArray()
        }

        return add(element, elements).also { added ->
            if (added) size++
        }
    }

    private fun add(element: T, array: Array<Node<T>?>): Boolean {
        val newElement = Node(element)
        val position = getElementPosition(element, array.size)
        val existedElement = array[position]
        if (existedElement == null) {
            array[position] = newElement
            return true
        }
        else {
            if (existedElement.item == element) {
                return false
            } else {
                return addNodeToChain(newElement, existedElement)
            }
        }
    }

    private fun increaseArray() {
        val newArray = arrayOfNulls<Node<T>>(elements.size * 2)
        for (node in elements) {
            var currentElement = node
            while (currentElement != null) {
                add(currentElement.item, newArray)
                currentElement = currentElement.next
            }
        }
        elements = newArray
    }

    private fun findNode(index : Int, element: T) : Node<T>? {
        val node = elements[index] ?: return null
        if (node.item == element) return node
        var currentNode = node.next
        while (currentNode != null) {
            if (currentNode.item == element) return currentNode
            currentNode = currentNode.next
        }
        return null
    }

    private fun removeNode(firstNode : Node<T>, deletingNode: Node<T>, index: Int) {
        var currentNode: Node<T>? = firstNode
        if (firstNode == deletingNode) {
            elements[index] = deletingNode.next
            return
        }
        var nextNode : Node<T>? = firstNode.next
        while (nextNode != deletingNode) {
            nextNode = nextNode?.next
            currentNode = currentNode?.next
        }
        currentNode?.next = nextNode.next
        return
    }

    override fun remove(element: T) {
        val index = getElementPosition(element, elements.size)
        val firstNode = elements[index] ?: return
        val node = findNode(index, element) ?: return
        removeNode(firstNode, node, index)
        size--
    }

    override fun clear() {
        elements = arrayOfNulls(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(element: T): Boolean {
        val index = getElementPosition(element, elements.size)
        return findNode(index, element) != null
    }

    private fun getElementPosition(element: T, arraySize: Int): Int {
        return abs(element.hashCode() % arraySize)
    }

    data class Node<T>(
        val item: T,
        var next: Node<T>? = null
    )

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {

            var nextIndex = 0

            override fun hasNext(): Boolean {
                return nextIndex < elements.size
            }

            override fun next(): T {
                var item = elements[nextIndex]

                while (item == null) {
                    nextIndex++
                    item = elements[nextIndex]
                }
                nextIndex++
                return item.item
            }
        }
    }

    companion object {
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_FACTOR = 0.75
    }
}