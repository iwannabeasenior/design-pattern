package com.example.designpattern.behavioralpatterns

/*
    @Date: 21/02/2025
    @Written by: Nguyen Trung Thanh
*/

/*
The Template Method Pattern is a behavioral design pattern that defines the structure of an algorithm in a base class and allows subclasses to provide specific implementations for some steps.
This promotes code reusability and enforces a sequence of operations.
*/

// Example

abstract class ReportGenerator {

    fun generatorReport() {
        collectData()
        processData()
        formatReport()
        saveReport()
    }

    private fun collectData() {
        println("Collecting data for the report...")
    }

    abstract fun processData()

    abstract fun formatReport()

    private fun saveReport() {
        println("Saving report...")
    }

}

class PDFReport : ReportGenerator() {
    override fun processData() {
        println("Processing data for PDF format...")
    }

    override fun formatReport() {
        println("Formatting report for PDF...")
    }
}

class CSVReport: ReportGenerator() {
    override fun processData() {
        println("Processing data for CSV format...")
    }

    override fun formatReport() {
        println("Formatting report for CSV...")
    }
}