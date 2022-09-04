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

    // 내부 익명함수 호출하기
    outerFunc()()

    // 후행 람다의 예제
    // 내부적으로 함수를 전달받아 함수를 선언하지 않아도 내부 로직 구현 가능
    list2.forEach{
        println(it)
    }
    list2.filter {
        it == "a"
    }

    // 인자가 하나인 내부함수
    arg1{
        it.length
        it.first()
    }
    // 인자가 2 개 이상인 내부함수
    arg2{
//        it  -> 사용할 수 없다. (인자가 두 개 이상이라)
    // 별도의 내부 변수 선언이 필요함
        a: String, b: String ->
        a.length
        b.first()
    }

    val callReference: () -> Unit = { printHello() }
    callReference()
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

//fun outerFunc() : () -> Unit {
////    return fun() {
////        println("익명 함수")
////    }
//
//    return { println("익명 함수") }
//}

fun outerFunc() : () -> Unit = { println("익명 함수") }

// 람다 표현식의 전체 식
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
// 최대한 생략한 람다 식
val sum2 = { x: Int, y: Int -> x + y }

fun arg1(block: (String) -> Unit){}
fun arg2(block: (String, String) -> Unit){}