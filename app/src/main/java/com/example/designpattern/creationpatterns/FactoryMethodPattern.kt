package com.example.designpattern.creationpatterns

/*
    16/02/2025
    Written by: Nguyen Trung Thanh
*/

/*
 This pattern used for single product
 Why use Factory?

    Prevents direct object creation (new AndroidButton()).
    Centralizes object creation logic in ButtonFactory.
    Easy to add new button types without modifying existing code.
*/


// Step 1: Define Product Interface
interface DatabaseConnection {
    fun connect(): String
}

// Step 2: Concrete Implementations
class MySQLConnection : DatabaseConnection {
    override fun connect() = "Connected to MySQL Database"
}

class PostgreSQLConnection : DatabaseConnection {
    override fun connect() = "Connected to PostgreSQL Database"
}

// Step 3: Factory Method in Abstract Class
abstract class DatabaseFactory {
    abstract fun createConnection(): DatabaseConnection  // Factory Method

    fun connectToDatabase(): String {
        val connection = createConnection()
        return connection.connect()
    }
}

// Step 4: Concrete Factories
class MySQLFactory : DatabaseFactory() {
    override fun createConnection(): DatabaseConnection = MySQLConnection()
}

class PostgreSQLFactory : DatabaseFactory() {
    override fun createConnection(): DatabaseConnection = PostgreSQLConnection()
}

// Step 5: Usage
fun main() {
    val factory: DatabaseFactory = MySQLFactory() // Could be PostgreSQLFactory()
    println(factory.connectToDatabase())
    // Output: Connected to MySQL Database
}
