package com.example.kotlinstudy


class HelloBot {
    //    var greeting: String? = null
    // 불변 변수로 바꿈
    // SYNCHRONIZED -> 기본값, 멀티쓰레드 환경에서 안정적으로 사용하기 위해
    // NONE -> 쓰레드 동기화 없이 사용
    val greeting: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        println("init")
        getHello()
    }

    fun sayHello() = println(greeting)
}

fun getHello() = "Hi Hello"

fun main() {
    val helloBot = HelloBot()

    // 실행되면서 초기화
//    helloBot.greeting = getHello()
//    helloBot.sayHello()

    // 호출을 여러번 해도 초기화 코드는 한 번만 동작한다.
    // 멀티 쓰레드 환경에서도 안정적으로 동작
    for (i in 1 .. 5) {
        Thread {
            helloBot.sayHello()
        }.start()
    }
}
