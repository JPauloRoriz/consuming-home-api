package com.example.apitimes.data.repository

import com.example.apitimes.data.repository.contract.HomeRepository
import com.example.apitimes.data.repository.mapper.HomeResponseMapper
import com.example.apitimes.data.service.HomeApi
import com.example.apitimes.data.service.setting.Result
import com.example.apitimes.data.service.setting.backgroundCall
import com.example.apitimes.domain.entity.BaseComponent

class HomeRepositoryImpl(
    private val api: HomeApi,
    private val mapper: HomeResponseMapper
) : HomeRepository {
    override suspend fun getHome(): Result<List<BaseComponent>> {
        val result = api.getHome().backgroundCall()
        return if(result.isSuccessful()){
            Result.success(
                result.response?.list?.map {
                    mapper.itemResponseToBaseComponent(it)
                }.orEmpty()
            )
        }else{
            return Result.error(result.error)
        }
    }

}
