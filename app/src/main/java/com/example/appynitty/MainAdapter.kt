package com.example.appynitty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainAdapter(private var data : List<ImageData>)  : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){
    private var fullDataList = data.toList()

    class MainViewHolder(val view : View): RecyclerView.ViewHolder(view) {
        fun bind(data: ImageData){
            view.findViewById<TextView>(R.id.title).text = "${data.title} ${data.firstName} ${data.lastName}"
            view.findViewById<TextView>(R.id.description).text = data.id
            Glide.with(view)
                .load(data.picture)
                .into(view.findViewById(R.id.ivProfile))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun addData(newdata : List<ImageData>){
        data =  newdata
        fullDataList = newdata.toList()
        notifyDataSetChanged()
    }

    fun filter(query : String){
        data =if (query.isEmpty()){
            fullDataList
        }else{
            fullDataList.filter {
                it.firstName.contains(query,ignoreCase = true) ||
                        it.lastName.contains(query,ignoreCase = true)
            }
        }
        notifyDataSetChanged()

    }
}

