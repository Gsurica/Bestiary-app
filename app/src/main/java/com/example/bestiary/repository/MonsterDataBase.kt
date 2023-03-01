package com.example.bestiary.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.bestiary.constants.DataBaseConstants


class MonsterDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object {
        private const val NAME = "monsterDB"
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE " + DataBaseConstants.MONSTER.TABLE_NAME + " (" + DataBaseConstants.MONSTER.COLUMNS.ID + " integer primary key autoincrement, " + DataBaseConstants.MONSTER.COLUMNS.NAME + " text, " + DataBaseConstants.MONSTER.COLUMNS.USED + " integer);")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

}