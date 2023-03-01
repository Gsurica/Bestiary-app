package com.example.bestiary.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.bestiary.databinding.RowMonsterBinding
import com.example.bestiary.model.MonsterModel
import com.example.bestiary.view.viewHolder.MonsterViewHolder

class MonsterAdapter : RecyclerView.Adapter<MonsterViewHolder>() {

    private var monsterList: List<MonsterModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonsterViewHolder {
        val item = RowMonsterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonsterViewHolder(item)
    }

    override fun getItemCount(): Int {
        return monsterList.count()
    }

    override fun onBindViewHolder(holder: MonsterViewHolder, position: Int) {
        holder.bind(monsterList[position])
    }

    fun updateMonsters(list: List<MonsterModel>) {
        monsterList = list
        notifyDataSetChanged()
    }
}