package com.example.unittestanduitest

import android.widget.EditText


fun validateName(name : String) :Boolean{
    val pattern = Regex("[a-zA-Z]+")

    if (!pattern.containsMatchIn(name)){

        return false
    }
    else if (name.isEmpty()){

        return false
    }

    return true

}

fun validateEmail(email : String) :Boolean{
    val secondPattern = Regex("^[a-zA-Z0-9_.-]+ @[a-zA-Z]\\.[a-zA-Z]{2,5}")
    val pattern = Regex("/^([a-z0-9_.-]+)@([\\da-z.-]+)\\.([a-z.]{2,5})\$/")

    if (!pattern.containsMatchIn(email)){
//        email.requestFocus()
//        email.error = "invalid email input"
        return false
    }
    return true
}

fun validatePhoneNumber(number : String) :Boolean{
    val pattern = Regex("^(080||081||070||090||2348||2347)[1-9]+")
    return !(number.length != 11 && !pattern.containsMatchIn(number))
}

fun validateForm(name:EditText,email :EditText,phoneNumber :EditText) :Boolean{
    if (!validateName(name.text.toString())){
        name.requestFocus()
        name.error = "invalid name"
        return false
    } else if (!validateEmail(email.text.toString())){
        email.requestFocus()
        email.error = "invalid email"
        return false
    } else if (!validatePhoneNumber(phoneNumber.text.toString())){
        phoneNumber.requestFocus()
        phoneNumber.error = "invalid phone number"
        return false
    }
    return true
}