package com.wnadeem.project2.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.wnadeem.project2.R

class ResultFragment : Fragment() {
    private lateinit var UserScore: TextView
    private lateinit var PlayAgainBtn: Button

    private val args by navArgs<ResultFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_result, container, false)
        UserScore = view.findViewById(R.id.UserScore)
        PlayAgainBtn = view.findViewById(R.id.PlayAgainBtn)

        PlayAgainBtn.setOnClickListener{
            view.findNavController().navigate(R.id.action_resultFragment_to_titleFragment)
        }

    return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { args ->
            val safeArgs = ResultFragmentArgs.fromBundle(args)
            val answers = safeArgs.score
            UserScore.text = answers.toString()
        }
    }

}