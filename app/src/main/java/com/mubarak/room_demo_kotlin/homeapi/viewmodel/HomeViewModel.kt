package com.mubarak.room_demo_kotlin.homeapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mubarak.room_demo_kotlin.utils.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.mubarak.room_demo_kotlin.homeapi.repository.HomeRepository


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) :ViewModel() {

   /* private var mPlansStatus =
        MutableStateFlow<ApiState>(ApiState.Empty)
    val plansStatus: StateFlow<ApiState> = mPlansStatus*/

    val data= repository.getRepository().asLiveData()

   /* fun fetchData() = viewModelScope.launch {
        mPlansStatus.value = ApiState.Loading
        mPlansStatus.value = ApiState.Success(repository.getRepository().asLiveData())

    }*/

}