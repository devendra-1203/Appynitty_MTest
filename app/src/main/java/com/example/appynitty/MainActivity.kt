package com.example.appynitty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainAdapter
    private lateinit var viewModel : GetViewModel
    private val layoutManager by lazy { LinearLayoutManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //https://dummyapi.io/data/v1/user?limit=50

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(GetAPI::class.java)
        val reposiory = GetRepository(api)
        viewModel = GetViewModel(reposiory)

        adapter = MainAdapter(emptyList())
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter


        viewModel.getData.observe(this, Observer {posts ->
            adapter.addData(posts)

        })



    }
}