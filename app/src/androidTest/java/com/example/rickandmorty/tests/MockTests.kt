package com.example.rickandmorty.tests

import androidx.test.core.app.ActivityScenario
import com.example.rickandmorty.mocks.mockCharacterList
import com.example.rickandmorty.mocks.mockCharacterWithId
import com.example.rickandmorty.screens.CharacterDetailScreen
import com.example.rickandmorty.screens.MainScreen
import com.example.rickandmorty.ui.MainActivity
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test

@HiltAndroidTest
class MockTests : BaseTest() {

    @Test
    fun simpleTest1() = run {
        mockCharacterList()
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        mockCharacterWithId("character/1")
        step("Check the character name is displayed on the \'CharacterDetail\' screen") {
            MainScreen {
                actionClickOnTheCharacter("mockWebServer")
            }
            CharacterDetailScreen {
                assertNameIsVisible("mockWebServer")
                actionPressBack()
            }
        }
        mockCharacterWithId("character/3")
        step("Check the character name is displayed on the \'CharacterDetail\' screen") {
            MainScreen {
                actionClickOnTheCharacter("Summer Smith")
            }
            CharacterDetailScreen {
                assertNameIsVisible("Summer Smith")
            }
        }
    }

    @Test
    fun simpleTest2() = run {
        mockCharacterList()
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        mockCharacterWithId("character/7")
        step("Check the character name is displayed on the \'CharacterDetail\' screen") {
            MainScreen {
                actionClickOnTheCharacter("Abradolf Lincler")
            }
            CharacterDetailScreen {
                assertNameIsVisible("Abradolf Lincler")
                actionPressBack()
            }
        }
        mockCharacterWithId("character/10")
        step("Check the character name is displayed on the \'CharacterDetail\' screen") {
            MainScreen {
                actionClickOnTheCharacter("Alan Rails")
            }
            CharacterDetailScreen {
                assertNameIsVisible("Alan Rails")
            }
        }
    }
}