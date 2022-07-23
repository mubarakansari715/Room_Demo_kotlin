package com.mubarak.room_demo_kotlin.room

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.mubarak.room_demo_kotlin.homeapi.model.HomeDataClass

@Dao
interface SchemeDao {
    @RawQuery
    fun getSchemes(sqlLiteQuery : SupportSQLiteQuery) : List<HomeDataClass>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchemes(schems:List<HomeDataClass>)

    @Query("Delete from HomeDataClass")
    suspend fun deleteAllSchemes()
}