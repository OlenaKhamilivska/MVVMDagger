package com.example.mvvmyoutube.di

import dagger.Module
import dagger.Provides
import domain.repository.UserRepository
import domain.usecases.GetUserNameUseCase
import domain.usecases.SaveUserNameUseCase

//new
@Module
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository = userRepository)
    }
}