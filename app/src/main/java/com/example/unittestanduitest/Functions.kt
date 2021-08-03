package com.example.unittestanduitest

import android.widget.EditText



fun validateName(name : EditText) :Boolean{
    val pattern = Regex("[a-zA-Z]+")

    if (!pattern.containsMatchIn(name.text)){
        name.requestFocus()
        name.error = "Only alphabets are valid input"
        return false
    }
    else if (name.text.isEmpty()){
        name.requestFocus()
        name.error = "This field cannot be empty"
        return false
    }

    return true

}

fun validateEmail(email : EditText) :Boolean{
    val secondPattern = Regex("^[a-zA-Z0-9_.-]+ @[a-zA-Z]\\.[a-zA-Z]{2,5}")
    val pattern = Regex("/^([a-z0-9_.-]+)@([\\da-z.-]+)\\.([a-z.]{2,5})\$/")

    if (!pattern.containsMatchIn(email.text)){
        email.requestFocus()
        email.error = "invalid email input"
        return false
    }
    return true
}

fun validatePhoneNumber(number : EditText) :Boolean{
    val pattern = Regex("^(080||081||070||090||2348||2347)[1-9]+")
    return if (number.length() != 11 && !pattern.containsMatchIn(number.text)){
        number.requestFocus()
        number.error = "Invalid phone number"
        false
    } else{
        true
    }
}