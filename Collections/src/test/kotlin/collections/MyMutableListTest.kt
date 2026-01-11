package collections

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MyMutableListTest {

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 1 element then size is 1`(list: MyMutableList<Int>) {
        list.add(0)
        assertEquals(1, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When add 100 element then size is 100`(list: MyMutableList<Int>) {

        repeat(1000) {
            list + it
        }
        assertEquals(1000, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When get 50th element then result is correct`(list: MyMutableList<Int>) {

        repeat(100) {
            list.add(it)
        }
        assertEquals(50, list[50])
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element removed then size decreased`(list: MyMutableList<Int>) {

        repeat(100) {
            list.add(it)
        }
        list.removeAt(50)
        assertEquals(99, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element 50th removed next element at this position`(list: MyMutableList<Int>) {

        repeat(100) {
            list.add(it)
        }
        list.removeAt(50)
        assertEquals(51, list[50])
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When removed value 50 next value at this position`(list: MyMutableList<Int>) {

        repeat(100) {
            list.add(it)
        }
        list - 50
        assertEquals(51, list[50])
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element added to first position then it is in first position`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        list.add(0, 1000)
        assertEquals(1000, list.get(0))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When element added to lats position then it is in last position`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        list.add(100, 1000)
        assertEquals(1000, list[100])
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When list was cleared then size is 0`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        list.clear()
        assertEquals(0, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When list contains element then method returns true`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        assertTrue(list.contains(90))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When list does not contains element then method returns false`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        assertFalse(list.contains(1000))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method get invoke with wrong index then exception is thrown`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> {
            list[100]
        }
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method get invoke with negative index then exception is thrown`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> {
            list[-100]
        }
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method add invoke with wrong index then exception is thrown`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> {
            list.add(101, 1000)
        }
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method add invoke with negative index then exception is thrown`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> {
            list.add(-101, 1000)
        }
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method removeAt invoke with wrong index then exception is thrown`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> {
            list.removeAt(100)
        }
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `When method removeAt invoke with negative index then exception is thrown`(list: MyMutableList<Int>) {
        repeat(100) {
            list.add(it)
        }
        assertThrows<IndexOutOfBoundsException> {
            list.removeAt(-100)
        }
    }

    companion object {
        @JvmStatic
        fun mutableListSource() = listOf(MyArrayList<Int>(), MyLinkedList<Int>())
    }

}