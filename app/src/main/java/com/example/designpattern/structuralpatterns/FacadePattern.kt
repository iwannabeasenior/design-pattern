package com.example.designpattern.structuralpatterns

/*
    @Date: 18/02/2025
    @Written by: Nguyen Trung Thanh
*/

/*
Facade Pattern là một mẫu thiết kế thuộc nhóm Cấu trúc (Structural Pattern). Nó cung cấp một giao diện đơn giản để ẩn đi sự phức tạp của một hệ thống.
    📌 Khi nào sử dụng?
    Khi bạn có một hệ thống phức tạp với nhiều lớp và phương thức.
    Khi bạn muốn cung cấp một điểm truy cập duy nhất để dễ sử dụng hơn.
*/

// Example
class FacadeAudioPlayer {
    fun loadAudio(file: String) {
        println("Loading audio file: $file")
    }

    fun playdAudio() {
        println("Playing audio...")
    }
}
class FacadeVideoPlayer {
    fun loadVideo(file: String) {
        println("Loading video file: $file")
    }

    fun playVideo() {
        println("Playing video...")
    }
}
class FacadeEqualizer {
    fun setBassLevel(level: Int) {
        println("Setting bass level to: $level")
    }
}


class MediaFacade {
    private val audioPlayer = FacadeAudioPlayer()
    private val videoPlayer = FacadeVideoPlayer()
    private val equalizer = FacadeEqualizer()
    fun playMusic(file: String) {
        audioPlayer.loadAudio(file)
        equalizer.setBassLevel(5)
        audioPlayer.playdAudio()
    }

    fun playVideo(file: String) {
        videoPlayer.loadVideo(file)
        videoPlayer.playVideo()
    }
}

fun main() {
    val mediaFacade = MediaFacade()
    mediaFacade.playMusic("music.mp3")
    mediaFacade.playVideo("movie.mp4")
}
