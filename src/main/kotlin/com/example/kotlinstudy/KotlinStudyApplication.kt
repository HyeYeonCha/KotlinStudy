package com.example.kotlinstudy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinStudyApplication

class Product(val name: String, val price: Int)

// 상위 위에 또 다른 상위 interface
interface Wheel {
    fun roll()
}
interface Cart: Wheel {
    var coin: Int
    val weight : String
      get() = "200KG"
    fun add(product: Product)

    fun rent() {
        if (coin >= 0) {
            println("카드 대여")
        }
    }

    override fun roll() {
        println("카드가 데굴데굴")
    }

    fun printId() = println("123456")

}

interface Order {
    fun add(product: Product) {
        println("${product.name} 가 주문 완료")
    }

    fun printId() = println("123123")
}
// interface 두 개 추가
class MyCart(override var coin: Int) : Cart, Order {

    override fun add(product: Product) {
        if (coin >= 0) {
            println("${product.name} 이 추가되었습니다.")
        }else {
            println("코인이 부족합니다.")
        }

        // Order 의 add 호출
        super<Order>.add(product)
    }

    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }
}


fun main(args: Array<String>) {
//    runApplication<KotlinStudyApplication>(*args)
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.roll()
    cart.add(Product(name = "츄파춥스", price = 100))

    cart.printId()
}
