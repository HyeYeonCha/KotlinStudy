package com.example.kotlinstudy

data class Person(val name:String, val age:Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        return result
    }
}

fun main() {
    val person1 = Person(name = "asdf", age =12)
    val person2 = Person(name = "asdf", age =12)

    println(person1 == person2)

    val set = hashSetOf(person1)
    println(set.contains(person2))

    // 불변성이 지켜지지 않은 경우
//    person2.name = "asdfasfdsa"
//    println(set.contains(person2)) // false

    val person3 = person1.copy(name = "adsfasfdfdsa")
    println(person3)
    println(person1 == person3)

    println(person1.toString())

    // component
    println("이름 : ${person2.component1()} , 나이 : ${person2.component2()}")

    // 구조분해 할당
    val (name, age) = person3

    println("이름은 $name and  나이는 $age")

}
