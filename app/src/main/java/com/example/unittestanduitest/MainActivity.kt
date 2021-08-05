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

        //Create reference for the various views in the layout
        val firstName = findViewById<EditText>(R.id.name)
        val phoneNumber = findViewById<EditText>(R.id.phoneNumber)
        val email = findViewById<EditText>(R.id.email)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val spinner : Spinner = findViewById(R.id.mySpinner)
        val hiddenTextView:TextView = findViewById(R.id.hiddenTextView)

        //create an object of MyFunctions class
        val functions = MyFunctions()

        //Spinner adapter
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


        //Click listener for button
        btnRegister.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)

            if (
                functions.validateForm(
                    firstName.text.toString(),
                    email.text.toString(),
                    phoneNumber.text.toString(),
                    spinner.selectedItem.toString()
                )
            ) {
                intent.putExtra("EXTRA_NAME", firstName.text.toString())
                intent.putExtra("EXTRA_EMAIL", email.text.toString())
                intent.putExtra("EXTRA_PHONE_NUMBER", phoneNumber.text.toString())
                intent.putExtra("EXTRA_SEX", spinner.selectedItem.toString())
                startActivity(intent)
            }else if(
                //All fields are empty
                !functions.validateName(firstName.text.toString()) &&
                !functions.validatePhoneNumber(phoneNumber.text.toString()) &&
                !functions.validateEmail(email.text.toString()) &&
                !functions.validateGender(spinner.selectedItem.toString())
            ){
                firstName.requestFocus()
                firstName.error = "invalid name input"
                phoneNumber.requestFocus()
                phoneNumber.error = "invalid phone number"
                email.requestFocus()
                email.error = "invalid email"
                hiddenTextView.requestFocus()
                hiddenTextView.visibility = View.VISIBLE
            }else if(!functions.validateName(firstName.text.toString())){
                //The name field is empty
                firstName.requestFocus()
                firstName.error = "invalid name input"
            } else if (!functions.validatePhoneNumber(phoneNumber.text.toString())){
                //Phone number field is empty
                phoneNumber.requestFocus()
                phoneNumber.error = "invalid phone number"
            } else if(!functions.validateEmail(email.text.toString())){
                //Email is empty
                email.requestFocus()
                email.error = "invalid email"
            } else if(spinner.selectedItem.toString() == "Gender"){
                //Gender is empty
                hiddenTextView.requestFocus()
                hiddenTextView.visibility = View.VISIBLE


            }

        }

    }

}
