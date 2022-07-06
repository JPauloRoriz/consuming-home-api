package com.example.apitimes.data.entities.response

import com.example.apitimes.domain.entity.BaseComponent
import com.example.apitimes.domain.entity.ComponentType

data class ListTeams(
    val title : String,
    val teams : List<ItemTeam>
) : BaseComponent(ComponentType.LIST_TEAMS)

data class ItemTeam(
    val name: String,
    val description: String,
    val image: String
)