package com.alexblanco.examen_alex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexblanco.examen_alex.database.Student

class MostrarAdapter(private val students: List<Student>, private val onItemClick: (Student) -> Unit) :
    RecyclerView.Adapter<MostrarAdapter.MostarViewHolder>() {

    class MostarViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nom: TextView = view.findViewById(R.id.textViewNom)
        val grup: TextView = view.findViewById(R.id.textViewGrup)
        val nota: TextView = view.findViewById(R.id.textViewNota)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false) // Usa tu CardView aquí
        return MostarViewHolder(view)
    }

    override fun onBindViewHolder(holder: MostarViewHolder, position: Int) {
        val student = students[position]

        holder.itemView.setOnClickListener {
            onItemClick.invoke(student)
        }

        holder.nom.text = student.name
        holder.grup.text = student.grup
        holder.nota.text = student.note.toString()
    }

    override fun getItemCount() = students.size
}