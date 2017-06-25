package com.athaydes.kotlin.part3;

import com.athaydes.kotlin.Config;

import org.junit.runner.RunWith;

import dk.ilios.spanner.Benchmark;
import dk.ilios.spanner.BenchmarkConfiguration;
import dk.ilios.spanner.Param;
import dk.ilios.spanner.SpannerConfig;
import dk.ilios.spanner.junit.SpannerRunner;

/**
 * https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-3-3bf6e0dbf0a4
 */
@RunWith(SpannerRunner.class)
public class RangesNonPrimitiveTypesBenchmark {

    @BenchmarkConfiguration
    public SpannerConfig configuration = Config.config(getClass());

    @Param("John")
    String name;

    @Benchmark
    public boolean javaStringComparisons(int reps) {
        boolean result = false;
        for (int i = 0; i < reps; i++) {
            result = JavaExamples.isBetweenNames(name);
        }
        return result;
    }

    @Benchmark
    public boolean kotlinStringRangeInclusionWithLocalRange(int reps) {
        boolean result = false;
        for (int i = 0; i < reps; i++) {
            result = Kotlin_sourcesKt.isBetweenNamesWithLocalRange(name);
        }
        return result;
    }

    @Benchmark
    public boolean kotlinStringRangeInclusionWithConstantRange(int reps) {
        boolean result = false;
        for (int i = 0; i < reps; i++) {
            result = Kotlin_sourcesKt.isBetweenNamesWithConstantRange(name);
        }
        return result;
    }
}
