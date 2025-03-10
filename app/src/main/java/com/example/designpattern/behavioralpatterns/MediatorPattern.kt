package com.example.designpattern.behavioralpatterns

/*
    @Date: 21/02/2025
    @Written by: Nguyen Trung Thanh
*/
/*
    The Mediator Pattern is a behavioral design pattern that reduces direct dependencies between objects by introducing a mediator object that handles communication between them.
    Instead of objects communicating directly with each other, they go through the mediator.
*/

/*
    When to Use the Mediator Pattern?
    ✅ When multiple objects need to communicate without being tightly coupled
    ✅ When communication logic should be centralized in one place
    ✅ When adding new components shouldn’t require modifying existing ones
    ✅ When designing chat apps, UI components (e.g., button interactions), or workflow systems
*/

// Problem
class User(val name: String) {
    fun sendMessage(receiver: User, message: String) {
        println("$name to ${receiver.name}: $message")
    }
}

fun main() {
    val user1 = User("Alice")
    val user2 = User("Bob")
    val user3 = User("Charlie")

    user1.sendMessage(user2, "Hello Bob!")
    user2.sendMessage(user3, "Hi Charlie!")
}

// Solution

interface ChatMediator {
    fun sendMessage(sender: UserMediator, message: String)
}

class ChatRoom : ChatMediator {
    private val users = mutableListOf<UserMediator>()

    fun addUser(user: UserMediator) {
        users.add(user)
    }

    override fun sendMessage(sender: UserMediator, message: String) {
        for (user in users) {
            if (user != sender) {
                user.receiveMessage(sender.name, message)
            }
        }
    }
}

class UserMediator(val name: String, private val mediator: ChatMediator) {
    fun receiveMessage(senderName: String, message: String) {
        println("$name received from $senderName: $ with message: $message")
    }
    fun sendMessage(msg: String) {
        mediator.sendMessage(this, msg)
    }
}