package com.example.mvvmyoutube.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import domain.models.SaveUserNameParam
import domain.usecases.GetUserNameUseCase
import domain.usecases.SaveUserNameUseCase
import domain.models.UserName

class MainViewModel(
    val getUserNameUseCase: GetUserNameUseCase,
    val saveUserNameUseCase: SaveUserNameUseCase
): ViewModel() {

   private val resultLiveMutable = MutableLiveData<String>()/*this value can't be use for other classes, so it is private
          but we use LiveData which is Mutable so we can change value and in MainActivity observe for changing .
          We use getResultLive or create new value LiveData whick set our Mutable value*/

    val resultLive: LiveData<String> = resultLiveMutable

    init {
        Log.e("AAA", "ViewModel created")
    }

    override fun onCleared() {
        Log.e("AAA", "ViewModel cleared")
        super.onCleared()
    }

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param=params)
       resultLiveMutable.value = "Save result = $resultData"
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }

//    fun getResultLive(): LiveData<String>{
//        return resultLive
//    }
}