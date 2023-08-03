package com.example.quiz.suites

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.QUIZ.R
import com.example.quiz.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class Test_HomeFragment {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    // Настройка для тестов
    fun setUp() {
        Intents.init()
        onView(withId(R.id.buttonContinue)).perform(click())
    }

    @Test
    fun visibility_buttons() {
        // Проверяем наличие кнопки "Назад"
        onView(withId(R.id.buttonBack)).check(matches(isDisplayed()))
        // Проверяем наличие кнопки "Отправить"
        onView(withId(R.id.buttonSubmit)).check(matches(isDisplayed()))
    }

    @Test
    fun press_buttons() {
        // Проверяем действия при нажатии кнопок
        onView(withId(R.id.buttonBack)).perform(click()) //перешли на StartFragment
        onView(withId(R.id.main)).check(matches(isDisplayed())) // проверили переход
        onView(withId(R.id.buttonContinue)).perform(click())
        onView(withId(R.id.buttonSubmit)).check(matches(isClickable())) // иначе приложение крашится)
    }

    @Test
    fun text_in_buttons() {
        // Проверяем текст в кнопках
        val buttonTextBack = "Назад"
        onView(withId(R.id.buttonBack)).check(matches(ViewMatchers.withText(buttonTextBack)))

        val buttonTextSend = "Отправить"
        onView(withId(R.id.buttonSubmit)).check(matches(ViewMatchers.withText(buttonTextSend)))
    }

    @Test
    fun window_for_survey() {
        // Проверяем что подготовлен recyclerView для получения опроса в него
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }

    @After
    fun tearDown() {
        // Закрываем Espresso Intents
        Intents.release()
    }
}

