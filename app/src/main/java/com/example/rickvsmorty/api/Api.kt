package com.example.rickvsmorty.api

import com.example.rickvsmorty.Util
import com.example.rickvsmorty.model.ResponseApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET(Util.END_POINT)
    suspend fun getAllCharacters(
//        @Query("count") size:Int,
        @Query("page") page: Int
    ): Response<ResponseApi>
}
