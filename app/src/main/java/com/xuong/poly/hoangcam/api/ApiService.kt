package com.xuong.poly.hoangcam.api

import com.xuong.poly.hoangcam.model.FoodModel
import com.xuong.poly.hoangcam.model.OrderModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("/Items")
    suspend fun getFoods(): Response<ArrayList<FoodModel>>

    @POST("/Items")
    suspend fun addFood(@Body nItem: FoodModel): Response<FoodModel>

    @DELETE("/Items/{id}")
    suspend fun deleteFood(@Path("id") id: String)

    @PUT("/Items/{id}")
    suspend fun updateFood(@Path("id") id: String, @Body uItem: FoodModel)

    @GET("/Orders")
    suspend fun getOrders(): Response<ArrayList<OrderModel>>

    @POST("/Orders")
    suspend fun addOrder(@Body nOrder: OrderModel): Response<OrderModel>


}