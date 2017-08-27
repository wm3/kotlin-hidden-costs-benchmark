package com.athaydes.kotlin.part3

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
