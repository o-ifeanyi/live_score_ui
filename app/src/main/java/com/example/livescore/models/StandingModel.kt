package com.example.livescore.models

import com.example.livescore.R

data class TeamStanding(
    val id: String,
    val team: TeamModel,
    val win: Int,
    val draw: Int,
    val ga: Int,
    val gd: Int,
    val pts: Int,
)

data class StandingModel(
    val id: String,
    val league: LeagueModel,
    val teamStanding: List<TeamStanding>,
)

val listOfStandings = listOf(
    StandingModel(
        id = "001",
        league = LeagueModel(
            name = "La Liga",
            country = "Spain",
            countryImage = R.drawable.spain,
            leagueImage = R.drawable.laliga
        ),
        teamStanding = listOf(
            TeamStanding(
                id = "001",
                team = TeamModel(name = "Barcelona", image = R.drawable.bayernmunchen),
                win = 8,
                draw = 2,
                ga = 6,
                gd = 23,
                pts = 38,
            ),
            TeamStanding(
                id = "002",
                TeamModel(name = "Real Madrid", image = R.drawable.dortmund),
                win = 7,
                draw = 3,
                ga = 7,
                gd = 15,
                pts = 37,
            ),
            TeamStanding(
                id = "003",
                TeamModel(name = "Barcelona", image = R.drawable.barcelona),
                win = 5,
                draw = 4,
                ga = 9,
                gd = 20,
                pts = 34,
            ),
            TeamStanding(
                id = "004",
                TeamModel(name = "Real Madrid", image = R.drawable.realmadrid),
                win = 4,
                draw = 4,
                ga = 6,
                gd = 16,
                pts = 32,
            ),
            TeamStanding(
                id = "005",
                team = TeamModel(name = "Barcelona", image = R.drawable.bayernmunchen),
                win = 8,
                draw = 2,
                ga = 6,
                gd = 23,
                pts = 38,
            ),
            TeamStanding(
                id = "006",
                TeamModel(name = "Real Madrid", image = R.drawable.dortmund),
                win = 7,
                draw = 3,
                ga = 7,
                gd = 15,
                pts = 37,
            ),
            TeamStanding(
                id = "007",
                TeamModel(name = "Barcelona", image = R.drawable.barcelona),
                win = 5,
                draw = 4,
                ga = 9,
                gd = 20,
                pts = 34,
            ),
            TeamStanding(
                id = "008",
                TeamModel(name = "Real Madrid", image = R.drawable.realmadrid),
                win = 4,
                draw = 4,
                ga = 6,
                gd = 16,
                pts = 32,
            ),
        ),
    ),
    StandingModel(
        id = "002",
        league = LeagueModel(
            name = "Premiere League",
            country = "England",
            countryImage = R.drawable.england,
            leagueImage = R.drawable.uefa
        ),
        teamStanding = listOf(
            TeamStanding(
                id = "001",
                team = TeamModel(name = "Chelsea", image = R.drawable.chelsea),
                win = 8,
                draw = 2,
                ga = 6,
                gd = 23,
                pts = 38,
            ),
            TeamStanding(
                id = "002",
                team = TeamModel(name = "Arsenal", image = R.drawable.arsenal),
                win = 7,
                draw = 3,
                ga = 7,
                gd = 15,
                pts = 37,
            ),
            TeamStanding(
                id = "003",
                team = TeamModel(name = "Manchester", image = R.drawable.manchester),
                win = 5,
                draw = 4,
                ga = 9,
                gd = 20,
                pts = 34,
            ),
            TeamStanding(
                id = "004",
                team = TeamModel(name = "Liverpool", image = R.drawable.liverpool),
                win = 4,
                draw = 4,
                ga = 6,
                gd = 16,
                pts = 32,
            ),
            TeamStanding(
                id = "005",
                team = TeamModel(name = "Chelsea", image = R.drawable.chelsea),
                win = 8,
                draw = 2,
                ga = 6,
                gd = 23,
                pts = 38,
            ),
            TeamStanding(
                id = "006",
                team = TeamModel(name = "Arsenal", image = R.drawable.arsenal),
                win = 7,
                draw = 3,
                ga = 7,
                gd = 15,
                pts = 37,
            ),
            TeamStanding(
                id = "007",
                team = TeamModel(name = "Manchester", image = R.drawable.manchester),
                win = 5,
                draw = 4,
                ga = 9,
                gd = 20,
                pts = 34,
            ),
            TeamStanding(
                id = "008",
                team = TeamModel(name = "Liverpool", image = R.drawable.liverpool),
                win = 4,
                draw = 4,
                ga = 6,
                gd = 16,
                pts = 32,
            ),
        ),
    )
)