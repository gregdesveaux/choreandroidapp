package com.example.choreandroidapp

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.choreandroidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupWebView(binding.choreWebView)
        loadUrlFromIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        loadUrlFromIntent(intent)
    }

    private fun setupWebView(webView: WebView) {
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
    }

    private fun loadUrlFromIntent(intent: Intent) {
        val url = intent.getStringExtra(EXTRA_CHORE_URL) ?: DEFAULT_CHORE_URL
        binding.choreWebView.loadUrl(url)
    }

    companion object {
        const val EXTRA_CHORE_URL = "extra_chore_url"
        const val DEFAULT_CHORE_URL = "https://example.com/chore"
    }
}
