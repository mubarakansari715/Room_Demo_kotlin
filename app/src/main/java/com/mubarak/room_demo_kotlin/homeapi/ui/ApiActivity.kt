package com.mubarak.room_demo_kotlin.homeapi.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.mubarak.room_demo_kotlin.R
import com.mubarak.room_demo_kotlin.homeapi.viewmodel.HomeViewModel
import com.mubarak.room_demo_kotlin.utils.ApiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_api.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ApiActivity : AppCompatActivity() {

    val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        lifecycleScope.launch {
            viewModel.fetchData()
            viewModel.plansStatus.collect {
                when (it) {
                    is ApiState.Empty -> {
                        Log.d(TAG, "@@@onCreate: Empty")
                    }
                    is ApiState.Success<*> -> {
                        Log.d(TAG, "@@@onCreate: Success ${it.data}")
                        text.text = it.data.toString()

                    }
                    is ApiState.Failure -> {
                        Log.d(TAG, "@@@onCreate: Failed")
                    }
                    else -> {

                    }
                }
            }
        }

    }
}