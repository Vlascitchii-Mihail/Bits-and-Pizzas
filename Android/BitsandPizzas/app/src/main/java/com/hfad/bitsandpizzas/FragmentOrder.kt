package com.hfad.bitsandpizzas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.hfad.bitsandpizzas.databinding.ActivityMainBinding
import com.hfad.bitsandpizzas.databinding.FragmentOrderBinding

/**
 * A simple [Fragment] subclass.
 */
class FragmentOrder : Fragment() {

    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using View binding
        _binding = FragmentOrderBinding.inflate(inflater, container, false)

        binding.apply {

            //setSupportActionBar(toolbar) in the fragment
            (activity as AppCompatActivity).setSupportActionBar(toolbar)

            fab.setOnClickListener {
                val pizzaType = pizzaGroup.checkedRadioButtonId
                if (pizzaType == -1) {
                    Toast.makeText(activity, "The pizza hasn't been checked", Toast.LENGTH_SHORT).show()
                } else {
                    var text = when (pizzaType) {
                        R.id.radio_diavolo -> "Diavolo pizza"
                        else -> "Funghi pizza"
                    } + if (parmesan.isChecked) ", extra parmesan" else ""
                    text += if (chiliOil.isChecked) ", extra chilli oil" else ""

                    Snackbar.make(fab, text, Snackbar.LENGTH_SHORT)

                            //make action if the snackbar was clicked
                        .setAction("Undo") {
                            Toast.makeText(activity, "The pizza hasn't been checked", Toast.LENGTH_SHORT).show()

                            //change the place of the snackbar
                        }.show()
                }
            }

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}