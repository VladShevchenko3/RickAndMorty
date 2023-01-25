package com.example.rickandmorty.tests

import androidx.test.core.app.ActivityScenario
import com.example.rickandmorty.mocks.mockCharacterList
import com.example.rickandmorty.mocks.mockCharacterWithId
import com.example.rickandmorty.screens.CharacterDetailScreen
import com.example.rickandmorty.screens.MainScreen
import com.example.rickandmorty.tests.DataForTests.getCharacterDataInTheList
import com.example.rickandmorty.tests.DataForTests.getCharacterDetails
import com.example.rickandmorty.ui.MainActivity
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test

@HiltAndroidTest
class MockTests : BaseTest() {

    @Test
    fun checkCharacterDescriptionByName() = run {
        mockCharacterList()
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        val characterDescriptionData = getCharacterDataInTheList(1)
        step("Check the character species and status are displayed on the \'Main\' screen") {
            MainScreen {
                assertTheCharacterHasSpeciesAndStatusByName(
                    characterDescriptionData["name"].toString(),
                    characterDescriptionData["speciesAndStatus"].toString()
                )
            }
        }
    }

    @Test
    fun checkCharacterDescriptionAtPosition() = run {
        mockCharacterList()
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        val characterDescriptionData = getCharacterDataInTheList(9)
        step("Check the character name, species and status are displayed at position 8 on the \'Main\' screen") {
            MainScreen {
                assertTheCharacterHasNameAtPosition(8, characterDescriptionData["name"].toString())
                assertTheCharacterHasSpeciesAndStatusAtPosition(
                    8,
                    characterDescriptionData["speciesAndStatus"].toString()
                )
            }
        }
    }

    @Test
    fun checkCharacterDetailsByName() = run {
        mockCharacterList()
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        mockCharacterWithId("character/3")
        val characterDescriptionData = getCharacterDataInTheList(3)
        val characterDetailsData = getCharacterDetails(3)
        step("Check the character details are displayed on the \'CharacterDetail\' screen") {
            MainScreen {
                actionClickOnTheCharacterByName(characterDescriptionData["name"].toString())
            }
            CharacterDetailScreen {
                assertNameIsDisplayed(characterDetailsData["name"].toString())
                assertSpeciesIsDisplayed(characterDetailsData["species"].toString())
                assertStatusIsDisplayed(characterDetailsData["status"].toString())
                assertGenderIsDisplayed(characterDetailsData["gender"].toString())
            }
        }
    }

    @Test
    fun checkCharacterDetailsAtPosition() = run {
        mockCharacterList()
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
        mockCharacterWithId("character/8")
        val characterDescriptionData = getCharacterDataInTheList(8)
        val characterDetailsData = getCharacterDetails(8)
        step("Check the character details are displayed on the \'CharacterDetail\' screen") {
            MainScreen {
                actionClickOnTheCharacterAtPosition(7)
            }
            CharacterDetailScreen {
                assertNameIsDisplayed(characterDetailsData["name"].toString())
                assertSpeciesIsDisplayed(characterDetailsData["species"].toString())
                assertStatusIsDisplayed(characterDetailsData["status"].toString())
                assertGenderIsDisplayed(characterDetailsData["gender"].toString())
            }
        }
    }
}