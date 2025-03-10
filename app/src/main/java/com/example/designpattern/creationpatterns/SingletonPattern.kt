package com.example.designpattern.creationpatterns

/*
    16/02/2025
    Written by: Nguyen Trung Thanh
 */

/*
    Use to create only object
*/

// Option 1
private object SingletonPatternObject {
    private var a = 1
    fun doWork() {
        println("I'm doing something...")
    }
}

// Option 2
private class SingletonPattern private constructor() {
    init {
        println("Singleton Instance Created")
    }
    companion object {
        val instance: SingletonPattern by lazy { SingletonPattern() }
    }
    fun doWork() {
        println("I'm doing something...")
    }
}
interface Printer {
    fun printMessage()
}
class DefaultPrinter: Printer {
    override fun printMessage() = println("Printing from Default Printer")
}

class MyPrinter(printer: Printer) : Printer by printer

fun main() {
    val printer = MyPrinter(DefaultPrinter())
    printer.printMessage()
}