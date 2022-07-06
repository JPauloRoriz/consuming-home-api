package com.example.apitimes.viewmodel.home

import androidx.lifecycle.ViewModel
import com.example.apitimes.usecase.contract.GetHomeUseCase
import com.example.apitimes.viewmodel.livedata.MultipleLiveState
import com.example.apitimes.viewmodel.model.HomeState
import com.example.apitimes.viewmodel.util.launch

class HomeViewModel(
    private val getHomeUseCase: GetHomeUseCase
) : ViewModel() {
    val listHomeLiveData = MultipleLiveState<HomeState>()

    init {
        launch {
            HomeState.ShowLoading.run()
            val result = getHomeUseCase.invoke()
            if (result.isSuccessful()) {
                HomeState.OnSuccessList(result.response.orEmpty()).run()
            } else {
                HomeState.OnError.run()
            }
            HomeState.HideLoading.run()
        }
    }

    private fun HomeState.run() {
        listHomeLiveData.postValue(this)
    }
}