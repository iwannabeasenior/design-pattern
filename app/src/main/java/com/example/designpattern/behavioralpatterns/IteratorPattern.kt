package com.example.designpattern.behavioralpatterns

/*
   @Date: 21/02/2025
   @Written by: Nguyen Trung Thanh
*/

/*
1. Vấn Đề Gặp Phải
Khi làm việc với danh sách, tập hợp dữ liệu, bạn cần duyệt qua các phần tử mà không cần biết chi tiết triển khai bên trong.
   Ví dụ:

    Duyệt qua một danh sách đối tượng trong RecyclerView.
    Xử lý cây thư mục theo từng phần tử.
    Lấy từng phần tử từ Collection (List, Set, Map) mà không lộ chi tiết cấu trúc.
    Cách duyệt truyền thống (for hoặc while) có thể gây vi phạm nguyên tắc đóng gói (Encapsulation) nếu chúng ta phải truy cập trực tiếp vào danh sách.

   Iterator Pattern giúp:
    ✅ Duyệt qua các phần tử mà không cần biết cấu trúc bên trong.
    ✅ Hỗ trợ nhiều kiểu dữ liệu khác nhau (List, Set, Tree...).
    ✅ Tách rời logic duyệt ra khỏi cấu trúc dữ liệu, giúp dễ mở rộng.
*/
/*
 Ứng Dụng Thực Tế
    - RecyclerView Adapter (Duyệt qua danh sách item).
    - Database Cursor (Duyệt dữ liệu từ SQLite).
    - Iterator trong Collection (List, Set, Map).
 */
interface Iterator<T> {
    fun hasNext(): Boolean
    fun next(): T
}

data class Book(val title: String)

class BookIterator(private val books: List<Book>) : Iterator<Book> {
    private var index = 0
    override fun hasNext(): Boolean {
        return index < books.size
    }

    override fun next(): Book {
        return books[index++]
    }
}

class BookCollection(private val books: List<Book>) {
    fun iterator(): Iterator<Book> {
        return BookIterator(books)
    }
}


fun main() {
    val books = listOf(
        Book("Design Patterns"),
        Book("Clean Code"),
        Book("Refactoring")
    )
    val bookCollection = BookCollection(books)
    val iterator = bookCollection.iterator()
    while(iterator.hasNext()) {
        println("Doc sach: ${iterator.next().title}")
    }
}