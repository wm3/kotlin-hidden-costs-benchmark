package com.athaydes.kotlin.part3

import java.util.Collections
import com.athaydes.kotlin.BlackHole

fun rangeForEachMethod(blackHole: BlackHole) {
    (1..10).forEach {
        blackHole.consume(it)
    }
}

fun rangeForEachLoop(blackHole: BlackHole) {
    for (it in 1..10) {
        blackHole.consume(it)
    }
}

fun rangeForEachLoopWithBoxing(blackHole: BlackHole) {
    for (it in 1..10) {
        blackHole.consume(it as Int?)
    }
}

fun rangeForEachLoopWithBoxingLargeNum(blackHole: BlackHole) {
    for (it in 1001..1010) {
        blackHole.consume(it as Int?)
    }
}

fun rangeForEachLoopWithArrayCreation(blackHole: BlackHole) {
    for (it in 1..10) {
        blackHole.consumeArray(intArrayOf(it))
    }
}

fun rangeForEachLoopWithRandomAccess(blackHole: BlackHole, ra: RandomAccessor) {
    for (it in 1..10) {
        blackHole.consume(ra.next(it))
    }
}

class RandomAccessor {
    private val values = (0 until (1024 * 1024)).toMutableList().let {
        Collections.shuffle(it)
        it.toIntArray()
    }
    private var current = 0

    fun next(value: Int): Int {
        current = values[current]
        return value + current
    }
}
