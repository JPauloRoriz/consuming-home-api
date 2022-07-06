package com.example.apitimes.data.service

import com.example.apitimes.data.entities.response.HomeResponse
import com.example.apitimes.data.service.setting.Result
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface HomeApi {
    @GET("home")
    fun getHome() : Call<HomeResponse>
}