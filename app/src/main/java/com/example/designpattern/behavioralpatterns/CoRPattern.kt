package com.example.designpattern.behavioralpatterns

import java.util.logging.Logger

/*
    @Date: 21/02/2025
    @Written by: Nguyen Trung Thanh
*/

/*
The Chain of Responsibility pattern is a behavioral design pattern used to pass a request along a chain of handlers until one of them processes it.
This promotes loose coupling between senders and receivers of requests.
*/

abstract class LoggerHandler(val next: LoggerHandler?) {
    abstract fun log(level: Int, message: String)
}
object LogLevel {
    const val INFO = 1
    const val DEBUG = 2
    const val ERROR = 3
}
class InfoLogger(next: LoggerHandler?): LoggerHandler(next) {
    override fun log(level: Int, message: String) {
        if (level == LogLevel.INFO) {
            println("INFO: $message")
        } else {
            next?.log(level, message)
        }
    }
}

class DebugLogger(next: LoggerHandler?): LoggerHandler(next) {
    override fun log(level: Int, message: String) {
        if (level == LogLevel.DEBUG) {
            println("DEBUG: $message")
        } else {
            next?.log(level, message)
        }
    }
}
class ErrorLogger(next: LoggerHandler?): LoggerHandler(next) {
    override fun log(level: Int, message: String) {
        if (level == LogLevel.ERROR) {
            println("ERROR: $message")
        } else {
            next?.log(level, message)
        }
    }
}

fun main() {
    val loggerChain = InfoLogger(DebugLogger(ErrorLogger(null)))

    loggerChain.log(LogLevel.INFO, "This is an info log.")
    loggerChain.log(LogLevel.DEBUG, "This is a debug log.")
    loggerChain.log(LogLevel.ERROR, "This is an error log.")
}