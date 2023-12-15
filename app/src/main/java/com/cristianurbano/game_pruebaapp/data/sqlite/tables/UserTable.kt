package com.cristianurbano.game_pruebaapp.data.sqlite.tables

class UserTable {

    companion object{
        private const val NameTable_User = "User"
        const val CreateTable_User = "Create Table $NameTable_User" +
                " ( id INTEGER PRIMARY KEY AUTOINCREMENT , " +
                " name TEXT NOT NULL , " +
                " identification TEXT NOT NULL , " +
                " phone TEXT NOT NULL , " +
                " email TEXT NOT NULL , " +
                " userName TEXT NOT NULL , " +
                " role TEXT NOT NULL , " +
                " password TEXT NOT NULL ) "
        const val Select_User_Table =
            " SELECT id, name, identification, phone, email, userName, role FROM $NameTable_User"

    }
}