package com.example.designpattern.structuralpatterns

/*
    @Date: 18/02/2025
    @Written by: Nguyen Trung Thanh
*/

/*
Flyweight Pattern trong Kotlin
Flyweight Pattern là một mẫu thiết kế thuộc nhóm Cấu trúc (Structural Pattern).
Mục đích của Flyweight Pattern là giảm thiểu việc tạo ra các đối tượng giống nhau và tối ưu bộ nhớ bằng cách sử dụng các đối tượng chia sẻ.
Mẫu thiết kế này rất hữu ích khi có rất nhiều đối tượng nhỏ, không thay đổi và có thể chung nhau một số trạng thái.

📌 Khi nào sử dụng Flyweight Pattern?

    Khi bạn có một số lượng lớn các đối tượng có trạng thái giống nhau, ví dụ như biểu tượng UI, ký tự văn bản, pixel, hình vẽ.
    Khi bạn muốn tiết kiệm bộ nhớ bằng cách chia sẻ các đối tượng chung.
*/

// Example

interface FlyWeightShape {
    fun draw()
}

class FlyWeightCircleShape(private val color: String) : FlyWeightShape {
    override fun draw() {
        println("Drawing a $color circle")
    }
}

class ShapeFactory {
    private val circleMap = mutableMapOf<String, FlyWeightCircleShape>()
    fun getCircle(color: String): FlyWeightCircleShape {
        if (!circleMap.containsKey(color)) {
            println("Creating a new $color circle")
            circleMap[color] = FlyWeightCircleShape(color)
        }
        return circleMap[color]!!
    }
}
fun main() {
    val shapeFactory = ShapeFactory()

}