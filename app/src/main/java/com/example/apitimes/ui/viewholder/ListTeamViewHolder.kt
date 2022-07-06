package com.example.apitimes.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.apitimes.data.entities.response.ListTeams
import com.example.apitimes.databinding.ListTeamViewHolderBinding

class ListTeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding: ListTeamViewHolderBinding by lazy {
        ListTeamViewHolderBinding.bind(itemView)
    }

    fun bind(item: ListTeams) {
        with(binding) {
            customListTeams.title = item.title
            customListTeams.listTeams = item.teams
        }
    }
}