package com.mubarak.room_demo_kotlin.homeapi.repository

import androidx.room.withTransaction
import com.mubarak.room_demo_kotlin.homeapi.model.HomeDataClass
import com.mubarak.room_demo_kotlin.network.ApiService
import com.mubarak.room_demo_kotlin.room.SchemeDatabase
import javax.inject.Inject

class HomeRepository @Inject constructor(
    val apiService: ApiService,
    private val db: SchemeDatabase
) {
    private val schemeDao = db.schemeDao()

    suspend fun getRepository(): ArrayList<HomeDataClass> {
        val fetchData = apiService.getData()
        if (fetchData.isEmpty()) {
            db.withTransaction {
                schemeDao.insertSchemes(fetchData.toList())
            }
        }
        return fetchData
    }

}