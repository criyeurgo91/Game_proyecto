package com.cristianurbano.game_pruebaapp.data.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.cristianurbano.game_pruebaapp.data.helpers.Constants.Companion.NAME_DATA_BASE
import com.cristianurbano.game_pruebaapp.data.helpers.Constants.Companion.VERSION_DATABASE
import com.cristianurbano.game_pruebaapp.data.sqlite.tables.HistoryGameTable.Companion.CREATE_GAME_HISTORY_TABLE
import com.cristianurbano.game_pruebaapp.data.sqlite.tables.TeamsGameTable.Companion.CREATE_TEAM_TABLE
import com.cristianurbano.game_pruebaapp.data.sqlite.tables.UserTable.Companion.CreateTable_User

class DbHelper (context: Context):
    SQLiteOpenHelper(context, NAME_DATA_BASE, null, VERSION_DATABASE) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CreateTable_User)
        db?.execSQL(CREATE_GAME_HISTORY_TABLE)
        db?.execSQL(CREATE_TEAM_TABLE)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}