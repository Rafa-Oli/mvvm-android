package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.textWelcome)
        val buttonLogin = findViewById<TextView>(R.id.buttonLogin);
        val editName = findViewById<TextView>(R.id.editName);

        viewModel.textWelcome.observe(this, Observer {
            text.text = it
        });

        viewModel.login.observe(this, Observer {
            if (it) {
                Toast.makeText(this, "Sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Falha!", Toast.LENGTH_SHORT).show()
            }
        });

        buttonLogin.setOnClickListener {
            var login = editName.text.toString()
            viewModel.login(login)
        }
    }
}