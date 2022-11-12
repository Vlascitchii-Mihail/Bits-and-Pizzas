package com.hfad.bitsandpizzas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.hfad.bitsandpizzas.databinding.FragmentOrderBinding

/**
 * A simple [Fragment] subclass.
 */
class FragmentOrder : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentOrderBinding.inflate(inflater, container, false)

        binding.apply {

            //setSupportActionBar(toolbar) in the fragment
            (activity as AppCompatActivity).setSupportActionBar(toolbar)

            val pizzaType = pizzaGroup.checkedRadioButtonId
            if (pizzaType == -1) {
                //no item
            } else {
                //do something
            }
        }

        return binding.root
    }
}