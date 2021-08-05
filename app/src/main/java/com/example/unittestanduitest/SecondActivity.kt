package com.example.unittestanduitest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val firstName = findViewById<TextView>(R.id.receivedName)
        val phoneNumber = findViewById<TextView>(R.id.receivedNumber)
        val email = findViewById<TextView>(R.id.receivedEmail)
        val sex = findViewById<TextView>(R.id.receivedSex)

        firstName.text = "FULL NAME:   ${intent.getStringExtra("EXTRA_NAME")}"
        phoneNumber.text = "PHONE NUMBER:   ${intent.getStringExtra("EXTRA_PHONE_NUMBER")}"
        email.text =  "EMAIL:   ${intent.getStringExtra("EXTRA_EMAIL")}"
        sex.text = "SEX:   ${intent.getStringExtra("EXTRA_SEX")}"





    }
}