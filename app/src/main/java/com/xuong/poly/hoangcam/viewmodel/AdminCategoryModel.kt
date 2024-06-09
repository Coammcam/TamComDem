package com.xuong.poly.hoangcam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.xuong.poly.hoangcam.api.HttpReq
import com.xuong.poly.hoangcam.model.CategoryModel
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

class AdminCategoryModel: ViewModel(){
    private val api = HttpReq.getInstance()

    private val _statusCode = MutableLiveData<Int>()
    val statusCode: LiveData<Int> = _statusCode

    private val _categories = MutableLiveData<ArrayList<CategoryModel>>()
    val categories:LiveData<ArrayList<CategoryModel>> = _categories

    private val _aCategory = MutableLiveData<CategoryModel>()
    val aCategory:LiveData<CategoryModel> = _aCategory

    private val _newCategory = MutableLiveData<CategoryModel>()
    val newCategory:LiveData<CategoryModel> = _newCategory

    fun resetStatus(){
        _statusCode.postValue(0)
    }

    fun getCategory(){
        viewModelScope.launch {
            try {
                val response = api.getCategories()
                if(response.code() == 200){
                    _categories.postValue(response.body())
                }else{
                    _categories.postValue(ArrayList())
                }
            }catch(e: RuntimeException) {
                println(e)
            }
        }
    }

    fun getCategoryById(id: String){
        viewModelScope.launch {
            try {
                val response = api.get1Category(id)
                if(response.code() == 200){
                    _aCategory.postValue(response.body())
                }else{
                    _aCategory.postValue(CategoryModel("", ""))
                }
            }catch (e: RuntimeException){
                println(e)
            }
        }
    }

    fun addCategory(nCategoryModel: CategoryModel){
        viewModelScope.launch {
            try {
                val response = api.addCategory(nCategoryModel)
                if(response.code() == 201){
                    _statusCode.postValue(response.code())
                }
            }catch (e: RuntimeException){
                println(e)
            }
        }
    }

    fun deleteCategory(id: String){
        viewModelScope.launch {
            try {
                val response = api.deleteCategory(id)
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

    fun updateCategory(id: String, uCategory: CategoryModel){
        viewModelScope.launch {
            try {
                val response = api.updateCategory(id, uCategory)
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