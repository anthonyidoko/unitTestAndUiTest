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

        val firstName = findViewById<TextView>(R.id.name)
        val phoneNumber = findViewById<TextView>(R.id.phoneNumber)
        val email = findViewById<TextView>(R.id.email)
        val sex = findViewById<TextView>(R.id.sex)
//        val detail = findViewById<TextView>(R.id.detail)

        firstName.text = " First Name: ${intent.getStringExtra("EXTRA_NAME")}"
        phoneNumber.text = " Phone Number: ${intent.getStringExtra("EXTRA_PHONENUMBER")}"
        email.text =  "Email: ${intent.getStringExtra("EXTRA_EMAIL")}"
        sex.text = "SEX: ${intent.getStringExtra("EXTRA_SEX")}"

//        detail.text = """
//            Name : $firstName.
//            Phone Number : $phoneNumber
//            Email : $email
//            Sex : $sex
//        """.trimIndent()
//        detail.text = firstName




    }
}