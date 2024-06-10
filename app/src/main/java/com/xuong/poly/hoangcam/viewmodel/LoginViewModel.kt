package com.xuong.poly.hoangcam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xuong.poly.hoangcam.api.HttpReq
import com.xuong.poly.hoangcam.model.AccountModel
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    val api = HttpReq.getInstance()

    private val _statusCode = MutableLiveData<Int>()
    val statusCode:LiveData<Int> = _statusCode

    private val _auth = MutableLiveData<Boolean>()
    val auth: LiveData<Boolean> = _auth

    fun resetStatusCode(){
        _statusCode.postValue(0)
    }

    fun Login(email: String, pass: String){
        viewModelScope.launch {
            try {
                val response = api.Login(email)
                if(response.code() == 200 && response.body()?.pass == pass){
                    _auth.postValue(true)
                }else{
                    _auth.postValue(false)
                }
            }catch (e: RuntimeException){
                println(e)
            }
        }
    }

    fun SignUp(email: String, pass: String){
        viewModelScope.launch {
            try {
                val response = api.Signup(AccountModel(email, pass))
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
}