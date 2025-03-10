package com.example.designpattern.structuralpatterns
/*
    @Date: 18/02/2025
    @Written by: Nguyen Trung Thanh
*/

/*
📌 Khi nào sử dụng Decorator Pattern?
    Khi bạn muốn mở rộng hành vi của một đối tượng mà không thay đổi nó.
    Khi bạn muốn thêm nhiều chức năng khác nhau mà vẫn giữ được tính linh hoạt và dễ bảo trì.
    Khi bạn muốn tránh kế thừa nhiều lớp con, vì kế thừa có thể làm tăng sự phức tạp.
*/

interface Coffee {
    fun cost(): Double
    fun description(): String
}
class BasicCoffee : Coffee {
    override fun cost() = 5.0
    override fun description() = "Basic Coffee"
}
abstract class CoffeeDecorator(private val coffee: Coffee) : Coffee {
    override fun cost(): Double = coffee.cost()
    override fun description(): String = coffee.description()
}
class MilkDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost(): Double = super.cost() + 2.0
    override fun description(): String = super.description() + ", with Milk"
}
class SugarDecorator(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost(): Double = super.cost() + 1.0
    override fun description(): String = super.description() + ", with Sugar"
}
fun main() {
    val basicCoffee = BasicCoffee()
    println("${basicCoffee.description()} costs ${basicCoffee.cost()}")

    val milkCoffee = MilkDecorator(basicCoffee)
    println("${milkCoffee.description()} costs ${milkCoffee.cost()}")

    val sugarMilkCoffee = SugarDecorator(milkCoffee)
    println("${sugarMilkCoffee.description()} costs ${sugarMilkCoffee.cost()}")
}
