package com.athaydes.kotlin

import com.athaydes.kotlin.part1.Database

fun runKotlinLambda(db: Database): Int {
    val deletedRows = transaction(db) {
        it.delete("Customers", null, null)
    }

    return deletedRows
}

fun runKotlinInlinedFunction(db: Database): Int {
    val deletedRows = inlineTransaction(db) {
        it.delete("Customers", null, null)
    }

    return deletedRows
}

fun transaction(db: Database, body: (Database) -> Int): Int {
    db.beginTransaction()
    try {
        val result = body(db)
        db.setTransactionSuccessful()
        return result
    } finally {
        db.endTransaction()
    }
}

inline fun inlineTransaction(db: Database, body: (Database) -> Int): Int {
    db.beginTransaction()
    try {
        val result = body(db)
        db.setTransactionSuccessful()
        return result
    } finally {
        db.endTransaction()
    }
}

fun runCompanionObjectCallToPrivateConstructor(blackHole: BlackHole) {
    val myClass = MyClass.newInstance()
    blackHole.consume(myClass.helloWorld())
}

fun runCompanionObjectCallToPrivateConstructorStatic(blackHole: BlackHole) {
    val myClass = MyClass2.newInstance()
    blackHole.consume(myClass.helloWorld())
}

class MyClass private constructor() {

    companion object {
        private val TAG = "TAG"

        fun newInstance() = MyClass()
    }

    fun helloWorld() = TAG
}

class MyClass2 private constructor() {
    companion object {
        private const val TAG = "TAG"

        @JvmStatic
        fun newInstance() = MyClass2()
    }

    fun helloWorld() = TAG
}
