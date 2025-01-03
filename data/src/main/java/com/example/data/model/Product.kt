package com.example.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
        val id: Int,
        val title: String?,
        val description: String?,
        val price: Double,
        val discountPercentage: Double,
        val rating: Double,
        val stock: Int,
        val brand: String?,
        val category: String?,
        val thumbnail: String?,
        val images: List<String>?
) : Parcelable

data class ProductResponse(
        val products: List<Product>,
        val total: Int,
        val skip: Int,
        val limit: Int
) 