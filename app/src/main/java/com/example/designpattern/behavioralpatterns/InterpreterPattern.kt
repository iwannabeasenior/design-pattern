package com.example.designpattern.behavioralpatterns

import kotlin.math.exp

/*
   @Date: 21/02/2025
   @Written by: Nguyen Trung Thanh
*/

/*
    📌 Khi nào nên dùng?
    ✅ Khi cần xử lý biểu thức toán học hoặc ngôn ngữ đơn giản.
    ✅ Khi có ngữ pháp nhỏ, dễ quản lý.
    ✅ Khi cần mở rộng cú pháp dễ dàng.
*/  

// Build Small Computer

interface Expression {
    fun interpreter(): Int
}

class Number(private val value: Int): Expression {
    override fun interpreter() : Int{
        return value
    }
}

class Add(private val a: Expression, private val b: Expression): Expression {
    override fun interpreter(): Int {
        return a.interpreter() + b.interpreter()
    }
}
class Subtract(private val a: Expression, private val b: Expression): Expression {
    override fun interpreter(): Int {
        return a.interpreter() - b.interpreter()
    }
}

class Multiple(private val a: Expression, private val b: Expression): Expression {
    override fun interpreter(): Int {
        return a.interpreter() * b.interpreter()
    }
}

class Divider(private val a: Expression, private val b: Expression): Expression {
    override fun interpreter(): Int {
        return a.interpreter() / b.interpreter()
    }
}
fun main() {
    val expression: Expression = Subtract(
        Add(Number(2), Number(3)), Multiple(Number(1), Number(2))
    )
    println(expression.interpreter())
}