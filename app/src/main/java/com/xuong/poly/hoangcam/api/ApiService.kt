package com.xuong.poly.hoangcam.api

import com.xuong.poly.hoangcam.model.AccountModel
import com.xuong.poly.hoangcam.model.CategoryModel
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

    @GET("/Accounts/{email}")
    suspend fun Login(@Path("email") email: String): Response<AccountModel>

    @POST("/Accounts")
    suspend fun Signup(@Body nAccount: AccountModel): Response<AccountModel>

    @PUT("/Accounts/{id}")
    suspend fun UpdateAccount(@Path("id") id: String, @Body account: AccountModel)

    //CRUD foods
    @GET("/Items")
    suspend fun getFoods(): Response<ArrayList<FoodModel>>

    @GET("/Items/{id}")
    suspend fun get1Food(@Path("id") id: String): Response<FoodModel>

    @POST("/Items")
    suspend fun addFood(@Body nItem: FoodModel): Response<FoodModel>

    @DELETE("/Items/{id}")
    suspend fun deleteFood(@Path("id") id: String): Response<FoodModel>

    @PUT("/Items/{id}")
    suspend fun updateFood(@Path("id") id: String, @Body uItem: FoodModel): Response<FoodModel>


    //CRUD order
    @GET("/Orders")
    suspend fun getOrders(): Response<ArrayList<OrderModel>>

    @GET("/Orders/{id}")
    suspend fun get1Order(): Response<OrderModel>

    @POST("/Orders")
    suspend fun addOrder(@Body nOrder: OrderModel): Response<OrderModel>

    @PUT("/Orders/{id}")
    suspend fun updateOrder(@Path("id") id: String, @Body uOrder: OrderModel): Response<OrderModel>

    @DELETE("/Order/{id}")
    suspend fun deleteOrder(@Path("id") id: String): Response<OrderModel>

    //CRUD
    @GET("/Categories")
    suspend fun getCategories(): Response<ArrayList<CategoryModel>>

    @GET("/Categories/{id}")
    suspend fun get1Category(@Path("id") id: String): Response<CategoryModel>

    @POST("/Categories")
    suspend fun addCategory(@Body nCategoryModel: CategoryModel): Response<CategoryModel>

    @PUT("/Categories/{id}")
    suspend fun updateCategory(@Path("id") id: String, @Body nCategory: CategoryModel): Response<CategoryModel>

    @DELETE("/Categories/{id}")
    suspend fun deleteCategory(@Path("id") id: String): Response<CategoryModel>

}