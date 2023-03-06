package com.example.livescore.models

import com.example.livescore.R

data class MatchModel(
    val id: String,
    val league: LeagueModel,
    val home: TeamModel,
    val away: TeamModel,
    val homeScore: Int,
    val awayScore: Int,
    val formation: String,
    val matchDetail: MatchDetailModel
)

val listOfMatchModels = listOf(
    MatchModel(
        id = "001",
        league = LeagueModel(
            name = "Premiere League",
            country = "England",
            countryImage = R.drawable.england,
            leagueImage = R.drawable.uefa
        ),
        home = TeamModel(name = "Arsenal", image = R.drawable.arsenal),
        away = TeamModel(name = "Chelsea", image = R.drawable.chelsea),
        homeScore = 2,
        awayScore = 3,
        formation = "(4-2-3-1)",
        matchDetail = MatchDetailModel(
            hShooting = 8,
            aShooting = 12,
            hAttacks = 22,
            aAttacks = 29,
            hPossession = 42,
            aPossession = 58,
            hCards = 1,
            aCards = 0,
            hCorners = 8,
            aCorners = 7,
        )
    ),
    MatchModel(
        id = "002",
        league = LeagueModel(
            name = "La Liga",
            country = "Spain",
            countryImage = R.drawable.spain,
            leagueImage = R.drawable.laliga
        ),
        home = TeamModel(name = "Barcelona", image = R.drawable.barcelona),
        away = TeamModel(name = "Real Madrid", image = R.drawable.realmadrid),
        homeScore = 2,
        awayScore = 1,
        formation = "(4-2-3-1)",
        matchDetail = MatchDetailModel(
            hShooting = 8,
            aShooting = 12,
            hAttacks = 22,
            aAttacks = 29,
            hPossession = 42,
            aPossession = 58,
            hCards = 1,
            aCards = 0,
            hCorners = 8,
            aCorners = 7,
        )
    ),
    MatchModel(
        id = "003",
        league = LeagueModel(
            name = "Premiere League",
            country = "England",
            countryImage = R.drawable.england,
            leagueImage = R.drawable.uefa
        ),
        home = TeamModel(name = "Liverpool", image = R.drawable.liverpool),
        away = TeamModel(name = "Manchester", image = R.drawable.manchester),
        homeScore = 2,
        awayScore = 3,
        formation = "(4-2-3-1)",
        matchDetail = MatchDetailModel(
            hShooting = 8,
            aShooting = 12,
            hAttacks = 22,
            aAttacks = 29,
            hPossession = 42,
            aPossession = 58,
            hCards = 1,
            aCards = 0,
            hCorners = 8,
            aCorners = 7,
        )
    ),
    MatchModel(
        id = "004",
        league = LeagueModel(
            name = "La Liga",
            country = "Spain",
            countryImage = R.drawable.spain,
            leagueImage = R.drawable.laliga
        ),
        home = TeamModel(name = "Barcelona", image = R.drawable.bayernmunchen),
        away = TeamModel(name = "Real Madrid", image = R.drawable.dortmund),
        homeScore = 3,
        awayScore = 1,
        formation = "(4-2-3-1)",
        matchDetail = MatchDetailModel(
            hShooting = 8,
            aShooting = 12,
            hAttacks = 22,
            aAttacks = 29,
            hPossession = 42,
            aPossession = 58,
            hCards = 1,
            aCards = 0,
            hCorners = 8,
            aCorners = 7,
        )
    ),
)