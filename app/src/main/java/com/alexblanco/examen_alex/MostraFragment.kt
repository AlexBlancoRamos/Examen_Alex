package com.alexblanco.examen_alex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexblanco.examen_alex.databinding.FragmentMostraBinding
import com.alexblanco.examen_alex.MostraFragment as MostraFragment1

class MostraFragment : Fragment() {

    private lateinit var binding: FragmentMostraBinding;

    private lateinit var mostrarVM : MostrarViewModel;

    private lateinit var recyclerview: RecyclerView

    lateinit var switch: Switch

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_mostra, container, false
        )

        mostrarVM = ViewModelProvider(this).get(MostrarViewModel::class.java)

        switch = binding.switch1

        recyclerview = binding.recyclerView
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.setHasFixedSize(true)
        mostrarVM.obtenirStudent(requireContext())
        mostrarVM.students?.observe(viewLifecycleOwner) { listStudents ->}



        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(getActivity(), "Aprovats", Toast.LENGTH_SHORT).show();
                //Cridar els metodes perque mostri nomes els aprovats
            } else {
                Toast.makeText(getActivity(), "Suspesos", Toast.LENGTH_SHORT).show();
                //Cridar els metodes perque mostri nomes els suspesos

            }
        }

        return binding.root
    }
}