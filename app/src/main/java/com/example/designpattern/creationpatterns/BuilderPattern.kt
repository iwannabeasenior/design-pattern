package com.example.designpattern.creationpatterns
/*
    @Created: 16/02/2025
    @Written by: NguyenTrungThanh
*/

/*
    The Builder Pattern is used to construct complex objects step by step instead of using long constructors with many parameters.
    It’s especially useful when an object has many optional parameters.

    @When to use Builder Pattern:
        - When a class has many optional parameters
        - When constructors with many parameters become hard to read
        - When you want immutable objects
*/

// Option 1
private class User private constructor (
    val name: String,
    val age: Int,
    val email: String?,
    val phone: String?
) {
    class Builder {
        private var name: String = ""
        private var age: Int = 0
        private var email: String? = null
        private var phone: String? = null

        fun setName(name: String) = apply { this.name = name }
        fun setAge(age: Int) = apply { this.age = age }
        fun setEmail(email: String?) = apply { this.email = email }
        fun setPhone(phone: String?) = apply { this.phone = phone }

        fun build() = User(name, age, email, phone)
    }
}
// Option 2
private class Car1(
    val model: String?,
    val year: Int
) {
    private constructor(builder: Builder): this(builder.model, builder.year)
    companion object {
        inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }
    class Builder {
        var model: String? = null
        var year: Int = 0
        fun build() = Car1(this)
    }
}

// Option 3: Use named constructor

private fun main() {
    val user = User.Builder()
        .setName("Thanh")
        .setAge(21)
        .setEmail("thanhdepzai37@gmail.com")
        .setPhone("0896617286")
        .build()
    Car1.build {
        model = "X"
    }
}

