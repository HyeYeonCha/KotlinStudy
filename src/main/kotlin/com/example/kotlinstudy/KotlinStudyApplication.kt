package com.example.kotlinstudy

enum class PaymentStatus(val label:String): Payable{
    UNPAID("미지급") {
        override fun isPayable() = true
    },
    PAID("지급완료") {
        override fun isPayable(): Boolean {
            return false
        }
    },
    FAILED("지급실패") {
        override fun isPayable(): Boolean {
            return false
        }
    },
    REFUNDED("환불") {
        override fun isPayable(): Boolean {
            return false
        }
    };

}

interface Payable {
    fun isPayable(): Boolean
}

fun main() {
//    if (PaymentStatus.UNPAID.isPayable()) {
//        println("결제 가능함")
//    }

    // valueOf enum Class 의 상수와 일치하는 값을 찾아서 바로 인스턴스화 시켜줌
    val paymentStatus = PaymentStatus.valueOf("PAID")
    println(paymentStatus.label)

    if (paymentStatus == PaymentStatus.PAID) {
        println("결제 완료임")
    }

    // enum class 내부 순차 출력하기
    for (status in PaymentStatus.values()) {
        println("${status.name}: ${status.label} -> ${status.ordinal}")
    }
}
