package com.example.kotlinstudy

fun String.first() : Char {
    return this[0]
}

fun String.addFirst(char: Char): String {
    return char + this.substring(0)
}

class MyExample {
    fun printMessage() = println("class")
}

// MyExample class 의 멤버 함수와 동일한 이름과 동일한 형태라면 실행 안됨.
fun MyExample.printMessage() = println("asdfasdfas")

// 구조가 다르므로 실행 가능
fun MyExample.printMessage(message: String) = println("change $message")

fun MyExample?.printNullOrNotNull() {
    if (this == null) println("null null")
    else println("not null")
}

fun main() {
    println("asdf".first())
    println("asdf".addFirst('A'))

    MyExample().printMessage()
    MyExample().printMessage(message = "message")

    var myExample: MyExample? = null
    myExample.printNullOrNotNull()

    myExample = MyExample()
    myExample.printNullOrNotNull()
}
