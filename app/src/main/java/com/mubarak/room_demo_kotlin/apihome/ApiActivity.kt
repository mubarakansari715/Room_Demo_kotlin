package com.mubarak.room_demo_kotlin.apihome

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.mubarak.room_demo_kotlin.R
import com.mubarak.room_demo_kotlin.utils.ApiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
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