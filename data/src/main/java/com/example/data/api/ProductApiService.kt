package com.example.data.api

import com.example.data.model.Product
import com.example.data.model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApiService {

    @GET("products")
    suspend fun getProducts(
            @Query("limit") limit: Int = 20,
            @Query("skip") skip: Int = 0
    ): ProductResponse

    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id: Int): Product
} 