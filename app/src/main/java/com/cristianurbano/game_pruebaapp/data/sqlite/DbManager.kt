package com.cristianurbano.game_pruebaapp.data.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DbManager (private val context: Context) {
    private val dbHelper = DbHelper(context)
    private var db: SQLiteDatabase? = null

    fun openDbWrite (){
        if (db == null){
            db = dbHelper.writableDatabase
        }
    }

    fun openDbRead(){
        if (db == null)
            db=dbHelper.readableDatabase
    }

    fun closeDb(){
        if (db != null)
            db?.close()
    }

    fun dbInstance(): SQLiteDatabase {
        db = if (db == null || db!!.isOpen){
            dbHelper.writableDatabase
        }else{
            dbHelper.readableDatabase
        }
        return db!!
    }
}