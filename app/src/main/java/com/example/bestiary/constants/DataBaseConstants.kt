package com.example.bestiary.constants

class DataBaseConstants private constructor() {

    object MONSTER {
        const val TABLE_NAME = "Monster"

        object COLUMNS {
            const val ID = "id"
            const val NAME = "name"
            const val USED = "used"
        }

    }

}