package com.example.mvvmyoutube.di

import android.content.Context
import dagger.Module
import dagger.Provides
import data.repository.UserRepositoryImpl
import data.storage.SharedPrefUserStorage
import data.storage.UserStorage
import domain.repository.UserRepository

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl (userStorage = userStorage)
    }
}