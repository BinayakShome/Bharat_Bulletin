package com.example.bharatbulletin.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomePage

@Serializable
data class NewsDisplayPage(
    val url : String
)

@Serializable
object LivePage

@Serializable
object DevPage