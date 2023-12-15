package com.cristianurbano.game_pruebaapp.data.sqlite.query

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.util.Log
import com.cristianurbano.game_pruebaapp.Models.UserModel
import com.cristianurbano.game_pruebaapp.data.sqlite.DbManager
import com.cristianurbano.game_pruebaapp.data.sqlite.tables.UserTable.Companion.CreateTable_User
import com.cristianurbano.game_pruebaapp.data.sqlite.tables.UserTable.Companion.Select_User_Table


class UserQuery (private val context: Context){

    private lateinit var dbManager: DbManager
    private lateinit var db : SQLiteDatabase

    fun insertUser(user:UserModel): Long {
        return try {
            dbManager = DbManager(context)
            dbManager.openDbWrite()
            db = dbManager.dbInstance()
            val values = ContentValues()
            values.put("name", user.name)
            values.put("identification", user.identification)
            values.put("phone", user.phone)
            values.put("password", user.password)
            values.put("email", user.email)
            values.put("userName", user.userName)
            values.put("role", user.role)

            val response = db.insert(CreateTable_User, null, values)
            dbManager.closeDb()
            return response

        } catch (e: SQLiteException) {
            Log.e("insertUserCatch: ", e.message.toString())
            0
        }
    }

    @SuppressLint("Recycle")
    fun listAllUsers(): List<UserModel> {
        return try {
            dbManager = DbManager(context)
            dbManager.openDbRead()
            db = dbManager.dbInstance()
            val list: ArrayList<UserModel> = ArrayList()

            val cursor = db.rawQuery(Select_User_Table, null)

            if (cursor.moveToFirst()) {
                do {
                    val user = UserModel()
                    user.id = cursor.getString(cursor.getColumnIndexOrThrow("id"))?.toInt() ?: 0
                    user.name = cursor.getString(cursor.getColumnIndexOrThrow("name")) ?: ""
                    user.identification =
                        cursor.getString(cursor.getColumnIndexOrThrow("identification")) ?: ""
                    user.phone = cursor.getString(cursor.getColumnIndexOrThrow("phone")) ?: ""
                    user.email = cursor.getString(cursor.getColumnIndexOrThrow("email")) ?: ""
                    user.userName =
                        cursor.getString(cursor.getColumnIndexOrThrow("userName")) ?: ""
                    user.role = cursor.getString(cursor.getColumnIndexOrThrow("role")) ?: ""

                    list.add(user)
                } while (cursor.moveToNext())
            }
            list
        } catch (e: SQLiteException) {
            return arrayListOf()
        }

    }

}