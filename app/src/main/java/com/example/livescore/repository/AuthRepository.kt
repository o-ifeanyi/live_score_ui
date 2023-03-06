package com.example.livescore.repository

import com.example.livescore.data.Resource
import com.example.livescore.models.UserModel

interface AuthRepository {
    suspend fun signup(email: String, password: String) : Resource<UserModel>
    suspend fun login(email: String, password: String) : Resource<UserModel>
}