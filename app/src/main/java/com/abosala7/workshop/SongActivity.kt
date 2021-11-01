package com.abosala7.workshop

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import com.abosala7.workshop.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySongBinding
    private var player: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        player = MediaPlayer.create(this, R.raw.humaza)
        binding.seekBar.max = player!!.duration
        binding.play.setOnClickListener{
            if(player == null){
                player = MediaPlayer.create(this, R.raw.humaza)
                player?.start()
            }else if(!player!!.isPlaying){
                player?.start()
            }
        }
        binding.stop.setOnClickListener{
            player?.release()
            player = null
        }
        binding.pause.setOnClickListener{
            if(player!= null && player!!.isPlaying)
                player?.pause()
        }
        player?.setOnCompletionListener {
            player?.release()
            player = null
        }
        binding.seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                player?.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

    }


    override fun onPause() {
        super.onPause()
        player?.release()
    }
}