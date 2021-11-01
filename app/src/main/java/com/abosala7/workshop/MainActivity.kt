package com.abosala7.workshop

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abosala7.workshop.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.webText.setOnClickListener{
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("site","http://www.facebook.com")
            startActivity(intent)
        }
        binding.songText.setOnClickListener{
            val intent = Intent(this, SongActivity::class.java)
            startActivity(intent)
        }
        binding.videoText.setOnClickListener{
            val intent = Intent(this, VideoActivity::class.java)
            intent.putExtra("site", "https://www.youtube.com/watch?v=t1dFbQiIyAs")
            startActivity(intent)
        }
    }


}