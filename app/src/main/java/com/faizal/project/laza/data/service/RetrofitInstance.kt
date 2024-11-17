package com.faizal.project.laza.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private val BASE_URL = "https://fakestoreapi.com/";
    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val productServiceApi: ProductService by lazy {
        retrofit.create(ProductService::class.java)
    }
}