package com.example.livescore.models

import com.example.livescore.R

data class ArticleModel(
    val id: String,
    val title: String,
    val body: String,
    val date: String,
    val image: Int,
    val author: String,
    val likesCount: Int,
    val commentsCount: Int
)

const val body =
    "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?"

val listOfArticles = listOf(
    ArticleModel(
        id = "001",
        title = "Rumor Has It: Lampard’s position under threat",
        body = body,
        date = "May 15, 2020",
        image = R.drawable.articel1,
        author = "Brian Immanuel",
        likesCount = 1403,
        commentsCount = 976,
    ),
    ArticleModel(
        id = "002",
        title = "Arta sees ‘natural leader’ Tierney as a future",
        body = body,
        date = "May 15, 2020",
        image = R.drawable.articel5,
        author = "Brian Immanuel",
        likesCount = 300,
        commentsCount = 23,
    ),
    ArticleModel(
        id = "003",
        title = "Athletic Bilbao to appoint Marcelino as coach until",
        body = body,
        date = "May 15, 2020",
        image = R.drawable.articel2,
        author = "Brian Immanuel",
        likesCount = 143,
        commentsCount = 60,
    ),
    ArticleModel(
        id = "004",
        title = "Barcelona suffer too much late in games, says Ter Steven",
        body = body,
        date = "May 15, 2020",
        image = R.drawable.articel3,
        author = "Brian Immanuel",
        likesCount = 568,
        commentsCount = 124,
    ),
    ArticleModel(
        id = "005",
        title = "Arsenal vs Aston Villa prediction",
        body = body,
        date = "May 15, 2020",
        image = R.drawable.articel4,
        author = "Brian Immanuel",
        likesCount = 865,
        commentsCount = 47,
    ),
    ArticleModel(
        id = "006",
        title = "Arsenal vs Aston Villa prediction",
        body = body,
        date = "May 15, 2020",
        image = R.drawable.articel6,
        author = "Brian Immanuel",
        likesCount = 47,
        commentsCount = 12,
    )
)