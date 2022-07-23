package com.mubarak.room_demo_kotlin.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mubarak.room_demo_kotlin.homeapi.model.HomeDataClass
import kotlinx.coroutines.flow.Flow

@Dao
interface SchemeDao {
    /* @Query
     fun getSchemes(sqlLiteQuery : SupportSQLiteQuery) : List<HomeDataClass>*/

    @Query("select * from HomeDataClass")
    fun getSchemes(): Flow<List<HomeDataClass>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchemes(schems: List<HomeDataClass>)

    @Query("Delete from HomeDataClass")
    suspend fun deleteAllSchemes()
}