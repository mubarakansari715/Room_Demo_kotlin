package com.mubarak.room_demo_kotlin.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mubarak.room_demo_kotlin.homeapi.model.HomeDataClass

@Database(
    entities = [HomeDataClass::class],
    version = 1,
    exportSchema = false
)
abstract class SchemeDatabase : RoomDatabase() {

    abstract fun schemeDao(): SchemeDao
}