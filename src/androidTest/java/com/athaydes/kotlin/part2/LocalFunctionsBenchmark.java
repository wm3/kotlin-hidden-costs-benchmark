package com.athaydes.kotlin.part2;

import com.athaydes.kotlin.Config;

import org.junit.runner.RunWith;

import dk.ilios.spanner.Benchmark;
import dk.ilios.spanner.BenchmarkConfiguration;
import dk.ilios.spanner.Param;
import dk.ilios.spanner.SpannerConfig;
import dk.ilios.spanner.junit.SpannerRunner;

/**
 * https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-2-324a4a50b70
 */
@RunWith(SpannerRunner.class)
public class LocalFunctionsBenchmark {

    @BenchmarkConfiguration
    public SpannerConfig configuration = Config.config(getClass());

    @Param("10")
    public int a;

    @Benchmark
    public int javaLocalFunction(int reps) {
        int result = 0;
        for (int i = 0; i < reps; i++) {
            result += JavaExamples.runJavaLocalFunction(a);
        }
        return result;
    }

    @Benchmark
    public int javaLocalFunctionWithoutCapturingLocalVariable(int reps) {
        int result = 0;
        for (int i = 0; i < reps; i++) {
            result += JavaExamples.runJavaLocalFunctionWithoutCapturingLocalVariable(a);
        }
        return result;
    }

    @Benchmark
    public int kotlinLocalFunctionCapturingLocalVariable(int reps) {
        int result = 0;
        for (int i = 0; i < reps; i++) {
            result += Kotlin_sourcesKt.runLocalFunctionCapturingLocalVariable(a);
        }
        return result;
    }

    @Benchmark
    public int kotlinLocalFunctionWithoutCapturingLocalVariable(int reps) {
        int result = 0;
        for (int i = 0; i < reps; i++) {
            result += Kotlin_sourcesKt.runLocalFunctionWithoutCapturingLocalVariable(a);
        }
        return result;
    }
}
