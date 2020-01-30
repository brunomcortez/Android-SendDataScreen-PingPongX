package com.brunocortez.pingpongx.extensions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var player1Score = MutableLiveData<Int>().apply { this.value = 0 }
    var player2Score = MutableLiveData<Int>().apply { this.value = 0 }

    init {
        rematch()
    }

    fun goalPlayer1() {
        player1Score.value = player1Score.value?.plus(1)
    }

    fun goalPlayer2() {
        player2Score.value = player2Score.value?.plus(1)
    }

    fun rematch() {
        player1Score.value = 0
        player2Score.value = 0
    }

}