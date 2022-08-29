package com.example.kotlinstudy

sealed class Developer
{
    abstract val name:String
    abstract fun code(language: String)
}

data class Backend(override val name:String) : Developer() {
    override fun code(language: String) {
        println("backend use $language ")
    }
}

data class Frontend(override val name:String): Developer() {
    override fun code(language: String) {
        println("frontend use $language")
    }
}

// sealed class 는 when 사용시 반드시 상속받는 모든 class 를 구현해 줘야 함.
object Other: Developer() {
    override val name: String = "none"

    override fun code(language: String) {
        println("none object")
    }

}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when(developer) {
        is Backend -> pool[developer.name] = developer
        is Frontend -> pool[developer.name] = developer
        is Other -> println("no no no")
//        else -> println("nope.") -> 필요없어짐, sealed class 이므로 하위 클래스를 컴파일러가 알아서 찾아주므로
    }

    fun get(name: String) = pool[name]
}

fun main() {
    val backend = Backend(name = "asdf")
    val front = Frontend(name = "dfgh")

    DeveloperPool.add(backend)
    DeveloperPool.add(front)

    println(DeveloperPool.get("asdf"))
    println(DeveloperPool.get("dfgh"))
}
