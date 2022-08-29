package com.example.kotlinstudy

// 공변성
class MyGenerics<out T>(val t:T) {}

class Bag<T> {
    fun saveAll(
            to: MutableList<in T>,
            from: MutableList<T>,
    ) {
        to.addAll(from)
    }
}

fun main() {
    // 제네릭을 사용한 클래스의 인스턴스를 만드려면 type argument 를 제공
//    val generics = MyGenerics<String>("test")

    // type 생략 가능
//    val generics = MyGenerics("test")

    // 변수의 타입에 제네릭을 사용한 경우
    val list1: MutableList<String> = mutableListOf()
    // type argument 를 생성자에서 추가
    val list2 = mutableListOf<String>()

    val list3: List<*> = listOf<String>("test")
    val list4: List<*> = listOf<Int>(1, 2, 3, 4)

    // PECS -> Producer-Extends, Consumer-Super
    // 공변성 -> 자바 제네릭의 extends 코틀린의 out
    // 반공변성 -> 자바 제네릭의 super 코틀린의 in

    val generics = MyGenerics<String>("test")
    // 상위타입의 CharSequence 이므로 공변성 부여 가능
    val charGenerics: MyGenerics<CharSequence> = generics


    val bag = Bag<String>()
    bag.saveAll(mutableListOf<CharSequence>("1", "2"), mutableListOf<String>("3", "4"))
}
