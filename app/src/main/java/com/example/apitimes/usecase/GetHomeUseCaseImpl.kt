package com.example.apitimes.usecase

import com.example.apitimes.data.repository.contract.HomeRepository
import com.example.apitimes.usecase.contract.GetHomeUseCase

class GetHomeUseCaseImpl(
    private val repository: HomeRepository
) : GetHomeUseCase {
    override suspend fun invoke() = repository.getHome()

}