package com.example.apitimes.viewmodel.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

fun ViewModel.launch(
    coroutineContext: CoroutineContext = Dispatchers.IO,
    block: suspend () -> Unit
) {
    viewModelScope.launch(coroutineContext) {
        block.invoke()
    }
}