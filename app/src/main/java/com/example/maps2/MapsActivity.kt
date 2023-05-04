package com.example.maps2

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.View.INVISIBLE
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.maps2.R
import java.io.InputStream

class MapsActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var spinner: Spinner
    private lateinit var progress_bar: ProgressBar
    private lateinit var locationManager: LocationManager
    private lateinit var locationListener: LocationListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity4)
        supportActionBar?.hide()

        webView = findViewById(R.id.webView)
        spinner = findViewById(R.id.spinner)
        progress_bar = findViewById(R.id.progressBar)

        val websites = resources.getStringArray(R.array.ship_array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, websites)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Spinner selection listener
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedWebsite = parent?.getItemAtPosition(position).toString()

                //get the gps location, use it as te center
                //also consider the ships location
                val myVariable = "Hello from Kotlin!"
                loadWebsite("kotlinVariable", myVariable,position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle nothing selected
            }
        }
    }

    private fun loadWebsite(variableName: String, variableValue: String, offset: Int) {
        val inputStream1: InputStream = assets.open("all ships.html")
        val htmlContent1 = inputStream1.bufferedReader().use { it.readText() }

        val inputStream2: InputStream = assets.open("fleet.html")
        val htmlContent2 = inputStream2.bufferedReader().use { it.readText() }

        val inputStream3: InputStream = assets.open("single_ship.html")
        val htmlContent3 = inputStream3.bufferedReader().use { it.readText() }

        webView.apply {
            webViewClient = object : WebViewClient() {
                private var hasLoaded = false

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    if (!hasLoaded) {
                        hasLoaded = true
                        // Hide the progress bar or perform any other necessary actions
                        progress_bar.visibility = View.INVISIBLE
                    }
                }

                override fun onReceivedError(
                    view: WebView?,
                    errorCode: Int,
                    description: String?,
                    failingUrl: String?
                ) {
                    super.onReceivedError(view, errorCode, description, failingUrl)
                    // Handle network error here
                    Toast.makeText(applicationContext,""+errorCode,Toast.LENGTH_LONG).show()
                }

                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    view.loadUrl(url)
                    return true
                }
            }

            settings.apply {
                javaScriptEnabled = true
                allowFileAccessFromFileURLs = true
                allowUniversalAccessFromFileURLs = true
            }

            if (offset == 0) {
                loadDataWithBaseURL(null, htmlContent1, "text/html", "UTF-8", null)
            } else if (offset == 1) {
                loadDataWithBaseURL(null, htmlContent2, "text/html", "UTF-8", null)
            } else if (offset == 2) {
                loadDataWithBaseURL(null, htmlContent3, "text/html", "UTF-8", null)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        locationManager.removeUpdates(locationListener)
    }
}
