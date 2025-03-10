package com.example.designpattern.behavioralpatterns

/*
    @Date: 20/02/2025
    @Written by: Nguyen Trung Thanh
*/


/*
State is a behavioral design pattern that lets an object alter its behavior when its internal state changes.
It appears as if the object changed its class.
*/

/*
    When to Use the State Pattern?
    ✅ When an object’s behavior changes based on its state
    ✅ When you want to remove long if-else or when conditions
    ✅ When you want better code maintainability and flexibility
    ✅ When you need to easily add new states without modifying existing code
*/

interface OrderState {
    fun nextState(order: Order)
    fun previousState(order: Order)
    fun printState()
}
class OrderedState: OrderState {
    override fun nextState(order: Order) {
        order.state = ShippedState()
    }

    override fun previousState(order: Order) {
        println("Order is already in the initial state")
    }

    override fun printState() {
        println("Order placed. Waiting for shipment.")
    }
}

class ShippedState: OrderState {
    override fun nextState(order: Order) {
        order.state = DeliveredState()
    }

    override fun previousState(order: Order) {
        order.state = OrderedState()
    }

    override fun printState() {
        println("Order shipped. On the way to delivery.")
    }

}
class DeliveredState: OrderState {
    override fun nextState(order: Order) {
        println("Order is already delivered. No further state.")
    }

    override fun previousState(order: Order) {
        order.state = ShippedState()
    }

    override fun printState() {
        println("Order delivered to customer.")
    }

}

class Order {
    var state: OrderState = OrderedState()

    fun nextState() {
        state.nextState(this)
    }
    fun previousState() {
        state.previousState(this)
    }
    fun printState() {
        state.printState()
    }
}

fun main() {
    val order = Order()
    order.printState()
    order.nextState()
    order.nextState()
    order.nextState()
}