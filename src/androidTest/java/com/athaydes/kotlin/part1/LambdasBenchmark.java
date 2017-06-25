package com.athaydes.kotlin.part1;

import com.athaydes.kotlin.Config;
import com.athaydes.kotlin.Kotlin_sourcesKt;

import org.junit.runner.RunWith;

import dk.ilios.spanner.BeforeExperiment;
import dk.ilios.spanner.Benchmark;
import dk.ilios.spanner.BenchmarkConfiguration;
import dk.ilios.spanner.SpannerConfig;
import dk.ilios.spanner.junit.SpannerRunner;

/**
 * https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-1-fbb9935d9b62
 */
@RunWith(SpannerRunner.class)
public class LambdasBenchmark {
    @BenchmarkConfiguration
    public SpannerConfig config = Config.config(getClass());

    private Database db;

    @BeforeExperiment
    public void setup() {
        db = new Database();
    }

    @Benchmark
    public int javaLambda(int reps) {
        int result = 0;
        for (int i = 0; i < reps; i++) {
            result += JavaExamples.runJavaLambda(db);
        }
        return result;
    }

    @Benchmark
    public int javaLambdaGeneric(int reps) {
        int result = 0;
        for (int i = 0; i < reps; i++) {
            result += JavaExamples.runJavaLambdaGeneric(db);
        }
        return result;
    }

    @Benchmark
    public int kotlinLambda(int reps) {
        int result = 0;
        for (int i = 0; i < reps; i++) {
            result += Kotlin_sourcesKt.runKotlinLambda(db);
        }
        return result;
    }

    @Benchmark
    public int kotlinInlinedFunction(int reps) {
        int result = 0;
        for (int i = 0; i < reps; i++) {
            result += Kotlin_sourcesKt.runKotlinInlinedFunction(db);
        }
        return result;
    }
}
