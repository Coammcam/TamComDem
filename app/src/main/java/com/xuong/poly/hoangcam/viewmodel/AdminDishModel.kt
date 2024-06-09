package com.xuong.poly.hoangcam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xuong.poly.hoangcam.api.HttpReq
import com.xuong.poly.hoangcam.model.FoodModel
import kotlinx.coroutines.launch

class AdminDishModel: ViewModel() {
    private val api = HttpReq.getInstance()

    private val _statusCode = MutableLiveData<Int>()
    val statusCode:LiveData<Int> = _statusCode

    private val _dishes = MutableLiveData<ArrayList<FoodModel>>()
    val dishes:LiveData<ArrayList<FoodModel>> = _dishes

    private val _aDish = MutableLiveData<FoodModel>()
    val aDish:LiveData<FoodModel> = _aDish

    fun resetStatusCode(){
        _statusCode.postValue(0)
    }

    fun getDishes(){
        viewModelScope.launch {
            try {
                val response = api.getFoods()
                if(response.code() == 200){
                    _dishes.postValue(response.body())
                }else{
                    _dishes.postValue(ArrayList())
                }
            }catch (e: RuntimeException){
                println(e)
            }
        }
    }

    fun get1Dish(id: String){
        viewModelScope.launch {
            try {
                val response = api.get1Food(id)
                if(response.code() == 200){
                    _aDish.postValue(response.body())
                }else{
                    _aDish.postValue(FoodModel("", "", 0f, 0 , 0 , 0))
                }
            }catch (e: RuntimeException){
                println(e)
            }
        }
    }

    fun addDish(nDish: FoodModel){
        viewModelScope.launch {
            try {
                val response = api.addFood(nDish)
                if(response.code() == 201){
                    _statusCode.postValue(response.code())
                }else{
                    _statusCode.postValue(0)
                }
            }catch (e: RuntimeException){
                println(e)
            }
        }
    }

    fun updateDish(id: String, uDish: FoodModel){
        viewModelScope.launch {
            try {
                val response = api.updateFood(id, uDish)
                if(response.code() == 200){
                    _statusCode.postValue(response.code())
                }else{
                    _statusCode.postValue(0)
                }
            }catch (e: RuntimeException){
                println(e)
            }
        }
    }

    fun deleteDish(id: String){
        viewModelScope.launch {
            try {
                val response = api.deleteFood(id)
                if(response.code() == 200){
                    _statusCode.postValue(response.code())
                }else{
                    _statusCode.postValue(0)
                }
            }catch (e: RuntimeException){
                println(e)
            }
        }
    }

}