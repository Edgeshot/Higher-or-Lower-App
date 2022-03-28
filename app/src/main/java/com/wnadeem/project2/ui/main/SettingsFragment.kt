package com.wnadeem.project2.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.wnadeem.project2.R


class SettingsFragment : Fragment() {
    private lateinit var BackBtn: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        BackBtn = view.findViewById(R.id.BackBtn)

        BackBtn.setOnClickListener{
            view.findNavController().navigate(R.id.action_settingsFragment_to_titleFragment)
        }

    return view
    }


}