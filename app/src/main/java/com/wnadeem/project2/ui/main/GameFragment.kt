package com.wnadeem.project2.ui.main

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.graphics.translationMatrix
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.wnadeem.project2.R
import kotlinx.coroutines.delay

class GameFragment : Fragment() {
    var num = 0
    var oldnum = 0
    var score = 0
    private lateinit var HigherBtn: Button
    private lateinit var LowerBtn: Button
    private lateinit var EndGameBtn: Button
    private lateinit var Number: TextView
    private lateinit var level: TextView
    private val sharedViewModel: SharedViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game, container, false)
        HigherBtn = view.findViewById(R.id.HigherBtn)
        LowerBtn = view.findViewById(R.id.lowerBtn)
        EndGameBtn = view.findViewById(R.id.EndGameBtn)
        Number = view.findViewById(R.id.Number)
        level = view.findViewById(R.id.level)
        sharedViewModel.textColor.observe(viewLifecycleOwner) {
            when (it) {
                "black" -> {
                    HigherBtn.setTextColor(resources.getColor(R.color.black))
                    LowerBtn.setTextColor(resources.getColor(R.color.black))
                    EndGameBtn.setTextColor(resources.getColor(R.color.black))
                    level.setTextColor(resources.getColor(R.color.black))

                }
                "white" -> {
                    HigherBtn.setTextColor(resources.getColor(R.color.white))
                    LowerBtn.setTextColor(resources.getColor(R.color.white))
                    EndGameBtn.setTextColor(resources.getColor(R.color.white))
                    level.setTextColor(resources.getColor(R.color.white))

                }
                "red" -> {
                    HigherBtn.setTextColor(resources.getColor(R.color.red))
                    LowerBtn.setTextColor(resources.getColor(R.color.red))
                    EndGameBtn.setTextColor(resources.getColor(R.color.red))
                    level.setTextColor(resources.getColor(R.color.red))

                }

            }
        }
        level.text = sharedViewModel.level.value


        HigherBtn.setOnClickListener{

            HigherBtn.animate().apply{
                duration = 300
                translationYBy(-25f)

            }.withEndAction{
                HigherBtn.animate().apply{
                    duration = 300
                    translationYBy(25f)

                }.start()
            }
            loseanimation2(LowerBtn)
            oldnum = num
            num = (0..10).shuffled().first()
            if (num < oldnum){
                //view.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
                val action: NavDirections = GameFragmentDirections.actionGameFragmentToResultFragment(score)
                Navigation.findNavController(HigherBtn).navigate(action)
            }
            else score +=1
            Number.text = num.toString()
            Number.animate().apply {
                duration = 300
                rotationXBy(360f)
            }.start()
        }
        LowerBtn.setOnClickListener {
            LowerBtn.animate().apply {
                duration = 300
                translationYBy(25f)

            }.withEndAction {
                LowerBtn.animate().apply {
                    duration = 300
                    translationYBy(-25f)
                }.start()

                loseanimation(HigherBtn)

                oldnum = num
                num = (0..10).shuffled().first()
                if (num > oldnum) {
                    val action: NavDirections =
                        GameFragmentDirections.actionGameFragmentToResultFragment(score)
                    Navigation.findNavController(LowerBtn).navigate(action)
                } else score += 1
                Number.text = num.toString()
                Number.animate().apply {
                    duration = 300
                    rotationXBy(360f)
                }.start()
            }
        }
            EndGameBtn.setOnClickListener {
                val action: NavDirections =
                    GameFragmentDirections.actionGameFragmentToResultFragment(score)
                Navigation.findNavController(EndGameBtn).navigate(action)
            }


        return view
    }

    fun loseanimation(text: Button){
        val animator = ObjectAnimator.ofFloat(text,"translationX",100f)
        val animator2 = ObjectAnimator.ofFloat(text,"translationX",-100f)
        val animator3 = ObjectAnimator.ofFloat(text,"translationX",15f)
        val set = AnimatorSet()
        set.play(animator).before(animator2)
        set.play(animator2).before(animator3)
        set.duration = 300L
        set.start()
    }

    fun loseanimation2(text: Button){
        val animator = ObjectAnimator.ofFloat(text,"translationX",-100f)
        val animator2 = ObjectAnimator.ofFloat(text,"translationX",100f)
        val animator3 = ObjectAnimator.ofFloat(text,"translationX",-15f)
        val set = AnimatorSet()
        set.play(animator).before(animator2)
        set.play(animator2).before(animator3)
        set.duration = 300L
        set.start()
    }



}