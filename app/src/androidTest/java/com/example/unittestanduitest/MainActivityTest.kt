package com.example.unittestanduitest

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    private lateinit var name: String
    private lateinit var email: String
    private lateinit var phoneNumber: String
    private lateinit var gender: String

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        // Specify a valid string.
        name = "idoko Anthony"
        phoneNumber = "08131200462"
        email = "anthony.idoko@decagon.dev"
        gender = "Male"
    }


    fun check_if_views_are_displayed(){
    }

    @Test
    fun verify_singup_successful(){
        onView(withId(R.id.firstName)).perform(typeText(name), closeSoftKeyboard())
        onView(withId(R.id.phoneNumber)).perform(typeText(phoneNumber), closeSoftKeyboard())
        onView(withId(R.id.email)).perform(typeText(email), closeSoftKeyboard())
        onView(withId(R.id.mySpinner)).perform(click())
    }

    @Test
    fun verify_data_passed_to_profile_page(){

        onView(withId(R.id.firstName)).perform(typeText(name), closeSoftKeyboard())
        onView(withId(R.id.phoneNumber)).perform(typeText(phoneNumber), closeSoftKeyboard())
        onView(withId(R.id.email)).perform(typeText(email), closeSoftKeyboard())
        onView(withId(R.id.mySpinner)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`(gender))).perform(click())
        onView(withId(R.id.btnRegister)).perform(click())

        onView(withId(R.id.receivedName))
        onView(withId(R.id.receivedNumber))
        onView(withId(R.id.receivedEmail))
        onView(withId(R.id.receivedSex))


    }
}