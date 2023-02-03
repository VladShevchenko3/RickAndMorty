package com.example.rickandmorty.mocks

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

data class RequestResponse(
    val response: MockResponse,
    val predicate: (RecordedRequest) -> Boolean
)