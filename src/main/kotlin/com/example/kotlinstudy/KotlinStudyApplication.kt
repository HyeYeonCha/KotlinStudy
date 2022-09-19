package com.example.kotlinstudy

import com.example.kotlinstudy.exception.JavaThrow
import java.io.IOException
import kotlin.jvm.Throws

class KotlinThrow {
    // 다른 클래스에 exception 전파를 하고 싶다면 사용
    @Throws(IOException::class)
    fun throwIOException() {
        throw IOException("체크드 익셉션인 IOException 발생")
    }
}

enum class CountryCode {
    ko, jp, us, `do` // 예약어 do -> 백틱으로 사용가능
}

fun main() {
    val javaThrow = JavaThrow()
    javaThrow.throwIOException()

    val kotlinThrow = KotlinThrow()
    kotlinThrow.throwIOException()
}

