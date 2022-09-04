package com.example.kotlinstudy

fun getStr(): Nothing = throw Exception("throw new Exception")

fun main() {

//    val result = try {
//        getStr()
//    } catch (e: Exception) {
//        println(e.message)
//        "exception"
//    }

    val result = runCatching { getStr() }.getOrElse {
        println(it.message)
        "exception"
    }
    println(result)

    // 성공인경우 결과값 아닌경우 null
    val result2 = runCatching { getStr() }.getOrNull()
    println(result2)

    // 예외 아니면 null
//    val result3 = runCatching { getStr() }.exceptionOrNull()
//            ?.let {
//                println(it.message)
//                throw it
//            }
//    println(result3)

    // 예외일때 default
    val result4 = runCatching { getStr() }.getOrDefault("default")
    println(result4)

    // 성공할 때 값 가져오고 실패일 때 수신자 객체로서 예외 던짐
    val result5 = runCatching { getStr() }.getOrElse {
        println(it.message)
        "default"
    }
    println(result5)

    // 성공일때는 값 반환 실패는 예외 반환
//    val result6 = runCatching { getStr() }.getOrThrow()

    // 성공일 때 새로운 값으로 바꿔서 반환가능
    val result7 = runCatching { "HI" }.map {
        "$it hi hi"
    }.getOrThrow()

    println(result7)


    // map 내에서 exception 이 나올 수 있을 때
    val result8 = runCatching { "HI" }.mapCatching {
        throw Exception("exception")
    }.getOrDefault("default")
    println(result8)

    // 실패시 값을 바꿔줌
    val result9 = runCatching { getStr() }
            .recover { "recover" }
            .getOrNull()
    println(result9)

    val result9_1 = runCatching { getStr() }
            .recoverCatching { throw Exception("exception") }
            .getOrNull()
    println(result9_1)

}
