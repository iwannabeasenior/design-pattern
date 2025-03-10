package com.example.designpattern.structuralpatterns


/*
    @Date: 18/02/2025
    @Written by: Nguyen Trung Thanh
*/

/*
Composite Pattern là một mẫu thiết kế thuộc nhóm Cấu trúc (Structural Pattern). Nó giúp quản lý một cấu trúc cây bằng cách xử lý các đối tượng riêng lẻ và nhóm đối tượng theo cùng một cách.

    📌 Khi nào nên sử dụng Composite Pattern?

    Khi bạn có cấu trúc phân cấp (tree-like structure), ví dụ như Menu, File System, UI Components.
    Khi bạn muốn xử lý cả đối tượng đơn lẻ và nhóm đối tượng theo cùng một cách.
*/


interface FileSystemComponent {
    fun showDetails()
}


class File(private val name: String): FileSystemComponent {
    override fun showDetails() {
        println("File: $name")
    }
}
class Folder(private val name: String): FileSystemComponent {
    private val children = mutableListOf<FileSystemComponent>()

    override fun showDetails() {
        for (child in children) {
            child.showDetails()
        }
    }
    fun add(component: FileSystemComponent) {
        children.add(component)
    }
}

fun main() {
    val file1 = File("file1.png")
    val file2 = File("file2.png")
    val file3 = File("file3.png")

    val folder1 = Folder("My Files")
    folder1.add(file1)
    folder1.add(file2)

    val folder2 = Folder("Media")
    folder2.add(file3)

    val rootFolder = Folder("Root")
    rootFolder.add(folder1)
    rootFolder.add(folder2)

    rootFolder.showDetails()
}