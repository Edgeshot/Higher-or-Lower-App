package com.wnadeem.project2.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    private var _gameinfo = MutableLiveData("You have to guess if the next number is higher or lower than the one on screen")
    val gameinfo: LiveData<String> = _gameinfo

    fun newgameinfo(newinfo: String){
        _gameinfo.value = newinfo
    }

    private var _textColor = MutableLiveData("white")
    val textColor :LiveData<String> = _textColor
    fun newTextColor(color:String){
        _textColor.value = color
    }

    private var _level = MutableLiveData("Noob")
    val level:LiveData<String> = _level
    fun updateLevel(newLevel:String){
        _level.value = newLevel
    }

}