package com.example.quiz

import com.example.quiz.suites.Cache_Cleaner
import com.example.quiz.suites.Test_HomeFragment
import com.example.quiz.suites.Test_StartFragment
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    Test_StartFragment::class,
    Test_HomeFragment::class,
    Cache_Cleaner::class
)

class AllTest
