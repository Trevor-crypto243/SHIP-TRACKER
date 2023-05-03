//package com.example.maps2
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//
//import android.Manifest
//import android.content.pm.PackageManager
//import android.location.Location
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//import com.google.android.gms.location.FusedLocationProviderClient
//import com.google.android.gms.location.LocationServices
//import com.google.android.gms.maps.CameraUpdateFactory
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.google.android.gms.maps.SupportMapFragment
//import com.google.android.gms.maps.model.LatLng
//import com.google.android.gms.maps.model.MarkerOptions
//
//class MainActivity : AppCompatActivity(), OnMapReadyCallback {
//    private lateinit var fusedLocationClient: FusedLocationProviderClient
//    private lateinit var map: GoogleMap
//
//    companion object {
//        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
//
//        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
//        mapFragment.getMapAsync(this)
//    }
//
//    override fun onMapReady(googleMap: GoogleMap) {
//        map = googleMap
//
//        // Request location permission if not granted
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
//        } else {
//            showCurrentLocation()
//        }
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                showCurrentLocation()
//            }
//        }
//    }
//
//    private fun showCurrentLocation() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            map.isMyLocationEnabled = true
//
//            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
//                location?.let {
//                    val currentLatLng = LatLng(it.latitude, it.longitude)
//                    map.addMarker(MarkerOptions().position(currentLatLng).title("Current Location"))
//                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
//                }
//            }
//        }
//    }
//
//    // Implement methods for reporting a ship's position and tracking/searching other ships
//
//    // ...
//
//}
//
//
////package com.example.maps2
////
////import androidx.appcompat.app.AppCompatActivity
////import android.os.Bundle
////
////import android.Manifest
////import android.content.pm.PackageManager
////import android.location.Location
////import androidx.appcompat.app.AppCompatActivity
////import android.os.Bundle
////import androidx.core.app.ActivityCompat
////import androidx.core.content.ContextCompat
////import com.google.android.gms.location.FusedLocationProviderClient
////import com.google.android.gms.location.LocationServices
////import com.google.android.gms.maps.CameraUpdateFactory
////import com.google.android.gms.maps.GoogleMap
////import com.google.android.gms.maps.OnMapReadyCallback
////import com.google.android.gms.maps.SupportMapFragment
////import com.google.android.gms.maps.model.LatLng
////import com.google.android.gms.maps.model.MarkerOptions
////
////class MainActivity : AppCompatActivity(), OnMapReadyCallback {
////    private lateinit var fusedLocationClient: FusedLocationProviderClient
////    private lateinit var map: GoogleMap
////
////    companion object {
////        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
////    }
////
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_main)
////
////        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
////
////        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
////        mapFragment.getMapAsync(this)
////    }
////
////    override fun onMapReady(googleMap: GoogleMap) {
////        map = googleMap
////
////        // Request location permission if not granted
////        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
////            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
////        } else {
////            showCurrentLocation()
////        }
////    }
////
////    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
////        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
////            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
////                showCurrentLocation()
////            }
////        }
////    }
////
////    private fun showCurrentLocation() {
////        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
////            map.isMyLocationEnabled = true
////
////            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
////                location?.let {
////                    val currentLatLng = LatLng(it.latitude, it.longitude)
////                    map.addMarker(MarkerOptions().position(currentLatLng).title("Current Location"))
////                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
////                }
////            }
////        }
////    }
////
////    // Method for reporting a ship's position
////    private fun reportShipPosition(shipName: String, latitude: Double, longitude: Double) {
////        // Implement code for reporting the ship's position to the server
////    }
////
////    // Method for tracking/searching other ships
////    private fun trackOtherShips() {
////        // Implement code for tracking/searching other ships
////    }
////}
//
