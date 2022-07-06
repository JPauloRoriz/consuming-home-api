package com.example.apitimes.usecase.contract

import com.example.apitimes.data.service.setting.Result
import com.example.apitimes.domain.entity.BaseComponent

interface GetHomeUseCase {
    suspend fun invoke() : Result<List<BaseComponent>>
}