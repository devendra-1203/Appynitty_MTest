package com.example.appynitty

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainAdapter
    private val viewModel : GetViewModel by lazy { GetViewModel() }
    private val layoutManager by lazy { LinearLayoutManager(this) }
    private lateinit var etSearch: EditText
    private val limit:Int=50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        etSearch = findViewById(R.id.search_bar)


        adapter = MainAdapter(emptyList())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter


        viewModel.data.observe(this, Observer {get ->
            adapter.addData(get)

        })

      viewModel.fetchData(limit)
        etSearch.addTextChangedListener { text ->
            val query= text.toString()
            adapter.filter(query)
        }


    }
}