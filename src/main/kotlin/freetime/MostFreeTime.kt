package com.azeti.challenge.freetime

import java.text.ParseException
import java.time.Duration
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun arrayChallenge(strArr: Array<String>): String {
    val periods = strArr.map { parsePeriod(it) }
    return findMostFreeTime(periods).format()
}

fun findMostFreeTime(periods: List<Pair<LocalTime, LocalTime>>): Duration {
    val sorted = periods.sortedBy { it.first }
    var previous = sorted.firstOrNull() ?: return Duration.ZERO
    return sorted.drop(1)
        .map { current ->
            if (current.first > previous.second) {
                Duration.between(previous.second, current.first)
                    .also { previous = current }
            } else Duration.ZERO
        }
        .maxOrNull() ?: Duration.ZERO
}

private val dateTimeFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("hh:mma")

private fun parsePeriod(str: String, ) =
    str.split("-")
        .also { if(it.size != 2) throw ParseException("Invalid format: $str", str.lastIndexOf("-")) }
        .map { LocalTime.parse(it.toUpperCase(), dateTimeFormat) }
        .let { (start, end) ->
            if(start <= end) {
                start to end
            } else {
                start to end.plusHours(24)
            }
        }

private fun Duration.format() = "%02d:%02d".format(this.toHoursPart(), this.toMinutesPart())

