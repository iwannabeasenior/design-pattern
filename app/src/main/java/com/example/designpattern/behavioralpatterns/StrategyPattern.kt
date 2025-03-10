package com.example.designpattern.behavioralpatterns

/*
    @Date: 20/02/2025
    @Written by: Nguyen Trung Thanh
*/

/*
The Strategy Pattern is used when we want to define a family of algorithms (or behaviors)
and make them interchangeable at runtime without modifying existing code.
*/

/*
Imagine you're at a restaurant, and after finishing your meal, you decide to pay. The restaurant allows multiple payment methods:
    - Cash
    - Credit Card
    - Mobile Payment (Google Pay / Apple Pay)
Instead of hardcoding payment logic with multiple if-else conditions, we can use the Strategy Pattern to make it flexible and easy to extend.
*/

// Example
interface PaymentStrategy {
    fun payment(amount: Double)
}

class CashPayment: PaymentStrategy {
    override fun payment(amount: Double) {
        println("Paid $amount using cash.")
    }
}
class CreditCardPayment(private val cardNumber: String): PaymentStrategy {
    override fun payment(amount: Double) {
        println("Paid $amount using credit card(Card: $cardNumber).")
    }
}

class MobilePayment(private val phoneNumber: String): PaymentStrategy {
    override fun payment(amount: Double) {
        println("Paid $amount using Mobile Payment (Phone: $phoneNumber).")
    }
}

class PaymentContext(private var paymentStrategy: PaymentStrategy) {
    fun setPaymentStrategy(paymentStrategy: PaymentStrategy) {
        this.paymentStrategy = paymentStrategy
    }
    // execute the strategy
    fun checkout(amount: Double) {
        paymentStrategy.payment(amount)
    }
}
fun main() {

    val paymentContext = PaymentContext(CashPayment())

    paymentContext.checkout(100.0)

    paymentContext.setPaymentStrategy(MobilePayment("0896617286"))
    paymentContext.checkout(50.0)

    paymentContext.setPaymentStrategy(CreditCardPayment("123456789"))
    paymentContext.checkout(25.0)
}
/*
    ✅ Removes complex if-else logic and makes code cleaner.
    ✅ Open-Closed Principle: Easily add new payment methods without modifying existing code.
    ✅ Runtime Flexibility: Users can switch payment methods dynamically.
*/