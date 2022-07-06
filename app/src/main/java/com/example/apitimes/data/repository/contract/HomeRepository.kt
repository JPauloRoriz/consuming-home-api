package com.example.apitimes.data.repository.contract

import com.example.apitimes.data.service.setting.Result
import com.example.apitimes.domain.entity.BaseComponent

interface HomeRepository {
    suspend fun getHome(): Result<List<BaseComponent>>
}