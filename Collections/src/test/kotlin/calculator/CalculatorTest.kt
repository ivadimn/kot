package calculator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.Test

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 5 add to 10 then 15`(calculator: Calculator) {
        val result = calculator.sum(10, 5)
        val expected = 15
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 11 sub from 31 then 20`(calculator: Calculator) {
        val result = calculator.sub(31, 11)
        val expected = 20
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 10 sub from 5 then -5`(calculator: Calculator) {
        val result = calculator.sub(5, 10)
        val expected = -5
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 10 mul to 7 then 70`(calculator: Calculator) {
        val result = calculator.mul(10, 7)
        val expected = 70
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 10 mul to -7 then 70`(calculator: Calculator) {
        val result = calculator.mul(10, -7)
        val expected = -70
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 20 div on 4 then 5`(calculator: Calculator) {
        val result = calculator.div(20, 4)
        val expected = 5.0
        assertEquals(expected, result, 0.001)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 15 div on 10 then 1`(calculator: Calculator) {
        val result = calculator.div(15, 10)
        val expected = 1.5
        assertEquals(expected, result, 0.001)
    }

    @ParameterizedTest
    @MethodSource("calculatorsSource")
    fun `When 50 add to 100 then 150`(calculator: Calculator) {
        val result = calculator.sum(100, 50)
        val expected = 150
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun calculatorsSource() = listOf(SimpleCalculator(), LoggingCalculator())
    }


}