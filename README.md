# Kotlin Hidden Costs Benchmark Android

This is a reponse to [Kotlin Hidden Costs - Benchmarks](https://sites.google.com/a/athaydes.com/renato-athaydes/posts/kotlinshiddencosts-benchmarks)

Which in turn is based on the series of blog posts called *Kotlin Hidden Costs*.

[Part 1](https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-1-fbb9935d9b62)

[Part 2](https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-2-324a4a50b70)

[Part 3](https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-3-3bf6e0dbf0a4)

My blog post showing the results of this benchmark on android: TODO

Results from a Google Pixel on Android 7.1.2 https://github.com/evant/kotlin-hidden-costs-benchmark/tree/android/benchmark-results

## Running this benchmark

```
./gradlew connectedCheck
```
You can check the adb log for links to reports on https://microbenchmarks.appspot.com/

You can also pull json results out of appDir/files/results/

I'd advise running this on an actual device, not the emulator.
