package com.azeti.challenge.freetime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.text.ParseException

internal class MostFreeTimeTest {

    @Test
    fun `Test case 1`() {
        val times = arrayOf("12:15PM-02:00PM","09:00AM-10:00AM","10:30AM-12:00PM")
        assertEquals("00:30", arrayChallenge(times))
    }

    @Test
    fun `Test case 2`() {
        val times = arrayOf("12:15PM-02:00PM","09:00AM-12:11PM","02:02PM-04:00PM")
        assertEquals("00:04", arrayChallenge(times))
    }

    @Test
    fun `Overlapping periods with no results`() {
        val times = arrayOf("08:00AM-10:00AM","09:00AM-11:00PM")
        assertEquals("00:00", arrayChallenge(times))
    }

    @Test
    fun `Overlapping periods with results`() {
        val times = arrayOf("08:00AM-12:00PM","09:00AM-11:00PM", "12:30PM-01:00PM")
        assertEquals("00:30", arrayChallenge(times))
    }

    @Test
    fun `Over-midnight times`() {
        val times = arrayOf("10:00PM-11:00PM","11:30PM-00:30AM")
        assertEquals("00:30", arrayChallenge(times))
    }

    @Test
    fun `Invalid format`() {
        val times = arrayOf("08:00AM-12:00PM-13:00PM")
        assertThrows<ParseException>("Invalid format: ${times[0]}") { arrayChallenge(times) }
    }

    @Test
    fun `Empty list`() {
        val times = arrayOf<String>()
        assertEquals("00:00", arrayChallenge(times))
    }
}