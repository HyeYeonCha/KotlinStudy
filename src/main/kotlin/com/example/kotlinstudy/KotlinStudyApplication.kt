package com.example.kotlinstudy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinStudyApplication

class Product(val name: String, val price: Int)

interface Cart {
    var coin: Int
    val weight : String
      get() = "200KG"
    fun add(product: Product)

    fun rent() {
        if (coin >= 0) {
            println("카드 대여")
        }
    }
}

class MyCart(override var coin: Int) : Cart {

    override fun add(product: Product) {
        if (coin >= 0) {
            println("${product.name} 이 추가되었습니다.")
        }else {
            println("코인이 부족합니다.")
        }
    }
}


fun main(args: Array<String>) {
//    runApplication<KotlinStudyApplication>(*args)
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.add(Product(name = "츄파춥스", price = 100))
}
