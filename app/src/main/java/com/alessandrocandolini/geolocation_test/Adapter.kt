package com.alessandrocandolini.geolocationtest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alessandrocandolini.geolocation_test.R

/**
 * Created by alessandroc on 31/01/2018.
 */
class Adapter( var addresses :  List<Address> ) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount() = addresses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(addresses[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(itemView)
    }

}