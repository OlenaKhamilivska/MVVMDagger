package com.example.mvvmyoutube.app

import android.app.Application
import com.example.mvvmyoutube.di.AppComponent
import com.example.mvvmyoutube.di.AppModule
import com.example.mvvmyoutube.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}