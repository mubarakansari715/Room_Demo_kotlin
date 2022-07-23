package com.mubarak.room_demo_kotlin.homeapi.repository

import androidx.room.withTransaction
import com.mubarak.room_demo_kotlin.homeapi.model.HomeDataClass
import com.mubarak.room_demo_kotlin.network.ApiService
import com.mubarak.room_demo_kotlin.room.SchemeDatabase
import com.mubarak.room_demo_kotlin.utils.networkboundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class HomeRepository @Inject constructor(
    val apiService: ApiService,
    private val db: SchemeDatabase
) {
    private val schemeDao = db.schemeDao()

  /*  suspend fun getRepository(): ArrayList<HomeDataClass> {
        val fetchData = apiService.getData()
        db.withTransaction {
            schemeDao.insertSchemes(fetchData.toList())
        }
        return fetchData
    }*/
    fun getRepository()  = networkboundResource(
        fetch = {
            delay(2000)
            apiService.getData()
        },
        saveFetchResult = {
            db.withTransaction {
                schemeDao.insertSchemes(it)
            }
        },
      query = {
          schemeDao.getSchemes()
      },
    )

}