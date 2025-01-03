package com.example.data.repository

import com.example.data.di.NetworkModule
import com.example.data.model.ProductResponse

class ProductRepository {

    private val apiService = NetworkModule.apiService

    suspend fun getProducts(
            limit: Int = 20,
            skip: Int = 0
    ): Result<ProductResponse> = try {
        Result.success(
                apiService.getProducts(
                        limit = limit,
                        skip = skip
                )
        )
    } catch (e: Exception) {
        Result.failure(e)
    }
} 