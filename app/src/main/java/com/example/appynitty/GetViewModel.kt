package com.example.appynitty

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.launch

class GetViewModel(private  val repository : GetRepository ): ViewModel() {
    private val list = MutableLiveData<List<ImageData>>()
    val getData: LiveData<List<ImageData>>  = list

    private var limit = 50

    init {
        fetchGetData()
    }

    private fun fetchGetData() {


        viewModelScope.launch {
            try {
                val response = repository.getData(limit)
                if (response != null){
                    list.value = response.gets

                }


            }catch ( e : Exception){
                e.printStackTrace()
            }
        }
    }
}