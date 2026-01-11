package collections

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MyHashSetTest {

    @ParameterizedTest
    @MethodSource("mutableHashSetSource")
    fun `When add 100 elements then size 100`(set: MyHashSet<Item>) {

        repeat(100) {
            set.add(Item(it))
        }
        assertEquals(100, set.size)
    }

    @ParameterizedTest
    @MethodSource("mutableHashSetSource")
    fun `When added 10 similar elements then size 1`(set: MyHashSet<Item>) {
        repeat(10) {
            set.add(Item(0))
        }
        assertEquals(1, set.size)
    }

    @ParameterizedTest
    @MethodSource("mutableHashSetSource")
    fun `When adding is succeed then method return true`(set: MyHashSet<Item>) {
        assertTrue(set.add(Item(0)))
    }

    @ParameterizedTest
    @MethodSource("mutableHashSetSource")
    fun `When adding is failed then method return false`(set: MyHashSet<Item>) {
        set.add(Item(0))
        assertFalse(set.add(Item(0)))
    }

    @ParameterizedTest
    @MethodSource("mutableHashSetSource")
    fun `When element present in set method return true`(set: MyHashSet<Item>) {
        repeat(10) {
            set.add(Item(it))
        }
        assertTrue(set.contains(Item(1)))
    }

    @ParameterizedTest
    @MethodSource("mutableHashSetSource")
    fun `When element is absent in set method return false`(set: MyHashSet<Item>) {
        repeat(10) {
            set.add(Item(it))
        }
        assertFalse { set.contains(Item(12)) }
    }

    @ParameterizedTest
    @MethodSource("mutableHashSetSource")
    fun `When element removed then size is decreased`(set: MyHashSet<Item>) {
        repeat(10) {
            set.add(Item(it))
        }
        set.remove(Item(9))
        assertEquals(9, set.size)
    }

    @ParameterizedTest
    @MethodSource("mutableHashSetSource")
    fun `When element removed then method return false`(set: MyHashSet<Item>) {
        repeat(10) {
            set.add(Item(it))
        }
        set.remove(Item(9))
        assertFalse(set.contains(Item(9)))
    }

    @ParameterizedTest
    @MethodSource("mutableHashSetSource")
    fun `When set is cleared then size is 0`(set: MyHashSet<Item>) {
        repeat(10) {
            set.add(Item(it))
        }
        set.clear()
        assertEquals(0, set.size)
    }

    @ParameterizedTest
    @MethodSource("mutableHashSetSource")
    fun `When set is cleared then all elements is absent`(set: MyHashSet<Item>) {
        repeat(10) {
            set.add(Item(it))
        }
        set.clear()
        repeat(10) {
            assertFalse(set.contains(Item(it)))
        }
    }

    companion object {
        @JvmStatic
        fun mutableHashSetSource() = listOf(MyHashSet<Item>())
    }

}