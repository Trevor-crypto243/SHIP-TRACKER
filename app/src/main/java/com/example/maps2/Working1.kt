//package com.example.maps2
//
//package com.example.maps2
//
//import android.Manifest
//import android.annotation.SuppressLint
//import android.content.Context
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.location.Location
//import android.location.LocationListener
//import android.location.LocationManager
//import android.os.Bundle
//import android.provider.Settings
//import android.view.View
//import android.webkit.WebView
//import android.webkit.WebViewClient
//import android.widget.AdapterView
//import android.widget.ArrayAdapter
//import android.widget.Spinner
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.app.ActivityCompat
//import com.example.maps2.R
//
//class MapsActivity : AppCompatActivity() {
//    private lateinit var webView: WebView
//    private lateinit var spinner: Spinner
//    private lateinit var locationManager: LocationManager
//    private lateinit var locationListener: LocationListener
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity4)
//        supportActionBar?.hide()
//
////        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
////
////        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
////        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
////            val settingsIntent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
////            startActivity(settingsIntent)
////        }
////
////        locationListener = object : LocationListener {
////            override fun onLocationChanged(location: Location) {
////                val latitude = location.latitude
////                val longitude = location.longitude
////                Toast.makeText(applicationContext, "lat: $latitude, long: $longitude", Toast.LENGTH_LONG).show()
////            }
////
////            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
////            override fun onProviderEnabled(provider: String) {}
////            override fun onProviderDisabled(provider: String) {}
////        }
//
//        webView = findViewById(R.id.webView)
//        spinner = findViewById(R.id.spinner)
//
//        val websites = resources.getStringArray(R.array.ship_array)
//        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, websites)
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinner.adapter = adapter
//
//        // Spinner selection listener
//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                val selectedWebsite = parent?.getItemAtPosition(position).toString()
//                if(position == 0){
//                    loadWebsite("itstrevor.vercel.app")
//                }else if(position == 1){
//                    loadWebsite("https://ad-nganya-ke.vercel.app/")
//                }else if(position == 2){
//                    loadWebsite("https://www.linkedin.com/in/trevor-ogina-150937213/")
//                }
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                // Handle nothing selected
//            }
//        }
//    }
//
//    private fun loadWebsite(website: String) {
//        webView.apply {
//            webViewClient = object : WebViewClient() {
//                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
//                    view.loadUrl(url)
//                    return true
//                }
//            }
//            settings.apply {
//                javaScriptEnabled = true
//                allowFileAccessFromFileURLs = true
//                allowUniversalAccessFromFileURLs = true
//            }
//            loadUrl(website)
//        }
//    }
//
////    override fun onStart() {
////        super.onStart()
////        if (ActivityCompat.checkSelfPermission(
////                this,
////                Manifest.permission.ACCESS_FINE_LOCATION
////            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
////                this,
////                Manifest.permission.ACCESS_COARSE_LOCATION
////            ) != PackageManager.PERMISSION_GRANTED
////        ) {
////            ActivityCompat.requestPermissions(
////                this,
////                arrayOf(
////                    Manifest.permission.ACCESS_FINE_LOCATION,
////                    Manifest.permission.ACCESS_COARSE_LOCATION
////                ),
////                1
////            )
////            return
////        }
////        locationManager.requestLocationUpdates(
////            LocationManager.GPS_PROVIDER,
////            0,
////            0f,
////            locationListener
////        )
////    }
//
//    override fun onStop() {
//        super.onStop()
//        locationManager.removeUpdates(locationListener)
//    }
//}
