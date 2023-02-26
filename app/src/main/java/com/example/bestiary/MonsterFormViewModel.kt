package com.example.bestiary

import androidx.lifecycle.ViewModel
import com.example.bestiary.repository.MonsterRepository

class MonsterFormViewModel : ViewModel() {

    private val repository = MonsterRepository.getInstance()

}