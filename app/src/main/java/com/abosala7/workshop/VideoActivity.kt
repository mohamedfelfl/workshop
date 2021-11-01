package com.abosala7.workshop

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abosala7.workshop.databinding.ActivitySongBinding
import com.abosala7.workshop.databinding.ActivityVideoBinding

class VideoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.videoView.setVideoURI(Uri.parse(intent.getStringExtra("site")!!))

    }
}