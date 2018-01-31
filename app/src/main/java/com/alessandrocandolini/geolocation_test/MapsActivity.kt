package com.alessandrocandolini.geolocationtest

import android.location.Geocoder
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Button
import java.util.*

class MapsActivity : AppCompatActivity() {

    lateinit var  adapter : Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        val addresses = ArrayList<Address>()
        addresses.add(Address("1"))
        addresses.add(Address("2"))
        addresses.add(Address("3"))
        addresses.add(Address("4"))
        addresses.add(Address("5"))
        addresses.add(Address("6"))

        adapter = Adapter(addresses)

        val recycleView = findViewById<RecyclerView>(R.id.addressRecycleview)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = adapter

        val button = findViewById<Button>(R.id.refreshButton)
        button.setOnClickListener { _ -> load() }

        Log.d("Addresses", "$addresses")
    }

    private fun load() {
        Log.d("Addresses", "load")
        val geocoder = Geocoder(this, Locale.getDefault())
        val addresses  = geocoder.getFromLocation(40.69, -74.26, 50)
        val mappedAddresses = addresses
                .map { address -> address.featureName } // input: android.location.Address, output: String
                .map { string -> Address(string)} // input: String, output: my Address() class
                .toList()
        adapter.addresses = mappedAddresses
        adapter.notifyDataSetChanged()
    }

}
