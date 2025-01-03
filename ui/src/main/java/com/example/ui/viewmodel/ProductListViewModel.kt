package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.Product
import com.example.data.repository.ProductRepository
import com.example.ui.model.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel() {

    private val repository = ProductRepository()
    private val _productsState = MutableStateFlow<UiState<List<Product>>>(UiState.Loading)
    val productsState: StateFlow<UiState<List<Product>>> = _productsState

    private val _isPaginationLoading = MutableStateFlow(false)
    val isPaginationLoading: StateFlow<Boolean> = _isPaginationLoading

    private var currentPage = 0
    private val pageSize = 20
    private var isLastPage = false
    private var isLoading = false
    private val products = mutableListOf<Product>()
    private var currentSearchQuery: String = ""

    init {
        loadProducts()
    }

    fun loadProducts(isRefresh: Boolean = false) {
        if (isRefresh) {
            currentPage = 0
            isLastPage = false
            products.clear()
        }

        if (isLoading || isLastPage) return
        isLoading = true

        viewModelScope.launch {
            if (currentPage == 0) {
                _productsState.value = UiState.Loading
            } else {
                _isPaginationLoading.value = true
            }

            val skip = currentPage * pageSize
            repository.getProducts(
                    limit = pageSize,
                    skip = skip
            )
                .onSuccess { response ->
                    isLoading = false
                    _isPaginationLoading.value = false

                    if (response.products.isEmpty()) {
                        isLastPage = true
                        return@onSuccess
                    }

                    products.addAll(response.products)
                    currentPage++
                    updateProductsList()
                }
                .onFailure { exception ->
                    isLoading = false
                    _isPaginationLoading.value = false
                    _productsState.value = UiState.Error(
                            exception.message ?: "An unexpected error occurred"
                    )
                }
        }
    }

    fun searchProducts(query: String) {
        currentSearchQuery = query
        updateProductsList()
    }

    private fun updateProductsList() {
        val filteredProducts = if (currentSearchQuery.isNullOrBlank()) {
            products
        } else {
            products.filter { product ->
                (product.title?.contains(
                        currentSearchQuery,
                        ignoreCase = true
                ) ?: false) || (product.description?.contains(
                        currentSearchQuery,
                        ignoreCase = true
                ) ?: false) || (product.brand?.contains(
                        currentSearchQuery,
                        ignoreCase = true
                ) ?: false)
            }
        }
        _productsState.value = UiState.Success(filteredProducts)
    }

    fun canLoadMore(): Boolean {
        return !isLoading && !isLastPage && currentSearchQuery.isNullOrBlank()
    }
} 