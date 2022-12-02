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

    private val listOfCharacterView = KRecyclerView({
        withId(R.id.characters_rv)
    }, itemTypeBuilder = {
        itemType(::CharacterItem)
    })

    class CharacterItem(parent: Matcher<View>) : KRecyclerItem<CharacterItem>(parent) {
        val nameTextField = KTextView(parent) { withId(R.id.name) }
        val speciesAndStatusTextField = KTextView(parent) {
            withId(R.id.species_and_status)
        }
        val image = KImageView(parent) { withId(R.id.image) }
    }

    fun actionClickOnTheCharacter(name: String) {
        listOfCharacterView {
            childWith<CharacterItem> {
                withDescendant { withText(name) }
            } perform {
                nameTextField.click()
            }
        }
    }
}