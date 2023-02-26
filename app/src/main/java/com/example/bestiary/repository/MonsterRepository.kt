package com.example.bestiary.repository

import android.content.ContentValues
import android.content.Context
import com.example.bestiary.model.MonsterModel

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
    fun insert(monster: MonsterModel): Boolean {
        return try {
            val db = monsterDatabase.writableDatabase

            val used = if (monster.used) 1 else 0

            val values = ContentValues()
            values.put("name", monster.name)
            values.put("used", used)

            db.insert("Monster", null, values)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun update() {
    }

}