package com.mubarak.room_demo_kotlin.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mubarak.room_demo_kotlin.R

object ImageLoading {
    @JvmStatic
    @BindingAdapter("android:loadImage")

    fun ImageView.loadImage(url:String?){
        if(url!=null&& url.isNotEmpty()){
            Glide.with(this.context).load(url).into(this)
        }
        else{
            Glide.with(this.context).load(R.drawable.ic_launcher_background).into(this)

        }
    }
}
