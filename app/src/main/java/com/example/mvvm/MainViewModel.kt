package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var mPersonRepository = PersonRepository()
    private var mTextWelcome = MutableLiveData<String>();
    private var mToastNotification = MutableLiveData<String>();


    init {
        mTextWelcome.value = "Hello World";
    }

    fun welcome(): LiveData<String> {
        return mTextWelcome
    }

    fun login(): LiveData<String> {
        return mToastNotification
    }

    fun doLogin(email: String) {
        if (this.mPersonRepository.login(email))
            mToastNotification.setValue("Success")
        else
            mToastNotification.setValue("Falha")
    }
}