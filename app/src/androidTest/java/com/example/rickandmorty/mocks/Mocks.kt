package com.example.rickandmorty.mocks

import okhttp3.mockwebserver.MockResponse

fun mockCharacterList(filePath: String = "character") {
    val characterRequestResponse =
        RequestResponse(MockResponse().setBody(getFileContent(filePath))) {
            it.requestUrl?.encodedPath() == "/character"
        }
    MockDispatcher.requestResponseList.add(characterRequestResponse)
}

fun mockCharacterWithId(filePath: String = "character/1") {
    val id = filePath.split("/")[1]
    val characterRequestResponse =
        RequestResponse(MockResponse().setBody(getFileContent(filePath))) { request ->
            var flag = true
            if (request.requestUrl?.encodedPathSegments()?.get(0) == "character") {
                request.requestUrl?.encodedPathSegments()
                    ?.let { flag = flag && it[1] == id }
                return@RequestResponse flag
            }
            return@RequestResponse false
        }
    MockDispatcher.requestResponseList.add(characterRequestResponse)
}