package com.example.apitimes.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.apitimes.R
import com.example.apitimes.data.entities.response.ItemTeam
import com.example.apitimes.databinding.ComponentListTeamsBinding
import com.example.apitimes.ui.adapter.TeamsListAdapter

class CustomListTeams @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: ComponentListTeamsBinding by lazy {
        ComponentListTeamsBinding.inflate(LayoutInflater.from(context), this, true)
    }
    private val adapter by lazy { TeamsListAdapter() }

    var title: String
        get() = binding.tvTitleTop.text.toString()
        set(value) {
            binding.tvTitleTop.text = value
        }

    var listTeams: List<ItemTeam> = listOf()
        set(value) {
            field = value
            adapter.submitList(field.toMutableList())
        }

    init {
        val attributes =
            context.obtainStyledAttributes(attrs, R.styleable.CustomListTeams, defStyleAttr, 0)
        title = attributes.getString(R.styleable.CustomListTeams_title) ?: ""
        binding.rvItem.adapter = adapter
    }


}