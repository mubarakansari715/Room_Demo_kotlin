package com.mubarak.room_demo_kotlin.apihome

import com.mubarak.room_demo_kotlin.network.ApiService
import javax.inject.Inject

class HomeRepository @Inject constructor(val apiService: ApiService) {

    suspend fun getRepository(): List<HomeDataClass> {
        return apiService.getData()
    }
}