package com.example.mvvmyoutube.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmyoutube.R
import com.example.mvvmyoutube.app.App
import data.repository.UserRepositoryImpl
import data.storage.SharedPrefUserStorage
import domain.usecases.GetUserNameUseCase
import domain.usecases.SaveUserNameUseCase
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

//    private val userStorage by lazy {
//        SharedPrefUserStorage(applicationContext)
//    }
//    private val userRepository by lazy (LazyThreadSafetyMode.NONE) {
//        UserRepositoryImpl(userStorage)
//    }
    @Inject
    lateinit var vmFactory: MainViewModelFactory
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)

        Log.e("AAA", "Activity created")
        //here we create MainViewModelFactory, which allows us tell how must be created ViewModel
        vm = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val sendButton = findViewById<TextView>(R.id.sendButton)
        val dataEditView = findViewById<TextView>(R.id.dataEditView)
        val receiveButton = findViewById<TextView>(R.id.receiveButton)

        //observing on changing data
        vm.resultLive.observe(this, Observer { text->
            dataTextView.text = text
        })
        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            vm.save(text)
        }

        receiveButton.setOnClickListener{
            vm.load()
        }
    }
}