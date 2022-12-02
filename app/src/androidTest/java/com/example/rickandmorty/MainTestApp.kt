package com.example.rickandmorty

import dagger.hilt.android.testing.CustomTestApplication

@CustomTestApplication(MainApplication::class)
class MainTestApp : MainApplication()