package com.example.apitimes.viewmodel.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.apitimes.data.service.setting.Result
import com.example.apitimes.domain.entity.BaseComponent
import com.example.apitimes.domain.entity.Team
import com.example.apitimes.usecase.contract.GetHomeUseCase
import com.example.apitimes.viewmodel.model.HomeState
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.kotlin.*

@RunWith(JUnit4::class)
class HomeViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val useCase: GetHomeUseCase = mock()
    private val livedata: Observer<HomeState> = mock()

    private lateinit var viewModel: HomeViewModel


    @Test
    fun `when init viewModel with success then call OnSuccessList`() {
        runBlocking {
            //mock
            val expected = getMockListBaseComponent()
            whenever(useCase.invoke()).then { Result.success(expected) }

            //dispara
            viewModel = HomeViewModel(useCase)
            viewModel.listHomeLiveData.observeForever(livedata)

            //Verify
            inOrder(livedata) {
                verify(livedata).onChanged(HomeState.ShowLoading)
                verify(livedata).onChanged(HomeState.OnSuccessList(expected))
                verify(livedata).onChanged(HomeState.HideLoading)
                verifyNoMoreInteractions()
            }
            verify(livedata, never()).onChanged(HomeState.OnError)
        }
    }

    @Test
    fun `when init viewModel with error then call OnError`() {
        runBlocking {
            //mock
            val expected = Exception()
            val noExpected = getMockListBaseComponent()
            whenever(useCase.invoke()).then { Result.error<Exception>(expected) }

            //dispara
            viewModel = HomeViewModel(useCase)
            viewModel.listHomeLiveData.observeForever(livedata)


            //Verify
            inOrder(livedata) {
                verify(livedata).onChanged(HomeState.ShowLoading)
                verify(livedata).onChanged(HomeState.OnError)
                verify(livedata).onChanged(HomeState.HideLoading)
                verifyNoMoreInteractions()
            }
            verify(livedata, never()).onChanged(HomeState.OnSuccessList(noExpected))
        }
    }

    private fun getMockListBaseComponent() = listOf<BaseComponent>(
        Team("joao", "descricao", "imagem")
    )

}
