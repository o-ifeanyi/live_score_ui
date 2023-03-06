package com.example.livescore.models

data class UserModel(val name: String, val email: String, val phone: String, val address: String)

val user = UserModel(
    name = "Brian Immanuel",
    email = "brians213@gmail.com",
    phone = "+62 821 560 641",
    address = "Long beach, California"
)