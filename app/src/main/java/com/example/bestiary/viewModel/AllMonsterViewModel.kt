package com.example.bestiary.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bestiary.model.MonsterModel
import com.example.bestiary.repository.MonsterRepository

class AllMonsterViewModel(application: Application) : AndroidViewModel(application) {

    private val listAllMonsters = MutableLiveData<List<MonsterModel>>()
    private val repository = MonsterRepository.getInstance(application)

    val allMonsters: LiveData<List<MonsterModel>> = listAllMonsters

    fun getAll() {
        listAllMonsters.value = repository.getAll()
    }
}