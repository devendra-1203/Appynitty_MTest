package com.example.appynitty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private var data1 : List<ImageData>)  : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    class MainViewHolder(val view : View): RecyclerView.ViewHolder(view) {
        fun bind(data: ImageData){
            view.findViewById<TextView>(R.id.title).text = data.title
            view.findViewById<TextView>(R.id.description).text = data.title
           // view.findViewById<ImageView>(R.id.image_view). =data.image
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
        holder.bind(data1[position])
    }

    override fun getItemCount(): Int = data1.size

    fun addData(newdata : List<ImageData>){
        data1 = data1 + newdata
        notifyDataSetChanged()
    }
}

