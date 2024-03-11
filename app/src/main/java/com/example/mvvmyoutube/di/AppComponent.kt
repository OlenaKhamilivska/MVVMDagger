package com.example.mvvmyoutube.di

import com.example.mvvmyoutube.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {

    fun inject (mainActivity: MainActivity)
}