package com.example.designpattern.behavioralpatterns

/*
    @Date: 20/02/2025
    @Written by: Nguyen Trung Thanh
*/

// Example
class NewPublisher {
    private val observers = mutableListOf<Observer>()
    private var lastestNews: String = ""

    fun addObserver(observer: Observer) {
        observers.add(observer)
    }
    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }
    fun setNews(news: String) {
        lastestNews = news
        notifyObservers()
    }
    fun notifyObservers() {
        for (observer in observers) {
            observer.update()
        }
    }
}

interface Observer {
    fun update()
}
class NewReaders: Observer {
    override fun update() {
        println("System notify that data has changed")
    }

}

fun main() {
    val observer = NewReaders()
    val newPublisher = NewPublisher()
    newPublisher.addObserver(observer)
    newPublisher.setNews("Where are you from")
}
