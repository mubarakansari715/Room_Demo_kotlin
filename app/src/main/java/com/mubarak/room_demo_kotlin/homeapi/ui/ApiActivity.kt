package com.mubarak.room_demo_kotlin.homeapi.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.mubarak.room_demo_kotlin.MyApplication.Companion.networkConnectivity
import com.mubarak.room_demo_kotlin.R
import com.mubarak.room_demo_kotlin.homeapi.adapter.HomeAdapter
import com.mubarak.room_demo_kotlin.homeapi.model.HomeDataClass
import com.mubarak.room_demo_kotlin.homeapi.viewmodel.HomeViewModel
import com.mubarak.room_demo_kotlin.utils.ApiState
import com.mubarak.room_demo_kotlin.utils.NetworkConnectivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_api.*

@AndroidEntryPoint
class ApiActivity : AppCompatActivity() {

    val viewModel: HomeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        networkConnectivity = NetworkConnectivity(application)
        networkConnectivity.observe(this, Observer {
            when (it) {
                true -> {
                    Toast.makeText(this, "Online", Toast.LENGTH_SHORT).show()
                }
                false -> {
                    Toast.makeText(this, "Offline", Toast.LENGTH_SHORT).show()
                }
            }
        })

       /* try {

            lifecycleScope.launchWhenStarted {
                viewModel.fetchData()
                viewModel.plansStatus.collectLatest {
                    when (it) {
                        is ApiState.Success<*> -> {

                            Log.d(TAG, "@@@onCreate: Success ${it.data}")
                            //text.text = it.data.toString()
                            if (it.data is List<*>) {
                                val listData: List<HomeDataClass> =
                                    it.data.filterIsInstance<HomeDataClass>()
                                recyclerView.adapter = HomeAdapter(list = listData)
                            }

                        }
                        is ApiState.Empty -> {
                            Log.d(TAG, "@@@onCreate: Empty")
                        }
                        is ApiState.Failure -> {
                            Log.d(TAG, "@@@onCreate: Failed ${it.error}")
                        }
                        else -> {

                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, "@@@onCreate: ${e.printStackTrace()}")
        }*/

        viewModel.data.observe(this, Observer {

            Log.d(TAG, "@@@onCreate: Success ${it.data}")

            //progress
            progress_circular.isVisible =
                it is ApiState.Loading && it.data.isNullOrEmpty()

            //error
            text.isVisible = it is ApiState.Error && it.data.isNullOrEmpty()
            text.text = it.error?.localizedMessage

            //success
            if (it.data is List<*>) {
                val listData: List<HomeDataClass> =
                    it.data.filterIsInstance<HomeDataClass>()
                recyclerView.adapter = HomeAdapter(list = listData)
            }
        })
    }
}