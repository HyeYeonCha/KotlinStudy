package com.example.kotlinstudy

fun getStr(): Nothing = throw Exception("throw new Exception")

fun main() {

//    val result = try {
//        getStr()
//    } catch (e: Exception) {
//        println(e.message)
//        "exception"
//    }

    val result = runCatching { getStr() }.getOrElse {
        println(it.message)
        "exception"
    }

    println(result)
}
