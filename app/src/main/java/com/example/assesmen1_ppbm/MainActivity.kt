package com.example.assesmen1_ppbm

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNextPage = findViewById<Button>(R.id.reg_mainmenu)
        val btnLogIn = findViewById<Button>(R.id.log_mainmenu)
        val forgotPass = findViewById<TextView>(R.id.forgot_pass)
        btnNextPage.setOnClickListener{
            val _intent = Intent(this, RegisterActivity::class.java)
            startActivity(_intent)
        }

        btnLogIn.setOnClickListener {
            val _intent = Intent(this, DashboardActivity::class.java)
            startActivity(_intent)
        }

        forgotPass.setOnClickListener {
            val _intent = Intent(this, ForgotPassActivity::class.java)
            startActivity(_intent)
        }



    }
}