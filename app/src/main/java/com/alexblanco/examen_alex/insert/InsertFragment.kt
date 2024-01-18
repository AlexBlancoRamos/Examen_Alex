package com.alexblanco.examen_alex.insert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alexblanco.examen_alex.R
import com.alexblanco.examen_alex.databinding.FragmentInsert2Binding

class InsertFragment : Fragment() {

    private lateinit var binding: FragmentInsert2Binding;

    private lateinit var insertVModel: insertViewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_insert2, container, false
        )
        insertVModel=  ViewModelProvider(this).get(insertViewModel::class.java)

        binding.buttonInsert.setOnClickListener{

            insertVModel.newStudent(requireContext(),binding.editTextNom.text.toString(),binding.editTextGrup.text.toString(),binding.editTextNota.text.toString().toInt())

        }

        return binding.root
    }
}