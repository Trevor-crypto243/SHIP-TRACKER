package com.example.maps2

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
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.maps2.R
import java.io.InputStream

class MapsActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var spinner: Spinner
    private lateinit var locationManager: LocationManager
    private lateinit var locationListener: LocationListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity4)
        supportActionBar?.hide()

//        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//
//        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//            val settingsIntent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
//            startActivity(settingsIntent)
//        }
//
//        locationListener = object : LocationListener {
//            override fun onLocationChanged(location: Location) {
//                val latitude = location.latitude
//                val longitude = location.longitude
//                Toast.makeText(applicationContext, "lat: $latitude, long: $longitude", Toast.LENGTH_LONG).show()
//            }
//
//            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
//            override fun onProviderEnabled(provider: String) {}
//            override fun onProviderDisabled(provider: String) {}
//        }

        webView = findViewById(R.id.webView)
        spinner = findViewById(R.id.spinner)

        val websites = resources.getStringArray(R.array.ship_array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, websites)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Spinner selection listener
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedWebsite = parent?.getItemAtPosition(position).toString()
                val myVariable = "Hello from Kotlin!"

                loadWebsite("kotlinVariable", myVariable,position)

//                if(position == 0){
//                    loadWebsite("<html><body><h1>View 1, HTML!</h1></body></html>")
//                }else if(position == 1){
//                    loadWebsite("<html><body><h1>View 2, HTML!</h1></body></html>")
//                }else if(position == 2){
//                    loadWebsite("<html><body><h1>View 3, HTML!</h1></body></html>")
//                }
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
            if(offset == 0){
                loadDataWithBaseURL(null, htmlContent1, "text/html", "UTF-8", null)
            }else if(offset == 1){
                loadDataWithBaseURL(null, htmlContent2, "text/html", "UTF-8", null)
            }else if(offset == 2){
                loadDataWithBaseURL(null, htmlContent3, "text/html", "UTF-8", null)
            }
        }
    }






//    override fun onStart() {
//        super.onStart()
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(
//                    Manifest.permission.ACCESS_FINE_LOCATION,
//                    Manifest.permission.ACCESS_COARSE_LOCATION
//                ),
//                1
//            )
//            return
//        }
//        locationManager.requestLocationUpdates(
//            LocationManager.GPS_PROVIDER,
//            0,
//            0f,
//            locationListener
//        )
//    }

    override fun onStop() {
        super.onStop()
        locationManager.removeUpdates(locationListener)
    }
}
