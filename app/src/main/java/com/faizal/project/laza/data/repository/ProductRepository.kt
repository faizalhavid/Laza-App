package com.faizal.project.laza.data.repository

import com.faizal.project.laza.data.model.Product
import com.faizal.project.laza.data.service.RetrofitInstance

class ProductRepository{
    private val productServiceApi = RetrofitInstance.productServiceApi
    suspend fun getAllProducts(): List<Product>     {
        return productServiceApi.getProducts()
    }
}