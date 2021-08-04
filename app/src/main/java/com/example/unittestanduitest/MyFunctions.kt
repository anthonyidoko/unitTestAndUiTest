package com.example.unittestanduitest

import android.widget.EditText
import android.widget.Spinner

class MyFunctions {
    fun validateName(name: String): Boolean {
        val pattern = Regex("[a-zA-Z]+")

        if (!pattern.containsMatchIn(name) || name.length<2 || name.isEmpty()) {

            return false
        }

        return true

    }

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

    fun validateGender(gender: String) :Boolean{
        return gender == "Male" || gender == "Female" || gender == "Prefer not to say"

    }


    fun validateForm(name: EditText, email : EditText, phoneNumber : EditText,gender :Spinner) :Boolean{
        return (validateName(name.text.toString()) &&
                validateEmail(email.text.toString()) &&
                validatePhoneNumber(phoneNumber.text.toString())&&
                validateGender(gender.selectedItem.toString()))
//        if (!validateName(name.text.toString())){
//            name.requestFocus()
//            name.error = "invalid name"
//            return false
//        } else if (!validateEmail(email.text.toString())){
//            email.requestFocus()
//            email.error = "invalid email"
//            return false
//        } else if (!validatePhoneNumber(phoneNumber.text.toString())){
//            phoneNumber.requestFocus()
//            phoneNumber.error = "invalid phone number"
//            return false
//        } else if(!validateGender(gender.toString())){
//        }
//        return true
    }
}