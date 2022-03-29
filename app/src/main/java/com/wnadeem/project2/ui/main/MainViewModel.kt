package com.wnadeem.project2.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wnadeem.project2.model.Phrase
import com.wnadeem.project2.model.WordList

private const val TAG = "MainViewModel"
class MainViewModel(app: Application) : AndroidViewModel(app) {

    private lateinit var wordList: WordList

    private val _vocabulary = MutableLiveData<List<Phrase>>()
    var vocabulary: LiveData<List<Phrase>> = _vocabulary

    init {
        val jsonString = app.assets.open("data1.json").bufferedReader().use { it.readText() }
        wordList = WordList(jsonString)

        _vocabulary.value = wordList.terms
        Log.d(TAG, wordList.terms.toString())
    }


}
