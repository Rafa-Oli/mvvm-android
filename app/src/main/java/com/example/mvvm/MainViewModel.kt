package com.example.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    private var mTextWelcome = MutableLiveData<String>();
    var textWelcome = mTextWelcome

}