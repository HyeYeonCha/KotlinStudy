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


class LateInit {
    // 꼭 가변변수, none null 사용하기
    lateinit var text: String

    // isInitialized 사용하려면 class 내부여야 하므로 별도의 getter 만들어서 호출
    val textInitialized: Boolean
        get() = this::text.isInitialized

    fun printText() {
        // 초기화 꼭 먼저 되어야 함
//        text = "HI HI HI HI HI"
//        println(text)

        // isInitialized -> class 내부에서만 사용 가능함. 초기화 되었는지 판단하기 (아니면 별도의 getter 만들기)
        if (this::text.isInitialized) {
            println("init")
            println(text)
        } else {
            println("no no no")
        }
    }
}

fun main() {
    val helloBot = HelloBot()

    // 실행되면서 초기화
//    helloBot.greeting = getHello()
//    helloBot.sayHello()

    // 호출을 여러번 해도 초기화 코드는 한 번만 동작한다.
    // 멀티 쓰레드 환경에서도 안정적으로 동작
//    for (i in 1 .. 5) {
//        Thread {
//            helloBot.sayHello()
//        }.start()
//    }

    // late init
    val test = LateInit()
//    test.printText()

    if (test.textInitialized)  {
        println("yes")
    } else {
        println("no init")
        test.text = "직접 초기화"
    }

    test.printText()

}
