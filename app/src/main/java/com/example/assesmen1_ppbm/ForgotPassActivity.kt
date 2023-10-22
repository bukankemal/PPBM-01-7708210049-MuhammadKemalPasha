package com.example.assesmen1_ppbm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ForgotPassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)

        val btnNextPage = findViewById<Button>(R.id.send_code)
        btnNextPage.setOnClickListener{
            val _intent = Intent(this, MainActivity::class.java)
            startActivity(_intent)
        }
    }
}