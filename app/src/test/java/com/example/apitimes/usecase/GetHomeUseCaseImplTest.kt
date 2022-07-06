package com.example.apitimes.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.apitimes.data.repository.contract.HomeRepository
import com.example.apitimes.data.service.setting.Result
import com.example.apitimes.domain.entity.BaseComponent
import com.example.apitimes.domain.entity.Team
import com.example.apitimes.usecase.contract.GetHomeUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(JUnit4::class)
class GetHomeUseCaseImplTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val repository: HomeRepository = mock()

    private lateinit var useCase: GetHomeUseCase

    @Before
    fun init() {
        useCase = GetHomeUseCaseImpl(repository)
    }

    @Test
    fun `when call invoke then call getHome of repository`() {
        runBlocking {
            val expected = Result.success(getMockListBaseComponent())
            whenever(repository.getHome()).then { expected }
            useCase.invoke()
            verify(repository).getHome()
        }
    }

    private fun getMockListBaseComponent() = listOf<BaseComponent>(
        Team("joao", "descricao", "imagem")
    )
}