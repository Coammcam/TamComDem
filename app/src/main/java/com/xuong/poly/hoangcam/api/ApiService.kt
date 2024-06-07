package com.xuong.poly.hoangcam.api

import com.xuong.poly.hoangcam.model.ItemModel
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
    suspend fun getItems(): Response<ArrayList<ItemModel>>

    @POST("/Items")
    suspend fun addItem(@Body nItem: ItemModel): Response<ItemModel>

    @DELETE("/Items/{id}")
    suspend fun deleteItem(@Path("id") id: String)

    @PUT("/Items/{id}")
    suspend fun updateItem(@Path("id") id: String, @Body uItem: ItemModel)

    @GET("/Orders")
    suspend fun getOrders(): Response<ArrayList<OrderModel>>

    @POST("/Orders")
    fun addOrder(@Body nOrder: OrderModel): Response<OrderModel>


}