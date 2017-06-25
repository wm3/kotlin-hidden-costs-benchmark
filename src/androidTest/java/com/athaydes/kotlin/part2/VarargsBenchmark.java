package com.athaydes.kotlin.part2;

import com.athaydes.kotlin.BlackHole;
import com.athaydes.kotlin.Config;

import org.junit.runner.RunWith;

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
public class VarargsBenchmark {

    @BenchmarkConfiguration
    public SpannerConfig configuration = Config.config(getClass());

    @Param("5,0,3,-1,-6,7,-7,4")
    public String intArrayString;

    BlackHole blackHole;
    int[] intArray;

    @BeforeExperiment
    public void setup() {
        blackHole = new BlackHole();
        String[] nums = intArrayString.split(",");
        intArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            intArray[i] = Integer.parseInt(nums[i]);
        }
    }

    @Benchmark
    public BlackHole javaIntVarargs(int reps) {
        for (int i = 0; i < reps; i++) {
            JavaExamples.runPrintDouble(blackHole, intArray);
        }
        return blackHole;
    }

    @Benchmark
    public BlackHole kotlinIntVarargs(int reps) {
        for (int i = 0; i < reps; i++) {
            Kotlin_sourcesKt.runPrintDouble(blackHole, intArray);
        }
        return blackHole;
    }
}
