package com.mubarak.room_demo_kotlin.homeapi.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HomeDataClass")
data class HomeDataClass(
    @PrimaryKey val id: Int,
    val title: String,
    val url: String,
)