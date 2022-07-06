package com.example.apitimes.data.repository.mapper

import com.example.apitimes.data.entities.response.HomeItemResponse
import com.example.apitimes.data.entities.response.ItemTeam
import com.example.apitimes.data.entities.response.ListTeams
import com.example.apitimes.domain.entity.*

class HomeResponseMapper {

    fun itemResponseToBaseComponent(itemResponse: HomeItemResponse): BaseComponent {
        return when (itemResponse.componentId?.getComponentType() ?: ComponentType.BANNER_TEAM) {
            ComponentType.LIST_TEAMS -> {
                ListTeams(
                    title = itemResponse.title.orEmpty(),
                    teams = itemResponse.teams?.map { itemTeam ->
                        ItemTeam(
                            itemTeam.name.orEmpty(),
                            itemTeam.description.orEmpty(),
                            itemTeam.image.orEmpty()
                        )
                    }.orEmpty()
                )
            }
            ComponentType.TEAM -> {
                Team(
                    itemResponse.name.orEmpty(),
                    itemResponse.description.orEmpty(),
                    itemResponse.image.orEmpty()
                )
            }
            ComponentType.BANNER_TEAM -> {
                BannerTeam(itemResponse.image.orEmpty())
            }
        }
    }
}