package com.abosala7.workshop

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abosala7.workshop.databinding.ActivityMainBinding
import com.abosala7.workshop.databinding.ActivityWebViewBinding
import android.webkit.WebView
import android.webkit.WebViewClient






class WebViewActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWebViewBinding
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.webView.loadUrl(intent.getStringExtra("site")!!)
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webViewClient = MyWebViewClient()
    }
    class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }
}