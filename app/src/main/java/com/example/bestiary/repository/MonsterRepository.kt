package com.example.bestiary.repository

class MonsterRepository private constructor() {

    companion object {
        private lateinit var repository: MonsterRepository

        fun getInstance(): MonsterRepository {

            if (!Companion::repository.isInitialized) {
                repository = MonsterRepository()
            }

            return repository

        }

    }

}