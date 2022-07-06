package com.example.apitimes.data.service.setting

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

class Result<T> {

    var response: T? = null
    var error: Exception? = null

    fun isSuccessful() = response != null
    fun isError() = error != null

    companion object {
        fun <T> success(result: T) = Result<T>().apply {
            response = result
        }

        fun <T> error(error: Exception?) = Result<T>().apply {
            this.error = error
        }
    }
}

suspend fun <T> Call<T>.backgroundCall(): Result<T> {
    return withContext(Dispatchers.IO) {
        try {
            val result = execute()
            if (result.isSuccessful) {
                val body = result.body()
                if (body != null) {
                    Result.success(body)
                } else {
                    Result.error(Exception())
                }
            } else {
                Result.error(Exception(result.message()))
            }
        } catch (exception: Exception) {
            Result.error(exception)
        }
    }
}