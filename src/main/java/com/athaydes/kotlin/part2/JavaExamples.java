package com.athaydes.kotlin.part2;


import com.athaydes.kotlin.BlackHole;

import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class JavaExamples {

    public static int runJavaLocalFunction(int a) {
        return someMath(a);
    }

    public static int runJavaLocalFunctionWithoutCapturingLocalVariable(int a) {
        return someMath2(a);
    }

    public static int someMath(int a) {
        IntUnaryOperator sumSquare = (int b) -> (a + b) * (a + b);

        return sumSquare.applyAsInt(1) + sumSquare.applyAsInt(2);
    }

    public static int someMath2(int a) {
        IntBinaryOperator sumSquare = (int a2, int b) -> (a2 + b) * (a2 + b);

        return sumSquare.applyAsInt(a, 1) + sumSquare.applyAsInt(a, 2);
    }

    public static void sayHello(String who, BlackHole blackHole) {
//        blackHole.consume("Hello " + who);
        blackHole.consume(who);
    }

    public static void runPrintDouble(BlackHole blackHole, int[] values) {
        printDouble(blackHole, values);
    }

    public static void printDouble(BlackHole blackHole, int... values) {
        for (int value : values) {
            blackHole.consume(value);
        }
    }

}
