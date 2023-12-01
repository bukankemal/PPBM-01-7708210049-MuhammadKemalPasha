package com.example.assesmen1_ppbm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter(context: Context, dataArrayList: ArrayList<ListData?>?) :
    ArrayAdapter<ListData?>(context, R.layout.list_item, dataArrayList!!) {
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var view = view
        val listData = getItem(position)

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }
        val listImages = view!!.findViewById<ImageView>(R.id.listImages)
        val listArtists = view.findViewById<TextView>(R.id.listArtists)
        val listTitles = view.findViewById<TextView>(R.id.listTitles)
        listImages.setImageResource(listData!!.image)
        listArtists.text = listData.artist
        listTitles.text = listData.title
        return view
    }
}