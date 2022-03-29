package com.wnadeem.project2.ui.main

import android.content.res.Resources
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.wnadeem.project2.R
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.wnadeem.project2.R.color
import com.wnadeem.project2.R.color.*

class TitleFragment : Fragment() {


    private lateinit var viewModel: MainViewModel
    private lateinit var ToConfigBtn: Button
    private lateinit var ToSettingsBtn: Button
    private lateinit var Title: TextView
    private val sharedViewModel:SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_title, container, false)
        ToConfigBtn = view.findViewById(R.id.ToConfigBtn)
        ToSettingsBtn = view.findViewById(R.id.ToSettingsBtn)
        Title = view.findViewById(R.id.Title)
        sharedViewModel.textColor.observe(viewLifecycleOwner){
            when (it){
                "black"->{
                    ToConfigBtn.setTextColor(resources.getColor(R.color.black))
                    Title.setTextColor(resources.getColor(R.color.black))
                    ToSettingsBtn.setTextColor(resources.getColor(R.color.black))
                }
                "white"->{
                    ToConfigBtn.setTextColor(resources.getColor(R.color.white))
                    Title.setTextColor(resources.getColor(R.color.white))
                    ToSettingsBtn.setTextColor(resources.getColor(R.color.white))
                }
                "red"->{
                    ToConfigBtn.setTextColor(resources.getColor(R.color.red))
                    Title.setTextColor(resources.getColor(R.color.red))
                    ToSettingsBtn.setTextColor(resources.getColor(R.color.red))
                }

            }
        }

        ToConfigBtn.setOnClickListener{
            view.findNavController().navigate(R.id.action_titleFragment_to_mainFragment)
        }
        ToSettingsBtn.setOnClickListener{
            view.findNavController().navigate(R.id.action_titleFragment_to_settingsFragment)
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
