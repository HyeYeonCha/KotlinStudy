package com.example.kotlinstudy

fun String.first() : Char {
    return this[0]
}

fun String.addFirst(char: Char): String {
    return char + this.substring(0)
}

fun main() {
    println("asdf".first())
    println("asdf".addFirst('A'))
}
