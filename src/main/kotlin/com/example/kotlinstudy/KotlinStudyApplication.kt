package com.example.kotlinstudy

class RunExample {
    var a1: String? = null
    var a2: String? = null

    fun exam(): Boolean {
        println("123...")
        Thread.sleep(1000)
        println("...456")

        return true
    }
}
fun main() {
//    val str: String? = "null"
//
//    val result: Int? = str?.let {
//        println(it)
//        123
//    }
//
//    println(result)

    val run = RunExample().run {
        // this 가 자동으로 붙음
        a1 = "asdfa"
        a2 = "a2"
        exam()
    }
    println(run)

//    val result = run.exam()
//    println(result)
}
