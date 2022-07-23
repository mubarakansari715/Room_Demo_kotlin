package com.mubarak.room_demo_kotlin.room

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app:Application): SchemeDatabase =
        Room.databaseBuilder(app, SchemeDatabase::class.java,"local_database").build()
}