package com.example.kotlinstudy

import com.example.kotlinstudy.exception.JavaThrow
import java.io.IOException

class KotlinThrow {
    fun throwIOException() {
        throw IOException("체크드 익셉션인 IOException 발생")
    }
}

fun main() {
    val javaThrow = JavaThrow()
    javaThrow.throwIOException()

    val kotlinThrow = KotlinThrow()
    kotlinThrow.throwIOException()
}

