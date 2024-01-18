package com.alexblanco.examen_alex

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alexblanco.examen_alex.database.Student

class MostrarViewModel : ViewModel() {

    /*private var _students = MutableLiveData<List<Student>>()
    var students: LiveData<List<Student>> = _students*/

    var students: LiveData<List<Student>>? = null

    fun obtenirStudent(context: Context) : LiveData<List<Student>>? {

        students = Repository.getStudent(context)

        return students
    }
}