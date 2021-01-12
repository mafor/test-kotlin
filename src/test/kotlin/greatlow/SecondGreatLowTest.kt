package com.azeti.challenge.greatlow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SecondGreatLowTest {

    @Test
    fun `Test case 1`() {
        val numbers = arrayOf(1, 42, 42, 180)
        assertEquals("42 42", arrayChallenge(numbers))
    }

    @Test
    fun `Test case 2`() {
        val times = arrayOf(4, 90)
        assertEquals("90 4", arrayChallenge(times))
    }

    @Test
    fun `Duplicated numbers`() {
        val times = arrayOf(4, 90, 90)
        assertEquals("90 4", arrayChallenge(times))
    }

    @Test
    fun `Duplicated all numbers`() {
        val times = arrayOf(90, 90, 90)
        assertEquals(null, arrayChallenge(times))
    }
}