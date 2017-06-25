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
public class RangesIndirectRefsBenchmark {

    @BenchmarkConfiguration
    public SpannerConfig configuration = Config.config(getClass());

    @Param("44")
    int j;

    @Benchmark
    public boolean kotlinLocallyDeclaredRange(int reps) {
        boolean result = false;
        for (int i = 0; i < reps; i++) {
            result = Kotlin_sourcesKt.runIsInOneToTenWithLocalRange(j);
        }
        return result;
    }

    @Benchmark
    public boolean kotlinIndirectRange(int reps) {
        boolean result = false;
        for (int i = 0; i < reps; i++) {
            result = Kotlin_sourcesKt.runIsInOneToTenWithIndirectRange(j);
        }
        return result;
    }
}
