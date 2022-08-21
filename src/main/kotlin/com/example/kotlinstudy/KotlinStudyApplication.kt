package com.example.kotlinstudy

import java.util.*
import kotlin.collections.ArrayList

fun main() {

    // immutable
    // listOf -> 표준라이브러리 list 를 만들어주는 팩토리
    val currencyList = listOf("달러", "유로", "원화");

    // mutable
    val mutableCurrencyList = mutableListOf<String>().apply {
        add("원화")
        add("유로")
        add("달러")
    }

    // immutable set
    val numberSet = setOf(1,2,3,4)

    // mutable set
    val mutableSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    // immutable map
    val numberMap = mapOf("one" to 1, "two" to 2)

    // mutable map
    val mutableNumber = mutableMapOf<String, Int>()
    mutableNumber["one"] = 1
    mutableNumber["two"] = 2
    mutableNumber["three"] = 3

    // 컬렉션 빌더는 내부에서 mutable 반환은 immutable
    val numberList: List<Int> = buildList {
        add(1)
        add(2)
        add(3)
    }

    // linkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }

    // arrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    // 순차
    val iterator = currencyList.iterator()
    while (iterator.hasNext()) {
        println("다음 ${iterator.next()}")
    }

    println("-=-=-=-=-=-=-=-=-=-=-")

    for (currency in currencyList) {
        println(currency)
    }

    println("-=-=-=-=-=-=-=-=-=-=-")

    currencyList.forEach {
        println(it)
    }

    // for loop -> map
    val lowerList = listOf("a", "b", "c")
//    val upperList = mutableListOf<String>()

//    for (lowerCase in lowerList) {
//        upperList.add(lowerCase.uppercase())
//    }

    val upperList = lowerList.map { it.uppercase() }

//    println(upperList)

//    val filteredList = mutableListOf<String>()
//    for (upperCase in upperList) {
//        if (upperCase == "A") {
//            filteredList.add(upperCase)
//        }
//    }

    val filteredList = upperList.filter { it == "A" }

    // filter -> 실행때마다 list 를 만듦
    // 연산이 많아지므로 체인이 많아지면 sequence 사용하기
    // sequence 사용하면 마지막 toList 가 동작할 때 리스트를 한 번만 만들 수 있으므로 최적화에 좋다
    val filteredList2 = upperList.asSequence()
            .filter { it == "A" }
            .filter { it == "A" }
            .filter { it == "A" }
            .filter { it == "A" }
            .filter { it == "A" }
            .toList()


    println(filteredList)
}
