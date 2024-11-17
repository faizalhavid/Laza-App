package com.faizal.project.laza.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizal.project.laza.data.model.Product
import com.faizal.project.laza.data.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val productRepository = ProductRepository()
    private val _products = MutableLiveData<List<Product>>()
    val products: MutableLiveData<List<Product>> get() = _products
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: MutableLiveData<Boolean> get() = _isLoading

    fun fetchProducts() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = productRepository.getAllProducts()
                _products.postValue(response)
            } catch (e: Exception) {
                throw e
            } finally {
                _isLoading.postValue(false)
            }
        }
    }
}