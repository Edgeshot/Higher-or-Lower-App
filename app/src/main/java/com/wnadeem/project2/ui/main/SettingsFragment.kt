package com.wnadeem.project2.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.wnadeem.project2.R
import com.wnadeem.project2.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {
    private lateinit var BackBtn: Button
    private var _binding:FragmentSettingsBinding ? =null
    private val binding get() = _binding!!
    private val sharedViewModel:SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        sharedViewModel.textColor.observe(viewLifecycleOwner){
            when(it){
                "white" ->{
                    binding.textView2.setTextColor(resources.getColor(R.color.white))
                    binding.set.setTextColor(resources.getColor(R.color.white))
                }
                "black" -> {
                    binding.textView2.setTextColor(resources.getColor(R.color.black))
                    binding.set.setTextColor(resources.getColor(R.color.black))

                }
                "red" ->{
                    binding.textView2.setTextColor(resources.getColor(R.color.red))
                    binding.set.setTextColor(resources.getColor(R.color.red))
                }
            }
        }
        binding.radioGroup.setOnCheckedChangeListener { group, id ->
            val button:RadioButton = group.findViewById(id)
            var selection = group.indexOfChild(button)
            when(selection){
                0-> sharedViewModel.newTextColor("white")
                1-> sharedViewModel.newTextColor("black")
                2-> sharedViewModel.newTextColor("red")
            }

        }


        binding.BackBtn.setOnClickListener{
            findNavController().navigate(R.id.action_settingsFragment_to_titleFragment)
        }

    return binding.root
    }


}