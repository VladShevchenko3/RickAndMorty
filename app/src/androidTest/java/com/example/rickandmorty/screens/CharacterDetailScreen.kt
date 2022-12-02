package com.example.rickandmorty.screens

import com.example.rickandmorty.R
import com.example.rickandmorty.ui.MainActivity
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView

object CharacterDetailScreen : KScreen<CharacterDetailScreen>() {

    override val layoutId = R.layout.character_detail_fragment
    override val viewClass = MainActivity::class.java

    private val name = KTextView { withId(R.id.name) }

    fun actionPressBack() {
        pressBack()
    }

    fun assertNameIsVisible(text: String) {
        name.hasText(text)
    }
}