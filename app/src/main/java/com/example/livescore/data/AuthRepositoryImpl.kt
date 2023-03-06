package com.example.livescore.data

import com.example.livescore.models.UserModel
import com.example.livescore.models.user
import com.example.livescore.repository.AuthRepository
import com.example.livescore.services.ApiService
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val apiService: ApiService)
    : AuthRepository {
    override suspend fun signup(email: String, password: String): Resource<UserModel> {
        return try {
            apiService.fakeCall()
            Resource.Success(data = user)
        } catch (ex: Exception) {
            Resource.Error(msg = "Something went wrong: ${ex.message}")
        }
    }

    override suspend fun login(email: String, password: String): Resource<UserModel> {
        return try {
            apiService.fakeCall()
            Resource.Success(data = user)
        } catch (ex: Exception) {
            Resource.Error(msg = "Something went wrong: ${ex.message}")
        }
    }
}