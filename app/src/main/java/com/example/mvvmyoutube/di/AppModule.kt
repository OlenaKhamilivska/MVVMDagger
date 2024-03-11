package com.example.mvvmyoutube.di

import android.content.Context
import com.example.mvvmyoutube.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides
import domain.usecases.GetUserNameUseCase
import domain.usecases.SaveUserNameUseCase

@Module
class AppModule (val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }
    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase)
    }
}