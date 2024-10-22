package com.example.appynitty

class GetRepository(private  val api : GetAPI) {
    suspend fun getData(limit: Int) : GetResponse{
        return api.getData("62c2856a019d8b1386e1c77d", limit)
    }
}