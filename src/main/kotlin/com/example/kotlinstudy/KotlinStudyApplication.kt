package com.example.kotlinstudy

abstract class Developer
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

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when(developer) {
        is Backend -> pool[developer.name] = developer
        is Frontend -> pool[developer.name] = developer
        else -> println("nope.")
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
