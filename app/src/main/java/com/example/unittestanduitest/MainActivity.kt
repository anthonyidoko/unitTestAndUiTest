package com.example.unittestanduitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstName = findViewById<EditText>(R.id.firstName)
        val phoneNumber = findViewById<EditText>(R.id.phoneNumber)
        val email = findViewById<EditText>(R.id.email)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val spinner : Spinner = findViewById(R.id.mySpinner)
//        val spinnerText = findViewById<TextView>(R.id.spinnerText)
        val functions = MyFunctions()

        ArrayAdapter.createFromResource(
            this,R.array.sex,R.layout.support_simple_spinner_dropdown_item
        ).also {

                adapter ->  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter

        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                parent?.getItemAtPosition(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinner.onItemSelectedListener = this
            }

        }

        btnRegister.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)

            if (
                functions.validateForm(firstName,email,phoneNumber,spinner)
            ) {
                intent.putExtra("EXTRA_NAME", firstName.text.toString())
                intent.putExtra("EXTRA_EMAIL", email.text.toString())
                intent.putExtra("EXTRA_PHONE_NUMBER", phoneNumber.text.toString())
                intent.putExtra("EXTRA_SEX", spinner.selectedItem.toString())
                startActivity(intent)
            }else if(!functions.validateName(firstName.text.toString())){
                firstName.requestFocus()
                firstName.error = "invalid name input"
            } else if (!functions.validatePhoneNumber(phoneNumber.text.toString())){
                phoneNumber.requestFocus()
                phoneNumber.error = "invalid phone number"
            } else if(!functions.validateEmail(email.text.toString())){
                email.requestFocus()
                email.error = "invalid email"
            } else if(!functions.validateGender(spinner.selectedItem.toString())){
                Toast.makeText(this,"Invalid gender input", Toast.LENGTH_LONG)
//                spinnerText.requestFocus()
//                spinnerText.visibility = View.VISIBLE

            }

        }

    }

}
