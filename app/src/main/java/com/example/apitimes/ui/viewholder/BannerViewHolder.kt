package com.example.apitimes.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.apitimes.domain.entity.BannerTeam
import com.example.apitimes.databinding.ItemBannerBinding
import com.example.apitimes.ui.extension.loadFromUrl

class BannerViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val binding: ItemBannerBinding by lazy {
        ItemBannerBinding.bind(itemView)
    }

    fun bind(item: BannerTeam) {
        with(binding) {
            imgImage.loadFromUrl(item.image)
        }
    }
}