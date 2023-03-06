package com.example.livescore.services

import kotlinx.coroutines.delay

class ApiService {
    suspend fun fakeCall() : Boolean {
        delay(1500L)
        return true
    }
}