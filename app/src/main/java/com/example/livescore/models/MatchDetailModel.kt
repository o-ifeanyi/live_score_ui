package com.example.livescore.models

data class MatchDetailModel(
    val hShooting: Int,
    val aShooting: Int,
    val hAttacks: Int,
    val aAttacks: Int,
    val hPossession: Int,
    val aPossession: Int,
    val hCards: Int,
    val aCards: Int,
    val hCorners: Int,
    val aCorners: Int,
)
