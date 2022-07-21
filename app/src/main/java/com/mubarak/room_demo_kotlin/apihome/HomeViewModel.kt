package com.mubarak.room_demo_kotlin.apihome

import androidx.lifecycle.ViewModel
import com.mubarak.room_demo_kotlin.utils.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.lifecycle.viewModelScope


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) :ViewModel() {

    private var mPlansStatus =
        MutableStateFlow<ApiState>(ApiState.Empty)
    val plansStatus: StateFlow<ApiState> = mPlansStatus

    fun fetchData() = viewModelScope.launch {
        mPlansStatus.value = ApiState.Loading
        mPlansStatus.value = ApiState.Success(repository.getRepository())
    }

}