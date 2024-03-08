package com.example.valorantapp

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.valorantapp.databinding.ActivityValorantChroma2Binding


class ValorantChroma : AppCompatActivity() {

    companion object {
        const val TAG = "ValorantChroma"
        val EXTRA_VALO = "valorantSkin"
        val EXTRA_NUMBER = "number"
    }

    private lateinit var binding: ActivityValorantChroma2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValorantChroma2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val weapon = intent.getParcelableExtra<ValorantSkin>(ValorantDetailActivity.EXTRA_VALO)!!

        val number = intent.getIntExtra(ValorantDetailActivity.EXTRA_NUMBER, -1)!!

        Log.d(TAG, "number: $number")
        var chroma = ""

        if (number != 0) {
            chroma = weapon.chromas[number].streamedVideo.toString()
        }
        else {
            chroma = weapon.levels[weapon.levels.size-1].streamedVideo.toString()
        }

        val videoView: VideoView

        videoView = findViewById(R.id.videoView_valorantChroma_chromaVideo)
        val uri = Uri.parse(chroma)

        // sets the resource from the
        // videoUrl to the videoView
        videoView.setVideoURI(uri)

        // creating object of
        // media controller class
        val mediaController = MediaController(this)

        // sets the anchor view
        // anchor view for the videoView
        mediaController.setAnchorView(videoView)

        // sets the media player to the videoView
        mediaController.setMediaPlayer(videoView)

        // sets the media controller to the videoView
        videoView.setMediaController(mediaController)

        // starts the video
        videoView.start()
    }
}