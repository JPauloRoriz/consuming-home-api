package com.example.apitimes.data.entities.response

data class HomeResponse(
    val user: UserResponse,
    val list: List<HomeItemResponse>
)

data class HomeItemResponse(
    val componentId: String?,
    val title: String?,
    val name: String?,
    val description: String?,
    val image: String?,
    val teams: List<TeamResponse>? = listOf()
)

data class TeamResponse(
    val name: String?,
    val description: String?,
    val image: String?,
)