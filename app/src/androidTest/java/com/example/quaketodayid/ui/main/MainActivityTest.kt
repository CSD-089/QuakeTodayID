package com.example.quaketodayid.ui.main

import android.view.Gravity
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.quaketodayid.R
import com.example.quaketodayid.data.model.GempaItem
import com.example.quaketodayid.di.NetworkModule
import com.example.quaketodayid.ui.detail.DetailGempaActivity
import com.example.quaketodayid.ui.shakemap.ShakeMapViewActivity
import com.example.quaketodayid.utils.IdlingResources
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        IdlingRegistry.getInstance().register(IdlingResources.getIdlingResource())
        Intents.init()
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(IdlingResources.getIdlingResource())
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
        onView(withId(R.id.recycler_view)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(QUAKE_COUNT)
        )
    }

    @Test
    fun shouldFeelsQuakeListVisible() {
        onView(withId(R.id.nav_dirasakan)).perform(click())
        onView(withId(R.id.fragment_dirasakan)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_view)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(QUAKE_COUNT)
        )
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

    @Test
    fun shouldNewQuakeInfoValid() {
        val networkQuake = getValidLastQuakeInfo()
        assertNotNull(networkQuake.magnitude)
        assertNotNull(networkQuake.wilayah)
        assertNotNull(networkQuake.tanggal)
        assertNotNull(networkQuake.jam)
        assertNotNull(networkQuake.kedalaman)
        assertNotNull(networkQuake.dirasakan)
        assertNotNull(networkQuake.potensi)

        onView(withId(R.id.nav_terbaru)).perform(click())

        onView(withId(R.id.tv_new_magnitude)).check(matches(withText("${networkQuake.magnitude}SR")))
        onView(withId(R.id.tv_new_location)).check(matches(withText(networkQuake.wilayah)))
        onView(withId(R.id.tv_new_datetime)).check(matches(withText("${networkQuake.tanggal} ${networkQuake.jam}")))
        onView(withId(R.id.tv_new_depth)).check(matches(withText(networkQuake.kedalaman)))
        onView(withId(R.id.tv_new_feels)).check(matches(withText(networkQuake.dirasakan)))
        onView(withId(R.id.tv_new_potency)).check(matches(withText(networkQuake.potensi)))

        onView(withId(R.id.btn_show_shake_map)).perform(click())
        intended(hasComponent(ShakeMapViewActivity::class.java.name))
        onView(withId(R.id.tiv_shake_map)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldNewQuakeListValid() {
        onView(withId(R.id.nav_terkini)).perform(click())
        onView(withId(R.id.recycler_view)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        intended(hasComponent(DetailGempaActivity::class.java.name))

        onView(withId(R.id.mapView)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_details_magnitude)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_details_date_time)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_details_location)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_details_coordinate)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_details_depth)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_details_potency)).check(matches(not(withText(""))))
    }

    @Test
    fun shouldFeelsQuakeListValid() {
        onView(withId(R.id.nav_dirasakan)).perform(click())
        onView(withId(R.id.recycler_view)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(QUAKE_COUNT)
        )
        onView(withId(R.id.recycler_view)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        intended(hasComponent(DetailGempaActivity::class.java.name))

        onView(withId(R.id.mapView)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_details_magnitude)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_details_date_time)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_details_location)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_details_coordinate)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_details_depth)).check(matches(not(withText(""))))
        onView(withId(R.id.tv_details_feel)).check(matches(not(withText(""))))
    }

    private fun getValidLastQuakeInfo(): GempaItem {
        return try {
            val api = NetworkModule.provideRetrofitService()
            val call = api.getAutoGempa()
            val response = call.execute()
            val responseBody = response.body()!!

            responseBody.infogempa!!.gempa!!
        } catch (e: Exception) {
            e.printStackTrace()
            GempaItem()
        }
    }

    companion object {
        private const val QUAKE_COUNT = 15
    }
}