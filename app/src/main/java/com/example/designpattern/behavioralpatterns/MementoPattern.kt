package com.example.designpattern.behavioralpatterns

import android.os.Build
import androidx.annotation.RequiresApi

/*
   @Date: 21/02/2025
   @Written by: Nguyen Trung Thanh
*/



/*
  Memento Pattern giúp lưu và khôi phục trạng thái của một đối tượng mà không để lộ chi tiết bên trong của nó.

    Memento: Đối tượng lưu trữ trạng thái.
    Originator: Đối tượng gốc có thể tạo và khôi phục trạng thái.
    Caretaker: Lớp quản lý các trạng thái đã lưu (ví dụ: một danh sách để hỗ trợ Undo/Redo).
*/

/*
    📌 Khi nào nên dùng?
    ✅ Khi bạn cần Undo/Redo.
    ✅ Khi cần lưu trạng thái trước khi thay đổi.
    ✅ Khi muốn bảo vệ trạng thái nội bộ của đối tượng.
*/
class Memento(val state: String)

class TextEditor {
    private var content: String = ""
    fun write(text: String) {
        content += text
    }
    fun printContent() {
        println("Noi dung hien tai la: $content")
    }
    fun save(): Memento {
        return Memento(content)
    }
    fun restore(memento: Memento) {
        content = memento.state
    }
}

class History {
    private val mementos = mutableListOf<Memento>()

    fun save(memento: Memento) {
        mementos.add(memento)
    }
    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    fun undo(): Memento? {
        return if (mementos.isNotEmpty()) mementos.removeLast() else null
    }
}

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
fun main() {
    val textEditor = TextEditor()
    val historyManagement = History()
    // save
    textEditor.write("Hello")
    textEditor.printContent()
    historyManagement.save(textEditor.save())
    textEditor.write("World")
    textEditor.printContent()
    historyManagement.save(textEditor.save())
    textEditor.write("abc")
    textEditor.printContent()
    historyManagement.undo()?.let {
        textEditor.restore(it)
    }
    textEditor.printContent()
}