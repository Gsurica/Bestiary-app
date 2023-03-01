package com.example.bestiary.repository

import android.content.ContentValues
import android.content.Context
import com.example.bestiary.constants.DataBaseConstants
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
            values.put(DataBaseConstants.MONSTER.COLUMNS.NAME, monster.name)
            values.put(DataBaseConstants.MONSTER.COLUMNS.USED, used)

            db.insert("Monster", null, values)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun update(monster: MonsterModel): Boolean {
        return try {
            val db = monsterDatabase.writableDatabase

            val used = if (monster.used) 1 else 0

            val values = ContentValues()
            values.put(DataBaseConstants.MONSTER.COLUMNS.NAME, monster.name)
            values.put(DataBaseConstants.MONSTER.COLUMNS.USED, used)

            val selection = DataBaseConstants.MONSTER.COLUMNS.ID + " = ?"
            val args = arrayOf(monster.id.toString())

            db.update(DataBaseConstants.MONSTER.TABLE_NAME, values, selection, args)

            true
        } catch (e: Exception) {
            false
        }
    }

    fun delete(monsterID: Int): Boolean {
        return try {
            val db = monsterDatabase.writableDatabase

            val selection = DataBaseConstants.MONSTER.COLUMNS.ID + " = ?"
            val args = arrayOf(monsterID.toString())

            db.delete(DataBaseConstants.MONSTER.TABLE_NAME, selection, args)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getAll(): List<MonsterModel> {

        var monsterList = mutableListOf<MonsterModel>()

        return try {


            val db = monsterDatabase.readableDatabase
            val columns = arrayOf(
                DataBaseConstants.MONSTER.COLUMNS.ID,
                DataBaseConstants.MONSTER.COLUMNS.NAME,
                DataBaseConstants.MONSTER.COLUMNS.USED
            )

            val cursor = db.query(DataBaseConstants.MONSTER.TABLE_NAME, columns, null, null, null, null, null)

            if (cursor != null && cursor.count > 0) {
                while(cursor.moveToNext()) {

                    val id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.MONSTER.COLUMNS.ID))
                    val name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.MONSTER.COLUMNS.NAME))
                    val used = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.MONSTER.COLUMNS.USED))

                    val monster = MonsterModel(id, name, used == 1)

                    monsterList.add(monster)

                }
            }

            cursor.close()

            return monsterList

        } catch (e: Exception) {

            return monsterList
        }

        return monsterList
    }

    fun getUsed(): List<MonsterModel> {
        var monsterList = mutableListOf<MonsterModel>()

        return try {

            val db = monsterDatabase.readableDatabase

            val columns = arrayOf(
                DataBaseConstants.MONSTER.COLUMNS.ID,
                DataBaseConstants.MONSTER.COLUMNS.NAME,
                DataBaseConstants.MONSTER.COLUMNS.USED
            )
            val selection = DataBaseConstants.MONSTER.COLUMNS.USED + " = ?"
            val args = arrayOf("1")

            val cursor = db.query(DataBaseConstants.MONSTER.TABLE_NAME, columns, selection, args, null, null, null)

            if (cursor != null && cursor.count > 0) {
                while(cursor.moveToNext()) {
                    val id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.MONSTER.COLUMNS.ID))
                    val name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.MONSTER.COLUMNS.NAME))
                    val used = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.MONSTER.COLUMNS.USED))

                    val monster = MonsterModel(id, name, used == 1)

                    monsterList.add(monster)
                }
            }

            return monsterList

        } catch(e: Exception) {
            return monsterList
        }

        return monsterList

    }

    fun getUnused(): List<MonsterModel> {
        var monsterList = mutableListOf<MonsterModel>()

        return try {

            val db = monsterDatabase.readableDatabase

            val columns = arrayOf(
                DataBaseConstants.MONSTER.COLUMNS.ID,
                DataBaseConstants.MONSTER.COLUMNS.NAME,
                DataBaseConstants.MONSTER.COLUMNS.USED
            )

            val selection = DataBaseConstants.MONSTER.COLUMNS.USED + " = ? "
            val args = arrayOf("0")

            val cursor = db.query(DataBaseConstants.MONSTER.TABLE_NAME, columns, selection, args, null, null, null, null)

            if (cursor != null && cursor.count > 0) {
                while(cursor.moveToNext()) {
                    val id = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.MONSTER.COLUMNS.ID))
                    val name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.MONSTER.COLUMNS.NAME))
                    val used = cursor.getInt(cursor.getColumnIndex(DataBaseConstants.MONSTER.COLUMNS.USED))

                    val monster = MonsterModel(id, name, used == 0)

                    monsterList.add(monster)
                }
            }

            return monsterList
        } catch(e: Exception) {
            return monsterList
        }

    }

}