package com.example.bestiary.repository

import android.content.Context

class MonsterRepository private constructor(context: Context) {

    private val monsterDatabase = MonsterDataBase(context)

    companion object {
        private lateinit var repository: MonsterRepository

        fun getInstance(context: Context): MonsterRepository {

            if (!Companion::repository.isInitialized) {
                repository = MonsterRepository(context)
            }

            return repository

        }

    }
    fun insert() {
    }

    fun update() {
    }

}