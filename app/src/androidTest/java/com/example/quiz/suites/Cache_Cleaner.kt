package com.example.quiz.suites

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class Cache_Cleaner {

    companion object {
        private lateinit var uiDevice: UiDevice

        @BeforeClass
        @JvmStatic
        fun setUp() {
            uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        }

        @AfterClass
        @JvmStatic
        fun tearDown() {
            // Чистка кэша приложения
            val packageName = InstrumentationRegistry.getInstrumentation().targetContext.packageName
            uiDevice.executeShellCommand("pm clear $packageName")
        }
    }

    @Test
    fun Cache_has_been_clear() {
        // Это просто заглушка, чтобы JUnit не ругался на отсутствие тестов в классе
    }
}
