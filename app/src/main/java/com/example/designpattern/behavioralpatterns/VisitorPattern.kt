package com.example.designpattern.behavioralpatterns

import kotlin.math.pow

/*
    @Date: 21/02/2025
    @Written by: Nguyen Trung Thanh
*/

/*
    The Visitor Pattern is a behavioral design pattern that allows you to add further operations to objects without modifying their structures.
    It is particularly useful when working with complex object hierarchies.

    When to Use the Visitor Pattern?
        - When you need to perform multiple operations on an object structure without modifying the classes.
        - When new operations need to be added frequently but the object structure should remain unchanged.
        - When you want to separate algorithms from the data structures they operate on.
    📌 Khi nào nên dùng?
    ✅ Khi bạn cần thêm nhiều hành vi mà không muốn sửa đổi các lớp cũ.
    ✅ Khi có nhiều kiểu đối tượng nhưng hành vi giống nhau (vd: nhiều loại hình học cần tính diện tích).
    ✅ Khi cần duy trì nguyên tắc mở-đóng (Open/Closed Principle).

    Key Concepts:
        - Visitor: Defines operations to be performed on elements of the object structure.
        - Element: Objects that accept a visitor.
        - ConcreteVisitor: Implements specific operations for the visitor.
        - ConcreteElement: Specific object that accepts a visitor.

*/

/*
    🔥 Ví dụ thực tế:

    Android View Hierarchy: Duyệt cây View và thực hiện hành động (vd: đo kích thước, vẽ).
    Trình biên dịch (Compiler): Duyệt AST (Abstract Syntax Tree) và thực hiện kiểm tra lỗi, tối ưu mã.
    Xử lý file (XML, JSON): Duyệt cấu trúc dữ liệu và thực hiện các thao tác khác nhau trên mỗi phần tử.
*/


// Example
interface Visitor {
    fun visitRectangle(rectangle: Rectangle)
    fun visitCircle(circle: Circle)
}

interface Shape {
    fun accept(visitor: Visitor)
}

class Rectangle(val width: Double, val height: Double) : Shape {
    override fun accept(visitor: Visitor) {
        visitor.visitRectangle(this)
    }
}

class Circle(val radius: Double): Shape {
    override fun accept(visitor: Visitor) {
        visitor.visitCircle(this)
    }
}

class AreaCalculator: Visitor {
    override fun visitRectangle(rectangle: Rectangle) {
        val area = rectangle.height * rectangle.height
        println("Rectangle area is: $area")
    }

    override fun visitCircle(circle: Circle) {
        val area = Math.PI * circle.radius.pow(2.0)
        println("Circle area is: $area")
    }
}


class ShapeDrawer : Visitor {
    override fun visitRectangle(rectangle: Rectangle) {
        println("Vẽ Hình Chữ Nhật có kích thước ${rectangle.width}x${rectangle.height}")
    }

    override fun visitCircle(circle: Circle) {
        println("Vẽ Hình Tròn với bán kính ${circle.radius}")
    }
}

fun main() {
    val shapes = mutableListOf(
        Circle(2.0), Rectangle(1.0, 2.0)
    )
    val areaCalculator = AreaCalculator()
    val shapeDrawer = ShapeDrawer()
    for (shape in shapes) {
        shape.accept(shapeDrawer)
    }
    for (shape in shapes) {
        shape.accept(areaCalculator)
    }
}