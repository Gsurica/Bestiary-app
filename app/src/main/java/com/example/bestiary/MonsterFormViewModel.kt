package com.example.bestiary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.bestiary.model.MonsterModel
import com.example.bestiary.repository.MonsterRepository

class MonsterFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MonsterRepository.getInstance(application)

    fun insert(monsterModel: MonsterModel) {
        repository.insert(monsterModel)
    }

}