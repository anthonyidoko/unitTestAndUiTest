package com.example.unittestanduitest

import android.widget.EditText
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class MyFunctionsTest {
    private lateinit var myFunctions :MyFunctions

    @Before
    fun setUp(){
        myFunctions = MyFunctions()
    }

    //Test for valid name input
    @Test
    fun nameProperlyInputed_returns_true() {
        val checker = myFunctions.validateName("anthony idoko")
        assertEquals(true, checker)
    }

    //Test for empty input
    @Test
    fun empty_nameValue_input_returns_false() {
        val checker = myFunctions.validateName("")
        assertEquals(false, checker)
    }

    //Test for length of name
    @Test
    fun nameValueLessThanTwo_returns_false() {
        val checker = myFunctions.validateName("a")
        assertEquals(false, checker)
    }

    //Test for integers
    @Test
    fun passIntegerAsNameValue_returns_false() {
        val checker = myFunctions.validateName("100")
        assertEquals(false, checker)
    }

    //Test for special characters
    @Test
    fun passSpecialCharacterAsNameValue_returns_false() {
        val checker = myFunctions.validateName("./?")
        assertEquals(false, checker)
    }


    //EMAIL VALIDATION

    //Test valid email input
    @Test
    fun validEmail_returnsTrue() {
        val email = myFunctions.validateEmail("anthony.idoko@decagon.dev")
        assertEquals(true,email)
    }

    //Test email input without @ symbol
    @Test
    fun emailInputWithoutAtSymbol_returnsFalse() {
        val email = myFunctions.validateEmail("anthony.idokodecagon.dev")
        assertEquals(false,email)
    }

    //Test email input without . symbol
    @Test
    fun emailInputWithoutdotSymbol_returnsFalse() {
        val email = myFunctions.validateEmail("anthonyidoko@decagondev")
        assertEquals(false,email)
    }

    //Test email input without .domain name
    @Test
    fun emailInputWithoutdotDomainName_returnsFalse() {
        val email = myFunctions.validateEmail("anthony.idoko@decagon")
        assertEquals(false,email)
    }


    //PHONE NUMBER VALIDATION

    //Valid phone number starting with 0
    @Test
    fun validPhoneNumberStartingWith0ReturnsTrue() {
        val phoneNumber = myFunctions.validatePhoneNumber("08131200463")
        assertEquals(true,phoneNumber)
    }

    //Valid phone number starting with 0 returns true
    @Test
    fun validPhoneNumberStartingWith234_returnsTrue() {
        val phoneNumber = myFunctions.validatePhoneNumber("2348131200463")
        assertEquals(true,phoneNumber)
    }

    //Phone number starting with 0 and with length more than 11
    @Test
    fun validPhoneNumberStartingWith0AndWithLengthMoreThan11_returnsFalse() {
        val phoneNumber = myFunctions.validatePhoneNumber("0813120048863")
        assertEquals(false,phoneNumber)
    }

    //Phone number starting with 0 and with length more than 11
    @Test
    fun validPhoneNumberStartingWith0AndWithLengthMoreLessThan11_returnsFalse() {
        val phoneNumber = myFunctions.validatePhoneNumber("081312003")
        assertEquals(false,phoneNumber)
    }

    //Phone number starting with 0 and with length more than 11
    @Test
    fun validPhoneNumberStartingWith234AndWithLengthMoreThan13_returnsFalse() {
        val phoneNumber = myFunctions.validatePhoneNumber("2348131200463877")
        assertEquals(false,phoneNumber)
    }

    //Phone number starting with 0 and with length more than 11
    @Test
    fun validPhoneNumberStartingWith234AndWithLengthLessThan13_returnsFalse() {
        val phoneNumber = myFunctions.validatePhoneNumber("2348131877")
        assertEquals(false,phoneNumber)
    }

    //Phone number starting with 0 with length 11 but containing an alphabet
    @Test
    fun phoneNumberStartingWith0WithLength11ButContainsAlphabet_returnsFalse() {
        val phoneNumber = myFunctions.validatePhoneNumber("2348131877o87")
        assertEquals(false,phoneNumber)
    }

    //Phone number starting with 234 with length 13 but containing an alphabet
    @Test
    fun phoneNumberStartingWith234WithLength13ButContainsAlphabet_returnsFalse() {
        val phoneNumber = myFunctions.validatePhoneNumber("2348131877o8799")
        assertEquals(false,phoneNumber)
    }

    //Phone number with empty field
    @Test
    fun phoneNumberWithEmptyValue_returnsFalse() {
        val phoneNumber = myFunctions.validatePhoneNumber("")
        assertEquals(false,phoneNumber)
    }

    //Phone number with string values
    @Test
    fun phoneNumberWithStringValues_returnsFalse() {
        val phoneNumber = myFunctions.validatePhoneNumber("ggdhdgfggf")
        assertEquals(false,phoneNumber)
    }

    //Phone number with special characters
    @Test
    fun phoneNumberWithSpecialCharacter_returnsFalse() {
        val phoneNumber = myFunctions.validatePhoneNumber("08131200.63")
        assertEquals(false,phoneNumber)
    }

    //TESTS FOR GENDER VALIDATION

    //When gender is empty
    @Test
    fun emptyValuePassed_returnsFalse(){
        val result = myFunctions.validateGender("")
        assertEquals(false,result)
    }

    //When gender is the default Gender
    @Test
    fun GenderValuePassedIsTheDefault_returnsFalse(){
        val result = myFunctions.validateGender("Gender")
        assertEquals(false,result)
    }

    //When gender is the default a correct gender
    @Test
    fun GenderValuePassedIsValidGender_returnsTrue(){
        val result = myFunctions.validateGender("Male")
        assertEquals(true,result)
    }
}