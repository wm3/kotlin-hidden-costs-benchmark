package com.athaydes.kotlin.part3;

import com.athaydes.kotlin.BlackHole;
import com.athaydes.kotlin.Config;

import org.junit.runner.RunWith;

import dk.ilios.spanner.BeforeExperiment;
import dk.ilios.spanner.Benchmark;
import dk.ilios.spanner.BenchmarkConfiguration;
import dk.ilios.spanner.SpannerConfig;
import dk.ilios.spanner.junit.SpannerRunner;

/**
 * https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-3-3bf6e0dbf0a4
 */
@RunWith(SpannerRunner.class)
public class RangesIterationBenchmark {

    @BenchmarkConfiguration
    public SpannerConfig configuration = Config.config(getClass());

    BlackHole blackHole;

    @BeforeExperiment
    public void setup() {
        blackHole = new BlackHole();
    }

    @Benchmark
    public BlackHole kotlinRangeForEachFunction(int reps) {
        for (int i = 0; i < reps; i++) {
            Kotlin_sourcesKt.rangeForEachMethod(blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole kotlinRangeForEachLoop(int reps) {
        for (int i = 0; i < reps; i++) {
            Kotlin_sourcesKt.rangeForEachLoop(blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole kotlinRangeForEachLoopWithStep1(int reps) {
        for (int i = 0; i < reps; i++) {
            Kotlin_sourcesKt.rangeForEachLoopWithStep1(blackHole);
        }
        return blackHole;
    }
}
