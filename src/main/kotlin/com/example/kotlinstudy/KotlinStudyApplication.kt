package com.example.kotlinstudy

fun main() {
    val str: String? = "null"

    val result: Int? = str?.let {
        println(it)
        123
    }

    println(result)
}
