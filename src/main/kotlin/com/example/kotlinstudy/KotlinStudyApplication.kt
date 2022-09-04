package com.example.kotlinstudy

fun main() {

    val list = mutableListOf(printHello)
    val exFun: () -> Unit = list[0]
    exFun()

    call(printHello)

    // printNo -> fun 으로 선언해 일급객체의 특성을 가지지 않기 때문에 데이터 구조 또는 인자로 넣을 수 없음. (대입 불가)
    // fun 키워드가 아닌 변수로 만들어야 함
//    val exList = mutableListOf(printNo)
//    call(printNo)

    val result: Int = plus(2, 3)
    println(result)


    // 고차 함수 예제
    val list2 = listOf("a", "b", "c")
    val printStr: (String) -> Unit = { println(it) }
    forEachStr(list2, printStr)

    val upper : (String) -> String = { it.uppercase() }
    println(list2.map(upper))

}

val printHello: () -> Unit = { println("Hello") }

val func: () -> String = {""}

// 함수를 인자로 받아 실행
fun call(block: () -> Unit) {
    block()
}

fun printNo() {
    println("NO")
}

val printMessage: (String) -> Unit = { message: String -> println(message) }
// message -> 자동 String
val printMessage2: (String) -> Unit = { message -> println(message) }
// 변수 없이 it 으로 줄이기
val printMessage3: (String) -> Unit = { println(it) }

val plus: (Int, Int) -> Int = { a, b -> a + b}


fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for (item in collection) {
        action(item)
    }
}

