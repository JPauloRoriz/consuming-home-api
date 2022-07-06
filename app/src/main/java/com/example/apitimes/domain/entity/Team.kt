package com.example.apitimes.domain.entity

data class Team(
    val name: String?,
    val description: String?,
    val image: String?
) : BaseComponent(ComponentType.TEAM)