package com.mubarak.room_demo_kotlin.homeapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mubarak.room_demo_kotlin.databinding.CustomViewBinding
import com.mubarak.room_demo_kotlin.homeapi.model.HomeDataClass

class HomeAdapter(private val list: List<HomeDataClass>) :
    RecyclerView.Adapter<HomeAdapter.HomeAdapterViewHolder>() {
    class HomeAdapterViewHolder(private val binding: CustomViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: HomeDataClass) {
            binding.apply {
                model = data
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterViewHolder {
        return HomeAdapterViewHolder(
            CustomViewBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}