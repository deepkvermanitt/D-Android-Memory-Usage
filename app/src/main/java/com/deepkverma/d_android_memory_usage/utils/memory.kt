package com.deepkverma.d_android_memory_usage.utils

import timber.log.Timber


fun logCurrentMemoryProfile(src: String): String {
    val maxMemoryInMB = Runtime.getRuntime().maxMemory() / 1024 / 1024
    val totalMemoryInMB = Runtime.getRuntime().totalMemory() / 1024 / 1024
    val freeMemoryInMB = Runtime.getRuntime().freeMemory() / 1024 / 1024
    val usedMemoryInMB = totalMemoryInMB - freeMemoryInMB

    Timber.tag(src).d("***************************")
    Timber.tag(src).d("Start for the source: $src")

    Timber.tag(src).d("maxMemoryInMB : $maxMemoryInMB")
    Timber.tag(src).d("totalMemoryInMB : $totalMemoryInMB")
    Timber.tag(src).d("freeMemoryInMB : $freeMemoryInMB")
    Timber.tag(src).d("usedMemoryInMB : $usedMemoryInMB")

    Timber.tag(src).d("***************************")
    Timber.tag(src).d("End for the source: $src")
    return "usedMemoryInMB ${usedMemoryInMB} Source ${src}";
}

val listOfInt: MutableList<Int> = arrayListOf()
fun addListOfInt() {
    for (i in 1..100000) {
        listOfInt.add(i)
    }
}