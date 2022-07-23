package com.mubarak.room_demo_kotlin

import android.app.Application
import com.mubarak.room_demo_kotlin.utils.NetworkConnectivity
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication:Application() {
    companion object{
        lateinit var networkConnectivity: NetworkConnectivity

    }

    override fun onCreate() {
        super.onCreate()
        networkConnectivity = NetworkConnectivity(this)
    }
}