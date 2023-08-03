package com.example.quiz.suites

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import com.example.QUIZ.R
import com.example.quiz.resTest.EspressoMatchers
import com.example.quiz.MainActivity


class Test_StartFragment {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun openStartFragment() {
        // Проверяю открытие start_fragment
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun fillingStartFragment() {
        // Проверяю наличие картинки на стартовом фрагменте
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))

        // Проверяю наличие кнопки на стартовом фрагменте
        onView(withId(R.id.buttonContinue)).check(matches(isDisplayed()))
    }

    @Test
    fun imageSize() {
        // Проверяю, что картинка имеет layout_width и layout_height установленные в wrap_content
        onView(withId(R.id.imageView)).check(matches(EspressoMatchers.withWrapContent()))
    }

    @Test
    fun imageCentering(){
        // Проверяю, что картинка расположена по центру
        onView(withId(R.id.imageView)).check(matches(EspressoMatchers.isCentered()))
    }

    @Test
    fun buttonText() {
        // Проверяю текст в кнопке
        val buttonText = "Начать"
        onView(withId(R.id.buttonContinue)).check(matches(withText(buttonText)))
    }
}