package com.alexblanco.examen_alex

import android.content.Context
import androidx.lifecycle.LiveData
import com.alexblanco.examen_alex.database.Student
import com.alexblanco.examen_alex.database.StudentDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository {
    companion object {

        var studentDatabase: StudentDatabase? = null

        fun initializeDB(context: Context): StudentDatabase {
            return StudentDatabase.getDatabase(context)
        }


        fun insertStudent(context: Context, student: Student) {

            studentDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                studentDatabase!!.studentDao().addStudent(student)
            }
        }

        fun getStudent(context: Context): LiveData<List<Student>>? {

            studentDatabase = initializeDB(context)

            return studentDatabase!!.studentDao().getStudent()
        }


        fun getStudentName(context: Context, name: String): LiveData<List<Student>>? {

            studentDatabase = initializeDB(context)

            return studentDatabase!!.studentDao().getStudentByName(name)
        }

        fun getStudentByNote(context: Context, nota: Int): LiveData<List<Student>>? {

            studentDatabase = initializeDB(context)

            return studentDatabase!!.studentDao().getStudentByNote(nota)
        }

        fun getStudentByNote2(context: Context, nota: Int): LiveData<List<Student>>? {

            studentDatabase = initializeDB(context)

            return studentDatabase!!.studentDao().getStudentByNote2(nota)
        }
    }
}