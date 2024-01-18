package com.alexblanco.examen_alex.database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface StudentDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addStudent(student: Student)

    @Query("SELECT * FROM Student ORDER BY Name DESC")
    fun getStudent(): LiveData<List<Student>>

    @Query("SELECT * FROM Student WHERE name = name ORDER BY name DESC")
    fun getStudentByName(name:String): LiveData<List<Student>>

    @Query("SELECT * FROM Student WHERE notes < 5 ORDER BY name DESC")
    fun getStudentByNote(nota:Int): LiveData<List<Student>>

    @Query("SELECT * FROM Student WHERE notes > 5 ORDER BY name DESC")
    fun getStudentByNote2(nota:Int): LiveData<List<Student>>
}