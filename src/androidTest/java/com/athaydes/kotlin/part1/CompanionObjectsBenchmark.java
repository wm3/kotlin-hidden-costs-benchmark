package com.athaydes.kotlin.part1;

import com.athaydes.kotlin.BlackHole;
import com.athaydes.kotlin.Config;
import com.athaydes.kotlin.Kotlin_sourcesKt;

import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import dk.ilios.spanner.BeforeExperiment;
import dk.ilios.spanner.Benchmark;
import dk.ilios.spanner.BenchmarkConfiguration;
import dk.ilios.spanner.SpannerConfig;
import dk.ilios.spanner.junit.SpannerRunner;

/**
 * https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-1-fbb9935d9b62
 */
@RunWith(SpannerRunner.class)
public class CompanionObjectsBenchmark {

    @BenchmarkConfiguration
    public SpannerConfig configuration = Config.config(getClass(), 5, TimeUnit.SECONDS);

    BlackHole blackHole;

    @BeforeExperiment
    public void setup() {
        blackHole = new BlackHole();
    }

    @Benchmark
    public BlackHole kotlinPrivateConstructorCallFromCompanionObject(int reps) {
        for (int i = 0; i < reps; i++) {
            Kotlin_sourcesKt.runCompanionObjectCallToPrivateConstructor(blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole kotlinPrivateStaticConstructorCallFromCompanionObject(int reps) {
        for (int i = 0; i < reps; i++) {
            Kotlin_sourcesKt.runCompanionObjectCallToPrivateConstructorStatic(blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole javaPrivateConstructorCallFromStaticMethod(int reps) {
        for (int i = 0; i < reps; i++) {
            JavaExamples.runPrivateConstructorFromStaticMethod(blackHole);
        }
        return blackHole;
    }
}
