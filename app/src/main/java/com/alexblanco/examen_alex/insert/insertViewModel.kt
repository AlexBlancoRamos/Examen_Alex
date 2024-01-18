package com.alexblanco.examen_alex.insert

import android.content.Context
import androidx.lifecycle.ViewModel
import com.alexblanco.examen_alex.Repository
import com.alexblanco.examen_alex.database.Student

class insertViewModel: ViewModel() {

    fun newStudent(context: Context, nom:String, grup:String, nota: Int) {

        val student= Student(null, nom, grup, nota)

        Repository.insertStudent(context, student)
    }
}