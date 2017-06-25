package com.athaydes.kotlin.part2;

import com.athaydes.kotlin.BlackHole;
import com.athaydes.kotlin.Config;

import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import dk.ilios.spanner.BeforeExperiment;
import dk.ilios.spanner.Benchmark;
import dk.ilios.spanner.BenchmarkConfiguration;
import dk.ilios.spanner.Param;
import dk.ilios.spanner.SpannerConfig;
import dk.ilios.spanner.junit.SpannerRunner;

/**
 * https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-2-324a4a50b70
 */
@RunWith(SpannerRunner.class)
public class NullSafetyBenchmark {

    @BenchmarkConfiguration
    public SpannerConfig configuration = Config.config(getClass(), 5, TimeUnit.SECONDS);

    @Param("John")
    public String who;

    BlackHole blackHole;

    @BeforeExperiment
    public void setup() {
        blackHole = new BlackHole();
    }

    @Benchmark
    public BlackHole javaSayHello(int reps) {
        for (int i = 0; i < reps; i++) {
            JavaExamples.sayHello(who, blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole kotlinSayHello(int reps) {
        for (int i = 0; i < reps; i++) {
            Kotlin_sourcesKt.sayHello(who, blackHole);
        }
        return blackHole;
    }
}
