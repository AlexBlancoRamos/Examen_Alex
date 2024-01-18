package com.alexblanco.examen_alex.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Student")
data class Student (

    @PrimaryKey(autoGenerate = true)
    var Id: Int? = null,
    @ColumnInfo(name = "Name")
    var name: String,
    @ColumnInfo(name = "Grup")
    var grup: String,
    @ColumnInfo(name = "Notes")
    var note: Int,
)