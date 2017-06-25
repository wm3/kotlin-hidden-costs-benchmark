package com.athaydes.kotlin.part3;


import com.athaydes.kotlin.BlackHole;
import com.athaydes.kotlin.Config;

import org.junit.runner.RunWith;

import java.util.Arrays;

import dk.ilios.spanner.BeforeExperiment;
import dk.ilios.spanner.Benchmark;
import dk.ilios.spanner.BenchmarkConfiguration;
import dk.ilios.spanner.Param;
import dk.ilios.spanner.SpannerConfig;
import dk.ilios.spanner.junit.SpannerRunner;

/**
 * https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-3-3bf6e0dbf0a4
 */
@RunWith(SpannerRunner.class)
public class CollectionIndicesBenchmark {

    @BenchmarkConfiguration
    public SpannerConfig configuration = Config.config(getClass());

    @Param("A,B,Hi,ZZ,FFF")
    String sparseArrayString;

    BlackHole blackHole;
    SparseArray<String> sparseArray;

    @BeforeExperiment
    public void setup() {
        blackHole = new BlackHole();
        String[] values = sparseArrayString.split(",");
        sparseArray = new SparseArray<>(Arrays.asList(values));
    }

    @Benchmark
    public BlackHole kotlinCustomIndicesIteration(int reps) {
        for (int i = 0; i < reps; i++) {
            Kotlin_sourcesKt.printValuesUsingIndices(sparseArray, blackHole);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole kotlinIterationUsingLastIndexRange(int reps) {
        for (int i = 0; i < reps; i++) {
            Kotlin_sourcesKt.printValuesUsingLastIndexRange(sparseArray, blackHole);
        }
        return blackHole;
    }
}
