package com.example.rickandmorty.screens

import android.view.View
import com.example.rickandmorty.R
import com.example.rickandmorty.ui.MainActivity
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object MainScreen : KScreen<MainScreen>() {

    override val layoutId = R.layout.activity_main
    override val viewClass = MainActivity::class.java

    class CharacterItem(parent: Matcher<View>) : KRecyclerItem<CharacterItem>(parent) {
        val name = KTextView(parent) { withId(R.id.name) }
        val speciesAndStatusTextField = KTextView(parent) {
            withId(R.id.species_and_status)
        }
        val image = KImageView(parent) { withId(R.id.image) }
    }

    private val characterRecycleView = KRecyclerView({
        withId(R.id.characters_rv)
    }, itemTypeBuilder = {
        itemType(::CharacterItem)
    })

    fun actionClickOnTheCharacterByName(characterName: String) {
        characterRecycleView {
            childWith<CharacterItem> {
                withDescendant { withText(characterName) }
            } perform {
                name.click()
            }
        }
    }

    fun actionClickOnTheCharacterAtPosition(elementPosition: Int) {
        characterRecycleView {
            childAt<CharacterItem>(elementPosition) {
                name.click()
            }
        }
    }

    fun assertTheCharacterHasSpeciesAndStatusByName(
        characterName: String,
        speciesAndStatus: String
    ) {
        characterRecycleView {
            childWith<CharacterItem> {
                withDescendant { withText(characterName) }
            } perform {
                speciesAndStatusTextField.hasText(speciesAndStatus)
            }
        }
    }

    fun assertTheCharacterHasNameAtPosition(elementPosition: Int, characterName: String) {
        characterRecycleView {
            childAt<CharacterItem>(elementPosition) {
                name.hasText(characterName)
            }
        }
    }

    fun assertTheCharacterHasSpeciesAndStatusAtPosition(
        elementPosition: Int,
        speciesAndStatus: String
    ) {
        characterRecycleView {
            childAt<CharacterItem>(elementPosition) {
                speciesAndStatusTextField.hasText(speciesAndStatus)
            }
        }
    }
}