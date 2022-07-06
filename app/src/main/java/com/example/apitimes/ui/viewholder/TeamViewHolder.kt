package com.example.apitimes.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.apitimes.domain.entity.Team
import com.example.apitimes.databinding.ItemTeamBinding
import com.example.apitimes.ui.extension.loadFromUrl

class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding: ItemTeamBinding by lazy {
        ItemTeamBinding.bind(itemView)
    }

    fun bind(item: Team) {
        with(binding) {
            tvTitle.text = item.name
            tvDescription.text = item.description
            imgImageStart.loadFromUrl(item.image)
        }
    }
}