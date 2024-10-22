package com.example.appynitty

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.launch

class GetViewModel : ViewModel() {

private val _data = MutableLiveData<List<ImageData>>()
val data: LiveData<List<ImageData>>  get() = _data
    val headers : String ="62c2856a019d8b1386e1c77d"



//    init {
//        fetchData(limit = 50)
//    }

    fun fetchData(limit: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getData(headers,limit)
                if (response != null) {
                    _data.postValue(response.data)
                } else {
                    Log.e("GetViewModel", "Received null response")
                }
            } catch (e: Exception) {
                Log.e("GetViewModel", "Error fetching data", e)
                e.printStackTrace()
            }
        }
    }
}













//class GetViewModel(private  val repository : GetRepository ): ViewModel() {
//    private val list = MutableLiveData<List<ImageData>>()
//    val getData: LiveData<List<ImageData>> get()  = list
//
//    private var limit = 50
//
//    init {
//        fetchGetData()
//    }
//
//    private fun fetchGetData() {
//
//
//        viewModelScope.launch {
//            try {
//                val response = repository.getData(limit)
//                if (response != null){
//                    val st = response.gets
//                    Log.d("GetViewModel", "Fetched data: ${response.gets.get(0)}")
//
//                }
//
//
//            }catch ( e : Exception){
//                e.printStackTrace()
//            }
//        }
//    }
//}