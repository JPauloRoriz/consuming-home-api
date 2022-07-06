package com.example.apitimes.viewmodel.model

import com.example.apitimes.domain.entity.BaseComponent

sealed class HomeState {
    data class OnSuccessList(val result: List<BaseComponent>) : HomeState()
    object OnError : HomeState()
    object ShowLoading : HomeState()
    object HideLoading : HomeState()
}