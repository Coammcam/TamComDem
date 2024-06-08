package com.xuong.poly.hoangcam.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object HttpReq {
    val URL_Base = "http://10.0.2.2:3000/"
    fun getInstance(): ApiService {
        return Retrofit
            .Builder()
            .baseUrl(URL_Base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}