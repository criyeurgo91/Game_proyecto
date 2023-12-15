package com.cristianurbano.game_pruebaapp.data.prefs

import android.content.Context
import android.content.SharedPreferences
import kotlin.IllegalArgumentException

class SharedPreferencesManager (context: Context) {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("DB_Game", Context.MODE_PRIVATE)
    }

    fun savePref(key: String, value: Any){
        val editor = sharedPreferences.edit()

        when (value){
            is String -> editor.putString(key, value)
            is Boolean -> editor.putBoolean(key, value)
            is Int -> editor.putInt(key, value)
            is Float -> editor.putFloat(key, value)
            is Long -> editor.putLong(key, value)
            else -> throw IllegalArgumentException("este tipo de dato no es admitido")
        }
        editor.apply()
    }

    fun getPref(key: String, defaultValue: Any): Any{
        return when (defaultValue){
            is String -> sharedPreferences.getString(key,defaultValue)
            is Boolean -> sharedPreferences.getBoolean(key,defaultValue)
            is Int -> sharedPreferences.getInt(key, defaultValue)
            is Float -> sharedPreferences.getFloat(key,defaultValue)
            is Long -> sharedPreferences.getLong(key,defaultValue)
            else -> throw IllegalArgumentException("no es posible obtener este tipo de dato")
        }!!
    }

    fun removePref(key: String){
        val editor = sharedPreferences.edit()
        editor.remove(key)
        editor.apply()
    }
}


