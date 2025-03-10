package com.example.designpattern.structuralpatterns

/*
    @Date: 18/02/2025
    @Written by: Nguyen Trung Thanh
*/

/*
Bridge Pattern là một mẫu thiết kế thuộc nhóm Cấu trúc (Structural Pattern).
Nó giúp tách biệt phần trừu tượng (Abstraction) và phần triển khai (Implementation) để cả hai có thể phát triển độc lập.

    📌 Khi nào nên sử dụng Bridge Pattern?

    Khi cần giảm sự phụ thuộc giữa phần giao diện (abstraction) và phần triển khai (implementation).
    Khi cần hỗ trợ nhiều biến thể của một lớp mà không làm tăng độ phức tạp của hệ thống.
*/

// Example

interface Color {
    fun applyColor(): String
}

class Red: Color {
    override fun applyColor(): String = "Red"
}

class Blue: Color {
    override fun applyColor(): String = "Blue"
}

abstract class Shape(protected val color: Color) {
    abstract fun draw(): String
}

class Circle(color: Color): Shape(color) {
    override fun draw(): String = "Drawing Circle in ${color.applyColor()}"
}

class Square(color: Color): Shape(color) {
    override fun draw(): String = "Drawing Square in ${color.applyColor()}"
}

fun main() {
    val redCircle = Circle(Red())
    val blueSquare = Square(Blue())
    println(redCircle.draw())
    println(blueSquare.draw())
}