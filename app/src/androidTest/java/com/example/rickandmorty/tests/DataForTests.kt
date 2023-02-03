package com.example.rickandmorty.tests

import androidx.test.platform.app.InstrumentationRegistry
import org.json.JSONObject

object DataForTests {

    private fun geJSONContent(path: String) =
        InstrumentationRegistry.getInstrumentation().context.assets
            .open("${path}.json").bufferedReader().readText()

    fun getCharacterDataInTheList(id: Int): CharactersListData {
        val fileName = "character"
        val character =
            JSONObject(geJSONContent(fileName))
                .getJSONArray("results")
                .getJSONObject(id - 1)
        return CharactersListData(
            character.getString("name"),
            "${character.getString("species")} - ${character.getString("status")}"
        )
    }

    fun getCharacterDetails(id: Int): CharacterData {
        val fileName = "character/${id}"
        val character = JSONObject(geJSONContent(fileName))
        return CharacterData(
            character.getString("name"),
            character.getString("status"),
            character.getString("species"),
            character.getString("gender")
        )
    }
}