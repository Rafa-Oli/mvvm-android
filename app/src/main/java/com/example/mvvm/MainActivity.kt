package com.example.mvvm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mMainViewModel: MainViewModel by viewModels();
    private lateinit var mContext: Context
    private lateinit var editName: TextView
    private lateinit var buttonLogin: TextView
    private lateinit var textWelcome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textWelcome = findViewById<TextView>(R.id.textWelcome)
        buttonLogin = findViewById<TextView>(R.id.buttonLogin);
        editName = findViewById<TextView>(R.id.editName);
        this.mContext = this


        buttonLogin.setOnClickListener(this)

        this.createObservers()
    }


    override fun onClick(view: View?) {
        val name = editName.text.toString()
        this.mMainViewModel.doLogin(name)
    }

    private fun createObservers() {
        mMainViewModel.welcome().observe(this, Observer {
            textWelcome.text = it
        });

        mMainViewModel.login().observe(this, Observer {
            Toast.makeText(mContext, it, Toast.LENGTH_SHORT).show()
        });
    }
}