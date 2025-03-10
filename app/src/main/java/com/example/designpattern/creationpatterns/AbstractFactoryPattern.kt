package com.example.designpattern.creationpatterns

/*
    @Created: 16/02/2025
    @Written by: Nguyen Trung Thanh
*/
/*
    This pattern used for multiple products

    1️⃣ When to Use Abstract Factory?
    ✅ When you need multiple families of related objects.
    ✅ When you want to decouple object creation from implementation.
    ✅ When your app supports different configurations (themes, UI styles, databases, etc.).
*/
interface Engine1 {
    fun type(): String
}

interface Battery {
    fun capacity(): String
}

class ElectricEngine: Engine1 {
    override fun type(): String = "Electric Engine"
}

class LithiumBattery: Battery {
    override fun capacity(): String = "100 kWh"
}

class PetrolEngine: Engine1 {
    override fun type(): String = "Petrol Engine"
}

class LeadAcidBattery: Battery {
    override fun capacity(): String = "12V Lead-Acid"
}

interface CarFactory {
    fun createEngine(): Engine1
    fun createBattery(): Battery
}

class ElectricCarFactory: CarFactory {
    override fun createEngine(): Engine1 = ElectricEngine()

    override fun createBattery(): Battery = LithiumBattery()
}

class PetrolCarFactory: CarFactory {
    override fun createEngine(): Engine1 = PetrolEngine()

    override fun createBattery(): Battery = LeadAcidBattery()
}

// Example 2
interface Button {
    fun render(): String
}
interface CheckBox   {
    fun check(): String
}

class WindowsButton: Button {
    override fun render(): String = "Rendering Windows Button"
}
class MacButton : Button {
    override fun render(): String = "Rendering Mac Button"
}
class WindowCheckBox : CheckBox {
    override fun check(): String = "Checking Windows CheckBox"
}
class MacCheckBox: CheckBox {
    override fun check(): String = "Checking Mac CheckBox"
}

interface GUIFactory {
    fun createButton(): Button
    fun createCheckBox(): CheckBox
}
class WindowsFactory : GUIFactory {
    override fun createButton(): Button {
        return WindowsButton()
    }

    override fun createCheckBox(): CheckBox {
        return WindowCheckBox()
    }

}
class MacFactory: GUIFactory {
    override fun createButton(): Button {
        return MacButton()
    }

    override fun createCheckBox(): CheckBox {
        return MacCheckBox()
    }

}

fun main() {
    val factory : GUIFactory = WindowsFactory()
    val button = factory.createButton()
    val checkbox = factory.createCheckBox()
    println(button.render())
    println(checkbox.check())
}


