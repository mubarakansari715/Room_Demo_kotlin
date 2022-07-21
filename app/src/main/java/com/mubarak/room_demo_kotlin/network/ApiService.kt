package com.mubarak.room_demo_kotlin.network

import com.mubarak.room_demo_kotlin.homeapi.model.HomeDataClass
import retrofit2.http.GET


interface ApiService {
    @GET("photos")
    suspend fun getData(): List<HomeDataClass>

}