package com.example.livescore.models

import com.example.livescore.R

data class SearchCategoryModel(val name: String, val image: Int)

val listOfSearchCategory = listOf(
    SearchCategoryModel(name = "Live Score", image = R.drawable.api),
    SearchCategoryModel(name = "Articles", image = R.drawable.newspapper),
    SearchCategoryModel(name = "Hashtag", image = R.drawable.hastag),
    SearchCategoryModel(name = "Teams", image = R.drawable.stadium),
)
