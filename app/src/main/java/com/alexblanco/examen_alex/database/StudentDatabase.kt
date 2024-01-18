package com.alexblanco.examen_alex.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Student::class],
    version = 1,
    exportSchema = false
)

abstract class StudentDatabase  : RoomDatabase(){
    abstract fun studentDao() : StudentDAO

    companion object {

        @Volatile
        private var INSTANCE: StudentDatabase? = null

        fun getDatabase(context: Context): StudentDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): StudentDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                StudentDatabase::class.java,
                "student_database"
            )
                .build()
        }
    }
}