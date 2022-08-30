package com.example.kotlinstudy

class RunExample {
    var a1: String? = null
    var a2: String? = null

    fun exam():Boolean {
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


    // with -> 결과 반환 없이 내부에서 수신객체를 사용하고 싶을 때 사용
    val str = "HI HI HI"
    val length : Int = with(str) {
        length
    }

    println(length)

}
