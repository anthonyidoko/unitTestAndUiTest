package com.example.unittestanduitest

import android.widget.EditText

class MyFunctions {
    fun validateName(name: EditText): Boolean {
        val pattern = Regex("[a-zA-Z]+")

        if (!pattern.containsMatchIn(name.text)) {
            name.requestFocus()
            name.error = "Only alphabets are valid input"
            return false
        } else if (name.text.isEmpty()) {
            name.requestFocus()
            name.error = "This field cannot be empty"
            return false
        }

        return true

    }

    fun validateEmail(email: EditText): Boolean {
        val emailPattern = Regex(
            "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*" +
                    "|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[" +
                    "\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])" +
                    "?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9]"+
                    "[0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:"+
                    "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\" +
                    "x0b\\x0c\\x0e-\\x7f])+)\\])")

        if (!emailPattern.containsMatchIn(email.text)) {
            email.requestFocus()
            email.error = "invalid email input"
            return false
        } else if(email.text.isEmpty()){
            email.requestFocus()
            email.error = "email field cannot be blank"
            return false
        }
        return true
    }

    fun validatePhoneNumber(number: EditText): Boolean {
        val pattern = Regex("^(080||081||070||090||2348||2347)[1-9]+")
        if (pattern.containsMatchIn(number.text)) {
            if ((number.text.startsWith("080")|| number.text.startsWith("081")||
                    number.text.startsWith("070")||number.text.startsWith("090")) &&
                    number.text.length==11){
                return true
            } else return number.text.length == 13

        } else{
            number.requestFocus()
            number.error = "Invalid mobile number"
            return false
        }
    }
}