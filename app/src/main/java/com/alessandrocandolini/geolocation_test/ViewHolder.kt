package com.alessandrocandolini.geolocationtest

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * Created by alessandroc on 31/01/2018.
 */
class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    private val addressName : TextView = itemView.findViewById(R.id.addressName)

    fun bind(address : Address) {
        addressName.text = address.name
    }



}