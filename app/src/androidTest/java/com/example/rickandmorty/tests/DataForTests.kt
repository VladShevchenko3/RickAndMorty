package com.example.rickandmorty.tests

import androidx.test.platform.app.InstrumentationRegistry
import org.json.JSONObject

object DataForTests {

    private fun geJSONContent(path: String) =
        InstrumentationRegistry.getInstrumentation().context.assets
            .open("${path}.json").bufferedReader().readText()

    fun getCharacterDataInTheList(id: Int): Map<String, String> {
        val fileName = "character"
        val character =
            JSONObject(geJSONContent(fileName))
                .getJSONArray("results")
                .getJSONObject(id - 1)
        return mapOf(
            "name" to character.getString("name"),
            "speciesAndStatus" to "${character.getString("species")} - ${character.getString("status")}"
        )
    }

    fun getCharacterDetails(id: Int): Map<String, String> {
        val fileName = "character/${id}"
        val character = JSONObject(geJSONContent(fileName))
        return mapOf(
            "name" to character.getString("name"),
            "status" to character.getString("status"),
            "species" to character.getString("species"),
            "gender" to character.getString("gender")
        )
    }
}