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
    RandomAccessor randomAccessor;

    @BeforeExperiment
    public void setup() {
        blackHole = new BlackHole();
        randomAccessor = new RandomAccessor();
    }

    @Benchmark
    public BlackHole t0_range_forEachFunction(int reps) {
        for (int i = 0; i < reps; i++) {
            Kotlin_sourcesKt.rangeForEachMethod(blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole t0_range_forEachLoop(int reps) {
        for (int i = 0; i < reps; i++) {
            Kotlin_sourcesKt.rangeForEachLoop(blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole t1_rangeForEachLoop_withBoxing(int reps) {
        for (int i = 0; i < reps; i++) {
            Kotlin_sourcesKt.rangeForEachLoopWithBoxing(blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole t1_rangeForEachLoop_withBoxingLargeNum(int reps) {
        for (int i = 0; i < reps; i++) {
            Kotlin_sourcesKt.rangeForEachLoopWithBoxingLargeNum(blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole t1_rangeForEachLoop_withArrayCreation(int reps) {
        for (int i = 0; i < reps; i++) {
            Kotlin_sourcesKt.rangeForEachLoopWithArrayCreation(blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole t1_rangeForEachLoop_withRandomAccess(int reps) {
        for (int i = 0; i < reps; i++) {
            Kotlin_sourcesKt.rangeForEachLoopWithRandomAccess(blackHole, randomAccessor);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole t2_javaForLoop(int reps) {
        for (int i = 0; i < reps; i++) {
            JavaExamples.runForLoop(blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole t2_javaForLoop_usingEquals(int reps) {
        for (int i = 0; i < reps; i++) {
            JavaExamples.runForLoopUsingEquals(blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole z_javaForLoopInlined(int reps) {
        for (int i = 0; i < reps; i++) {
            JavaExamples.runForLoopInlined(blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole z_javaInlined_1(int reps) {
        for (int i = 0; i < reps; i++) {
            JavaExamples.runInlnied1(blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole z_javaInlined_2(int reps) {
        for (int i = 0; i < reps; i++) {
            JavaExamples.runInlnied2(blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole z_javaInlined_4(int reps) {
        for (int i = 0; i < reps; i++) {
            JavaExamples.runInlnied4(blackHole);
        }
        return blackHole;
    }

}
