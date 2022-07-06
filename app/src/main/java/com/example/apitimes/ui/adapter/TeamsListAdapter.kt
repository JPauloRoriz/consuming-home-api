package com.example.apitimes.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apitimes.data.entities.response.ItemTeam
import com.example.apitimes.databinding.ItemInnerTeamsListBinding
import com.example.apitimes.ui.extension.loadFromUrl

class TeamsListAdapter :
    ListAdapter<ItemTeam, TeamsListAdapter.TeamListViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamListViewHolder {
        return TeamListViewHolder(
            ItemInnerTeamsListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).root
        )
    }

    override fun onBindViewHolder(holder: TeamListViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun submitList(list: MutableList<ItemTeam>?) {
        list?.toMutableList()?.let {
            super.submitList(ArrayList(it))
        }
    }


    inner class TeamListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: ItemInnerTeamsListBinding by lazy {
            ItemInnerTeamsListBinding.bind(itemView)
        }

        fun bind(itemTeam: ItemTeam) {
            with(binding) {
                imgImageStart.loadFromUrl(itemTeam.image)
                tvTitle.text = itemTeam.name
                tvDescription.text = itemTeam.description
            }
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<ItemTeam>() {
            override fun areItemsTheSame(
                oldItem: ItemTeam,
                newItem: ItemTeam
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: ItemTeam,
                newItem: ItemTeam
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}