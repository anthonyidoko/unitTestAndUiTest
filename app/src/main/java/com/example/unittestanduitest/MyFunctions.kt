package com.example.unittestanduitest

import android.widget.EditText
import android.widget.Spinner

class MyFunctions {

    //Validate name input
    fun validateName(name: String): Boolean {
        val pattern = Regex("[a-zA-Z]+")

        if (!pattern.containsMatchIn(name) || name.length<2 || name.isEmpty()) {

            return false
        }

        return true

    }


    //Email Validation
    fun validateEmail(email: String): Boolean {
        val emailPattern = Regex(
            "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*" +
                    "|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[" +
                    "\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])" +
                    "?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9]"+
                    "[0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:"+
                    "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\" +
                    "x0b\\x0c\\x0e-\\x7f])+)\\])")

        if (!emailPattern.containsMatchIn(email)) {

            return false
        } else if(email.isEmpty()){

            return false
        }
        return true
    }


    //Validate Phone Number
    fun validatePhoneNumber(number: String): Boolean {
        val pattern = Regex("^(080||081||070||090||2348||2347)[1-9]+")
        val wrongPattern = Regex("[a-zA-Z]+")
        val specialCharacters = Regex("[.!#@$%^&*()_+=>.,<]")
        if (pattern.containsMatchIn(number) && !wrongPattern.containsMatchIn(number) && !specialCharacters.containsMatchIn(number)) {
            return ((number.startsWith("080") ||
                    number.startsWith("081") ||
                    number.startsWith("071") ||
                    number.startsWith("090") ||
                    number.startsWith("070") ||
                    number.startsWith("091")) &&
                    number.length==11) ||
                    ((number.startsWith("2347")||
                    (number.startsWith("2348"))) && number.length==13)

        } else if (number.isEmpty()) {

            return false
        }else{
            return false
        }
    }


    //Validate gender
    fun validateGender(gender: String) :Boolean{
        return gender == "Male" || gender == "Female" || gender == "Prefer not to say"

    }


    //Validate the entire form field
    fun validateForm(name: String, email : String,
                     phoneNumber : String,gender :String) :Boolean{
        return (validateName(name) &&
                validateEmail(email) &&
                validatePhoneNumber(phoneNumber)&&
                validateGender(gender))

    }
}