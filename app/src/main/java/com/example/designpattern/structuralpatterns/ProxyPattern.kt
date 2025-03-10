package com.example.designpattern.structuralpatterns


/*
    @Date: 18/02/2025
    @Written by: Nguyen Trung Thanh
*/

/*
Proxy Pattern là một mẫu thiết kế thuộc nhóm Cấu trúc (Structural Pattern).
Mẫu thiết kế này cung cấp một đối tượng thay thế (proxy) cho một đối tượng thật, cho phép kiểm soát việc truy cập vào đối tượng thật.
Proxy có thể thực hiện các nhiệm vụ như kiểm tra quyền truy cập, quản lý tài nguyên, hoặc trì hoãn việc khởi tạo của đối tượng thật cho đến khi cần thiết.

📌 Khi nào sử dụng Proxy Pattern?

    Khi bạn cần kiểm soát quyền truy cập vào đối tượng.
    Khi bạn muốn thực hiện lazily load (trì hoãn khởi tạo) đối tượng.
    Khi bạn muốn giám sát hoặc gia tăng hành vi của đối tượng, như cache, logging.

*/

// Example
interface Subject {
    fun request()
}
class RealSubject: Subject {
    override fun request() {
        println("Real Subject: Handling request")
    }
}
class Proxy(private val realSubject: RealSubject) : Subject {
    override fun request() {
        println("Proxy: Checking access before delegating request to RealSubject")
        realSubject.request()
    }
}

// Example 2: Lazy Loading
interface Data {
    fun fetchData(): String
}
class RealData : Data {
    override fun fetchData(): String {
        println("Fetching data from API...")
        return "Data from API"
    }
}
class DataProxy(private val realData: RealData?) : Data {
    private var cachedData: String? = null

    override fun fetchData(): String {
        // Lazy loading (chỉ tải dữ liệu khi cần)
        if (cachedData == null) {
            cachedData = realData?.fetchData()
        }
        return cachedData ?: "No data available"
    }
}

