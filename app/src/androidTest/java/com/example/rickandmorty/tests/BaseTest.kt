package com.example.rickandmorty.tests

import androidx.test.core.app.ActivityScenario
import com.example.rickandmorty.mocks.MockDispatcher
import com.example.rickandmorty.mocks.MockDispatcher.Companion.requestResponseList
import com.example.rickandmorty.ui.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import dagger.hilt.android.testing.HiltAndroidRule
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule

open class BaseTest : TestCase() {

    @get:Rule
    var hilt = HiltAndroidRule(this)

    lateinit var activityScenario: ActivityScenario<MainActivity>
    lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        hilt.inject()
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = MockDispatcher()
        mockWebServer.start(9090)
    }

    @After
    fun tearDown() {
        requestResponseList.clear()
        mockWebServer.shutdown()
        activityScenario.close()
    }
}