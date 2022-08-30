package com.example.kotlinstudy


class HelloBot {
//    var greeting: String? = null
// 불변 변수로 바꿈
    val greeting: String by lazy { getHello() }
    fun sayHello() = println(greeting)
}

fun getHello() = "Hi Hello"

fun main() {
    val helloBot = HelloBot()

    // 실행되면서 초기화
//    helloBot.greeting = getHello()
    helloBot.sayHello()
}
