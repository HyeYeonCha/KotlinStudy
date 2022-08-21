package com.example.kotlinstudy

enum class PaymentStatus(val label:String) {
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

    abstract fun isPayable(): Boolean
}


fun main() {
    if (PaymentStatus.UNPAID.isPayable()) {
        println("결제 가능함")
    }
}
