package com.azeti.challenge.greatlow

fun arrayChallenge(intArr: Array<Int>) = findNthGreatLow(intArr, 2)?.let { "${it.first} ${it.second}" }

fun findNthGreatLow(intArr: Array<Int>, n: Int): Pair<Int, Int>? =
    intArr.toList().sorted().distinct()
        .takeIf { it.size >= n }
        ?.let {
            it[n-1] to it[it.size - n]
        }