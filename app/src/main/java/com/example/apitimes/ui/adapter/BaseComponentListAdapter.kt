package com.example.apitimes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apitimes.data.entities.response.*
import com.example.apitimes.databinding.ItemBannerBinding
import com.example.apitimes.databinding.ItemTeamBinding
import com.example.apitimes.databinding.ListTeamViewHolderBinding
import com.example.apitimes.domain.entity.BannerTeam
import com.example.apitimes.domain.entity.BaseComponent
import com.example.apitimes.domain.entity.ComponentType
import com.example.apitimes.domain.entity.Team
import com.example.apitimes.ui.viewholder.BannerViewHolder
import com.example.apitimes.ui.viewholder.ListTeamViewHolder
import com.example.apitimes.ui.viewholder.TeamViewHolder

class BaseComponentListAdapter :
    ListAdapter<BaseComponent, RecyclerView.ViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            ComponentType.LIST_TEAMS.idType -> {
                return ListTeamViewHolder(
                    ListTeamViewHolderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ).root
                )
            }
            ComponentType.TEAM.idType -> {
                return TeamViewHolder(
                    ItemTeamBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ).root
                )
            }
           else -> {
                return BannerViewHolder(
                    ItemBannerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ).root
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = currentList[position]
        when (currentItem.component) {
            ComponentType.LIST_TEAMS -> {
                if (currentItem is ListTeams) {
                    (holder as? ListTeamViewHolder)?.bind(currentItem)
                }
            }
            ComponentType.TEAM -> {
                if (currentItem is Team) {
                    (holder as? TeamViewHolder)?.bind(currentItem)
                }
            }
            ComponentType.BANNER_TEAM -> {
                if (currentItem is BannerTeam) {
                    (holder as? BannerViewHolder)?.bind(currentItem)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun getItemViewType(position: Int): Int {
        return currentList[position].component.idType
    }

    override fun submitList(list: MutableList<BaseComponent>?) {
        list?.toMutableList()?.let {
            super.submitList(ArrayList(it))
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<BaseComponent>() {
            override fun areItemsTheSame(
                oldItem: BaseComponent,
                newItem: BaseComponent
            ): Boolean {
                return oldItem.component == oldItem.component
            }

            override fun areContentsTheSame(
                oldItem: BaseComponent,
                newItem: BaseComponent
            ): Boolean {
                return oldItem.equals(newItem)
            }
        }
    }
}
