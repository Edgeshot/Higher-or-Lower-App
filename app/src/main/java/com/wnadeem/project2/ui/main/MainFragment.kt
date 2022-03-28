package com.wnadeem.project2.ui.main

import android.graphics.Color
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
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wnadeem.project2.model.Phrase

class MainFragment : Fragment() {

    private lateinit var recycler: RecyclerView
    private lateinit var definitionTextView: TextView
    private lateinit var cardView: CardView
    private lateinit var StartGameBtn: Button



    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        StartGameBtn = view.findViewById(R.id.StartGameBtn)

        StartGameBtn.setOnClickListener{
            view.findNavController().navigate(R.id.action_mainFragment_to_gameFragment)
        }



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)



        viewModel.vocabulary.observe(viewLifecycleOwner){
            recycler.adapter = ColorAdapter(it)
        }

        recycler = view.findViewById(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(context)



        definitionTextView = view.findViewById(R.id.definition_textView)
        definitionTextView.text = ""



    }

    private inner class ColorViewHolder(view:View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private lateinit var phrase: Phrase
        private var wordTextView: TextView = itemView.findViewById(R.id.term_textView)
        private var cardView: CardView = itemView.findViewById(R.id.CardView)
        var navController: NavController? = null




        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            //definitionTextView.text =  "Color ID = "+ phrase.colorId.toString() + "\n" + "Color Name = " +phrase.name + "\n" +"ColorHex = " + phrase.hexString.toString()
            cardView.setOnClickListener{ view ->
                //view.findNavController().navigate(R.id.action_mainFragment_to_settingsFragment)
            }



        }
        fun bind(phrase: Phrase) {
            this.phrase = phrase

            wordTextView.text = phrase.name
           // cardView.setCardBackgroundColor()
        }

    }

    private inner class ColorAdapter(private val list: List<Phrase>) : RecyclerView.Adapter<ColorViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
            val view = layoutInflater.inflate(R.layout.recycler_item, parent, false)
            return ColorViewHolder(view)

        }

        override fun getItemCount() = list.size

        override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
            holder.bind(list[position])
            lateinit var phrase: Phrase





        }
    }


}