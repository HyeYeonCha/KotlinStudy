package com.example.kotlinstudy

class MyGenerics<T>(val t:T) {}

fun main() {
    // 제네릭을 사용한 클래스의 인스턴스를 만드려면 type argument 를 제공
//    val generics = MyGenerics<String>("test")

    // type 생략 가능
    val generics = MyGenerics("test")

    // 변수의 타입에 제네릭을 사용한 경우
    val list1: MutableList<String> = mutableListOf()
    // type argument 를 생성자에서 추가
    val list2 = mutableListOf<String>()

    val list3: List<*> = listOf<String>("test")
    val list4: List<*> = listOf<Int>(1, 2, 3, 4)
}
