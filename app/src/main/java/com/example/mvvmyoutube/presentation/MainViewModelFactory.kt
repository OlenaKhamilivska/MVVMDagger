package com.example.mvvmyoutube.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import data.repository.UserRepositoryImpl
import data.storage.SharedPrefUserStorage
import domain.usecases.GetUserNameUseCase
import domain.usecases.SaveUserNameUseCase


class MainViewModelFactory(
    val getUserNameUseCase: GetUserNameUseCase,
    val saveUserNameUseCase: SaveUserNameUseCase
) :ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase) as T
    }
}