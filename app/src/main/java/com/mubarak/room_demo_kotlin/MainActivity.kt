package com.mubarak.room_demo_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mubarak.room_demo_kotlin.apihome.ApiActivity
import com.mubarak.room_demo_kotlin.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)


        binding!!.btnApi.setOnClickListener {
            val intent = Intent(this, ApiActivity::class.java)
            startActivity(intent)
        }
    }
}