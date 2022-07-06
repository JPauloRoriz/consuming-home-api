package com.example.apitimes.di

import com.example.apitimes.data.repository.HomeRepositoryImpl
import com.example.apitimes.data.repository.contract.HomeRepository
import com.example.apitimes.data.repository.mapper.HomeResponseMapper
import com.example.apitimes.data.service.HomeApi
import com.example.apitimes.data.service.setting.retrofitConfig
import com.example.apitimes.usecase.GetHomeUseCaseImpl
import com.example.apitimes.usecase.contract.GetHomeUseCase
import com.example.apitimes.viewmodel.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {

    //ViewModel
    viewModel { HomeViewModel(get()) }

    //Usecase
    factory<GetHomeUseCase> { GetHomeUseCaseImpl(get()) }

    //Repository
    factory<HomeRepository> { HomeRepositoryImpl(get(), get()) }

    //Service
    single { retrofitConfig }
    single { HomeResponseMapper() }
    single { get<Retrofit>().create(HomeApi::class.java) }

}