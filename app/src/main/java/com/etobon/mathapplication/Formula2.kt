package com.etobon.mathapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import com.etobon.mathapplication.databinding.FragmentFormula2Binding



class Formula2 : Fragment() {
    private var _binding:FragmentFormula2Binding? = null
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
        _binding = FragmentFormula2Binding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onStart() {
        super.onStart()
        binding.btnPresion.setOnClickListener {
            var Status: Int = 0
            if (binding.etFuerza.text.isEmpty() && binding.etArea.text.isNotEmpty()) {

                Status = 1

            } else if (binding.etArea.text.isEmpty() && binding.etFuerza.text.isNotEmpty()) {

                Status = 2
            }
            else if (binding.etArea.text.isEmpty() && binding.etFuerza.text.isEmpty()) {

                Status = 3
            }

            when (Status) {
                1 -> {binding.etFuerza.hint = "Ingrese la Fuerza"}
                2 -> {binding.etArea.hint = "Ingrese el Area"}
                3 -> {binding.etFuerza.hint = "Ingrese la Fueza"
                    binding.etArea.hint = "Ingrese el Area"}
                else -> {
                    var fuerza: Float = binding.etFuerza.text.toString().toFloat()
                    var area:Float = binding.etArea.text.toString().toFloat()
                    binding.Answertv.text = Presion(fuerza,area).toString()
                }

            }
        }




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun Presion(fuerzaInput: Float, areaInput: Float): Float {
        return fuerzaInput / areaInput

    }


}