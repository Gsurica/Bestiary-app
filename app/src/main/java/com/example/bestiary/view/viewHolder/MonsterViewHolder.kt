package com.example.bestiary.view.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bestiary.databinding.RowMonsterBinding
import com.example.bestiary.model.MonsterModel

class MonsterViewHolder(private val bind: RowMonsterBinding) : RecyclerView.ViewHolder(bind.root) {

    fun bind(monster: MonsterModel) {
        bind.textName.text = monster.name
    }
}