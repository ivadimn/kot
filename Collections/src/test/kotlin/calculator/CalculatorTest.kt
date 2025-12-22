package calculator

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `When 5 add to 10 then 15`() {
        val result = calculator.sum(10, 5)
        val expected = 15
        assertEquals(expected, result)
    }

    @Test
    fun `When 50 add to 100 then 150`() {
        val result = calculator.sum(100, 50)
        val expected = 150
        assertEquals(expected, result)
    }

    @Test
    fun test() {
        var number = 0.0
        repeat(100) {
            number += 0.01
        }
        val expected = 1.0
        assertEquals(expected, number, 0.001)
    }

}