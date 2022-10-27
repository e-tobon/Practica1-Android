package com.etobon.mathapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.etobon.mathapplication.databinding.FragmentFormula2Binding
import com.etobon.mathapplication.databinding.FragmentFormula3Binding


class Formula3 : Fragment() {
    private var _binding: FragmentFormula3Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFormula3Binding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onStart() {
        super.onStart()
        binding.Fuerzabtn.setOnClickListener {
            var Status: Int = 0
            if (binding.etFuerza.text.isEmpty() && binding.etAceleracion.text.isNotEmpty()) {

                Status = 1

            } else if (binding.etAceleracion.text.isEmpty() && binding.etFuerza.text.isNotEmpty()) {

                Status = 2
            }
            else if (binding.etAceleracion.text.isEmpty() && binding.etFuerza.text.isEmpty()) {

                Status = 3
            }

            when (Status) {
                1 -> {binding.etFuerza.hint = "Ingrese la Masa"}
                2 -> {binding.etAceleracion.hint = "Ingrese el Aceleracion"}
                3 -> {binding.etFuerza.hint = "Ingrese la Masa"
                    binding.etAceleracion.hint = "Ingrese la Aceleracion"}
                else -> {
                    var masa: Float = binding.etFuerza.text.toString().toFloat()
                    var aceleracion:Float = binding.etAceleracion.text.toString().toFloat()
                    binding.Answertv.text =Fuerza(masa,aceleracion).toString()
                }

            }
        }




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun Fuerza(masaInput: Float, aceleracionInput: Float): Float {
        return masaInput * aceleracionInput

    }

}