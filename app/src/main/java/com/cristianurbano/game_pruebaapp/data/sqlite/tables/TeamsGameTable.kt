package com.cristianurbano.game_pruebaapp.data.sqlite.tables

import com.cristianurbano.game_pruebaapp.data.helpers.Constants.Companion.NAME_TABLE_USERS

class TeamsGameTable {
    companion object{

        const val CREATE_TEAM_TABLE = " CREATE TABLE $NAME_TABLE_USERS " +
                " ( id INTEGER PRIMARY KEY AUTOINCREMENT , " +
                " name TEXT NOT NULL , " +
                " gamesPlayed TEXT NOT NULL , " +
                " matchesWon TEXT NOT NULL , " +
                " lostMatches TEXT NOT NULL ) "


        const val SELECT_TEAM_TABLE =
            " SELECT * FROM $NAME_TABLE_USERS "
    }
}