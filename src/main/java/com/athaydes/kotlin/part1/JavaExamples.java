package com.athaydes.kotlin.part1;

import com.athaydes.kotlin.BlackHole;

import static com.athaydes.kotlin.part1.MyJavaClass.newInstance;

/**
 * Translation of the Kotlin examples to Java.
 */
public class JavaExamples {

    public static int runJavaLambda(Database db) {
        int deletedRows = transaction(db, (database) ->
                database.delete("Customer", null, null));

        return deletedRows;
    }

    public static int runJavaLambdaGeneric(Database db) {
        int deletedRows = genericTransaction(db, (database) ->
                database.delete("Customer", null, null));

        return deletedRows;
    }

    public static int transaction(Database db, ToIntFunction<Database> body) {
        db.beginTransaction();
        try {
            int result = body.applyAsInt(db);
            db.setTransactionSuccessful();
            return result;
        } finally {
            db.endTransaction();
        }
    }

    public static int genericTransaction(Database db, Function<Database, Integer> body) {
        db.beginTransaction();
        try {
            int result = body.apply(db);
            db.setTransactionSuccessful();
            return result;
        } finally {
            db.endTransaction();
        }
    }

    public static void runPrivateConstructorFromStaticMethod(BlackHole blackHole) {
        MyJavaClass myJavaClass = newInstance();
        blackHole.consume(myJavaClass.helloWorld());
    }
}

class MyJavaClass {

    private static final String TAG = "TAG";

    private MyJavaClass() {
    }

    public static String helloWorld() {
        return TAG;
    }

    public static MyJavaClass newInstance() {
        return new MyJavaClass();
    }
}

interface Function<T, R> {
    R apply(T var1);
}

interface ToIntFunction<T> {
    int applyAsInt(T var1);
}
