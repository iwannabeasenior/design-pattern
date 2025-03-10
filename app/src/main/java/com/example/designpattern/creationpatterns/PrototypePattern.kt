package com.example.designpattern.creationpatterns

/*
    @Created: 16/02/2025
    @Written by: Nguyen Trung Thanh
*/

/*
    1️⃣ When to Use the Prototype Pattern?
        ✔ When object creation is costly or complex. (like don't need to call init block again)
        ✔ When an object has many configurations and copying is easier.
        ✔ When you need cloning instead of creating a new instance.
*/

/*

*/

interface Prototype {
    fun clone(): Prototype
}
private class Engine(
    var type: Int
)
private data class Car(
    val brand: String,
    val model: String,
    val color: String,
    val engine: Engine
) : Prototype {
    override fun clone(): Prototype {
        return copy()
    }
}

fun main() {
    val car1 = Car("", "", "", Engine(0))
    val car2 = car1.copy()
    car2.engine.type = 2
    println(car1.engine.type)
    println(car2.engine.type)
}