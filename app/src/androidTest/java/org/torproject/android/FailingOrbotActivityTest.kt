package org.torproject.android


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class FailingOrbotActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(OrbotActivity::class.java)

    @Test
    fun failingOrbotActivityTest() {
        val textView = onView(
allOf(withId(R.id.tvConfigure), withText("CONFIGURE"),
withParent(withParent(withId(R.id.drawerLayout))),
isDisplayed()))
        textView.check(matches(withText("Text that doesn't exist so test will fail.")))
        }
    }
