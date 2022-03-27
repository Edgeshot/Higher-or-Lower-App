package com.wnadeem.project2.model

import com.google.gson.Gson
import android.util.Log

private const val TAG = "WordList"

data class Phrase(val colorId: Int, val hexString: String, val name: String)
class Vocabulary: ArrayList<Phrase>()


class WordList(jsonString: String) {

    var terms = ArrayList<Phrase>()

    init{
        val gson = Gson()
        terms = gson.fromJson(jsonString, Vocabulary:: class.java)
        Log.d(TAG, terms.toString())
    }
}