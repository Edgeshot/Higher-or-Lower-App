package com.wnadeem.project2.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.wnadeem.project2.R
import androidx.appcompat.app.AppCompatActivity

class MainFragment : Fragment() {


    private lateinit var viewModel: MainViewModel
    private lateinit var ToConfigBtn: Button
    private lateinit var ToSettingsBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        ToConfigBtn = view.findViewById(R.id.ToConfigBtn)
        ToSettingsBtn = view.findViewById(R.id.ToSettingsBtn)

        ToConfigBtn.setOnClickListener{
            view.findNavController().navigate(R.id.action_mainFragment_to_configFragment)
        }
        ToSettingsBtn.setOnClickListener{
            view.findNavController().navigate(R.id.action_mainFragment_to_settingsFragment)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

     //   arguments?.let { args ->
     //       val safeArgs = MainFragmentArgs.fromBundle(args)
     //       val answers = safeArgs.toolname
     //       tooltext.text = answers}
    }

}