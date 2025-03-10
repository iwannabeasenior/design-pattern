package com.example.designpattern.behavioralpatterns


/*
    @Date: 20/02/2025
    @Written by: Nguyen Trung Thanh
*/

/*
The Command Pattern is a behavioral design pattern that turns a request into an object.
This lets you parameterize methods with different requests, delay execution, and queue commands.
*/


// Example 1
interface Command {
    fun execute()
}

class LightOnCommand(private val light: Light): Command {
    override fun execute() {
        light.turnOn()
    }
}

class LightOffCommand(private val light: Light): Command {
    override fun execute() {
        light.turnOff()
    }
}

class Light {
    fun turnOn() {}
    fun turnOff() {}
}
class Fan {
    fun turnOn() {}
    fun turnOff() {}
}

class FanOnCommand(private val fan: Fan) : Command{
    override fun execute() {
        fan.turnOn()
    }
}
class FanOffCommand(private val fan: Fan) : Command{
    override fun execute() {
        fan.turnOff()
    }
}

class RemoteControlWithUndo {
    private var command: Command? = null
        set(value) {
            field = command
        }
    private var lastCommand: Command? = null

    fun pressButton() {
        command?.execute()
        lastCommand = command
    }
    fun pressUndo() {
        lastCommand?.execute()
    }
}

// Example 2
interface FoodOrder {
    fun execute()
}
class Chef {
    fun prepareDish(dish: String) {
        println("Chef is preparing: $dish")
    }
}
class MealOrder(private val chef: Chef, private val dish: String): FoodOrder {
    override fun execute() {
        chef.prepareDish(dish)
    }
    fun getDishName(): String {
        return dish
    }
}

class Waiter {
    private val orderQueue = mutableListOf<FoodOrder>()
    fun takeOrder(order: FoodOrder) {
        println("Waiter writes down order: ${(order as MealOrder).getDishName()}")
        orderQueue.add(order)
    }
    fun serveOrders() {
        println("Serving orders...")
        orderQueue.forEach { it.execute() }
        orderQueue.clear()
    }
}
fun main() {
    val chef = Chef()
    val waiter = Waiter()
    waiter.takeOrder(MealOrder(chef, "Dish1"))
    waiter.takeOrder(MealOrder(chef, "Dish2"))
    waiter.takeOrder(MealOrder(chef, "Dish3"))
    waiter.serveOrders()
}



