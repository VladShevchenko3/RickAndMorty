package com.example.rickandmorty.screens

import com.example.rickandmorty.R
import com.example.rickandmorty.ui.MainActivity
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView

object CharacterDetailScreen : KScreen<CharacterDetailScreen>() {

    override val layoutId = R.layout.character_detail_fragment
    override val viewClass = MainActivity::class.java

    private val name = KTextView { withId(R.id.name) }
    private val species = KTextView { withId(R.id.species) }
    private val status = KTextView { withId(R.id.status) }
    private val gender = KTextView { withId(R.id.gender) }

    fun actionPressBack() {
        pressBack()
    }

    fun assertNameIsDisplayed(text: String) {
        name {
            isDisplayed()
            hasText(text)
        }
    }

    fun assertStatusIsDisplayed(text: String) {
        status {
            isDisplayed()
            hasText(text)
        }
    }

    fun assertSpeciesIsDisplayed(text: String) {
        species {
            isDisplayed()
            hasText(text)
        }
    }

    fun assertGenderIsDisplayed(text: String) {
        gender {
            isDisplayed()
            hasText(text)
        }
    }
}