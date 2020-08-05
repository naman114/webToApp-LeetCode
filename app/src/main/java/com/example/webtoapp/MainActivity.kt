package com.example.webtoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    private lateinit var  myWebView : WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        myWebView = findViewById(R.id.webView)
        val myWebSettings : WebSettings = myWebView.settings
        myWebSettings.javaScriptEnabled = true

        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        myWebView.loadUrl("https://www.leetcode.com/")
        //manifest: uses permission internet
        Toast.makeText(applicationContext, "Brought to Android by Naman Gogia",Toast.LENGTH_LONG).show()

    }

    override fun onBackPressed() {
        if(myWebView.canGoBack())
            myWebView.goBack()
        else
            super.onBackPressed()
    }
}