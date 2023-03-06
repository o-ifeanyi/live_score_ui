package com.example.livescore.models

import com.example.livescore.R

data class SportModel(val name: String, val image: Int)

val listOfSports = listOf(
    SportModel(name = "Soccer", image = R.drawable.soccer),
    SportModel(name = "Basketball", image = R.drawable.basketball),
    SportModel(name = "Football", image = R.drawable.football),
    SportModel(name = "Baseball", image = R.drawable.baseball),
    SportModel(name = "Tennis", image = R.drawable.tennis),
    SportModel(name = "Volleyball", image = R.drawable.volly),
    SportModel(name = "Badminton", image = R.drawable.badminton),
    SportModel(name = "Ping pong", image = R.drawable.pingpong)
)
