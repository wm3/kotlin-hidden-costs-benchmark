# Kotlin Hidden Costs Benchmark of `for` Loops on Android

This is micro benchmarks to see performance of `for` loops of Kotlin.

The result of this benchmark is used in [my article(Japanese)](http://qiita.com/wm3/items/340ebe5f13f2f0e5d19f).


## References

### Benchmarks

- [Kotlin's hidden costs - Android benchmarks](https://willowtreeapps.com/ideas/kotlins-hidden-costs-android-benchmarks) … I forked this benchmark program
- [Kotlin Hidden Costs - Benchmarks](https://sites.google.com/a/athaydes.com/renato-athaydes/posts/kotlinshiddencosts-benchmarks)


### Original Posts of *Kotlin Hidden Costs*

- [Part 1](https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-1-fbb9935d9b62)
- [Part 2](https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-2-324a4a50b70)
- [Part 3](https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-3-3bf6e0dbf0a4)


## Running this benchmark

```
./gradlew connectedCheck
```
You can check the adb log for links to reports on https://microbenchmarks.appspot.com/

You can also pull json results out of appDir/files/results/

I'd advise running this on an actual device, not the emulator.
