package com.example.bestiary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.bestiary.repository.MonsterRepository

class MonsterFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MonsterRepository.getInstance(application)

}