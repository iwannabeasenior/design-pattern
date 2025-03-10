package com.example.designpattern.structuralpatterns

import android.provider.MediaStore.Audio.Media

interface MediaPlayer {
    fun play(audioType: String, fileName: String)
}
interface AdvancedMediaPlayer {
    fun playVlc(fileName: String)
    fun playMp4(fileName: String)
}
class VlcPlayer: AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
        TODO("Not yet implemented")
    }

    override fun playMp4(fileName: String) {
        TODO("Not yet implemented")
    }
}
class Mp4Player: AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
        TODO("Not yet implemented")
    }

    override fun playMp4(fileName: String) {
        TODO("Not yet implemented")
    }
}
class MediaAdapter() : MediaPlayer {
    lateinit var advancedMediaPlayer: AdvancedMediaPlayer
    override fun play(audioType: String, fileName: String) {
        if (audioType == "vlc") {
            advancedMediaPlayer.playVlc(fileName)
        } else if (audioType == "mp4") {
            advancedMediaPlayer.playMp4(fileName)
        }
    }
}

class AudioPlayer : MediaPlayer {
    lateinit var mediaAdapter: MediaAdapter
    override fun play(audioType: String, fileName: String) {
        mediaAdapter = MediaAdapter()
        mediaAdapter.play(audioType, fileName)
    }
}

fun main() {
    val audioPlayer = AudioPlayer()
    audioPlayer.play("mp4", "alone.mp4")
}