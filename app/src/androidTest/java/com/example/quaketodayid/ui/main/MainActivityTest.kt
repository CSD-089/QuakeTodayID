package com.example.quaketodayid.ui.main

import android.view.Gravity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.quaketodayid.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun shouldNewQuakeInfoVisible() {
        onView(withId(R.id.nav_terbaru)).perform(click())
        onView(withId(R.id.fragment_terbaru)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldNewQuakeInfoListVisible() {
        onView(withId(R.id.nav_terkini)).perform(click())
        onView(withId(R.id.fragment_terkini)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldFeelsQuakeVisible() {
        onView(withId(R.id.nav_dirasakan)).perform(click())
        onView(withId(R.id.fragment_dirasakan)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldDrawerToDashboardWorks() {
        onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
            .perform(DrawerActions.open()) // Open Drawer

        onView(withId(R.id.nav_view))
            .perform(NavigationViewActions.navigateTo(R.id.nav_home))

        onView(withId(R.id.fragment_dashboard)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldDrawerToSettingsWorks() {
        onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
            .perform(DrawerActions.open()) // Open Drawer

        onView(withId(R.id.nav_view))
            .perform(NavigationViewActions.navigateTo(R.id.nav_settings))

        onView(withId(R.id.fragment_settings)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldDrawerToAboutWorks() {
        onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
            .perform(DrawerActions.open()) // Open Drawer

        onView(withId(R.id.nav_view))
            .perform(NavigationViewActions.navigateTo(R.id.nav_about))

        onView(withId(R.id.fragment_about)).check(matches(isDisplayed()))
    }
}