package com.example.apitimes.data.service.setting


import com.example.apitimes.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitConfig: Retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .client(
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) }
        ).build()
    )
    .addConverterFactory(GsonConverterFactory.create())
    .build()
