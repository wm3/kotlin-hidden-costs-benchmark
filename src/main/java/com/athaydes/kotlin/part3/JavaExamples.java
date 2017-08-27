package com.athaydes.kotlin.part3;

import com.athaydes.kotlin.BlackHole;

public class JavaExamples {

    public static void runForLoop(BlackHole blackHole) {
        for (int i = 1; i <= 10; ++i) {
            blackHole.consume(i);
        }
    }

    public static void runInlnied1(BlackHole blackHole) {
        blackHole.consume(10);
    }

    public static void runInlnied2(BlackHole blackHole) {
        blackHole.consume(5);
        blackHole.consume(10);
    }

    public static void runInlnied4(BlackHole blackHole) {
        blackHole.consume(3);
        blackHole.consume(5);
        blackHole.consume(8);
        blackHole.consume(10);
    }

    public static void runForLoopInlined(BlackHole blackHole) {
        blackHole.consume(1);
        blackHole.consume(2);
        blackHole.consume(3);
        blackHole.consume(4);
        blackHole.consume(5);
        blackHole.consume(6);
        blackHole.consume(7);
        blackHole.consume(8);
        blackHole.consume(9);
        blackHole.consume(10);
    }

    public static void runForLoopUsingEquals(BlackHole blackHole) {
        for (int i = 1; i != 10; ++i) {
            blackHole.consume(i);
        }
    }
}
