package com.example.apitimes.domain.entity

enum class ComponentType(val id: String, val idType: Int) {
    LIST_TEAMS("components.listTeams", 0),
    TEAM("components.team", 1),
    BANNER_TEAM("components.bannerTeam", 2)
}

fun String.getComponentType(): ComponentType {
    return ComponentType.values().find { it.id == this } ?: ComponentType.BANNER_TEAM
}