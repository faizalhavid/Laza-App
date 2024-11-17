package com.faizal.project.laza.data.service

import com.faizal.project.laza.data.model.Product
import retrofit2.http.GET

interface ProductService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}

