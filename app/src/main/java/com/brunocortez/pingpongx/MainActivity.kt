package com.brunocortez.pingpongx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.brunocortez.pingpongx.extensions.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.player1Score.observe(this, Observer { score -> updatePlayer1Score(score) })
        mainViewModel.player2Score.observe(this, Observer { score -> updatePlayer2Score(score) })

        btPlayer1Score.setOnClickListener { player1ScorePressed() }
        btPlayer2Score.setOnClickListener { player2ScorePressed() }
        btRematch.setOnClickListener { mainViewModel.rematch() }
        btFinishMatch.setOnClickListener { finish() }

        setupPlayers()
    }

    private fun player1ScorePressed() {
        mainViewModel.goalPlayer1()
    }

    private fun player2ScorePressed() {
        mainViewModel.goalPlayer2()
    }

    private fun setupPlayers() {
        tvPlayer1Name.text = intent.getStringExtra(KEY_PLAYER_ONE)
        tvPlayer2Name.text = intent.getStringExtra(KEY_PLAYER_TWO)
    }

    private fun updatePlayer1Score(score: Int) {
        tvPlayer1Score.text = score.toString()
    }

    private fun updatePlayer2Score(score: Int) {
        tvPlayer2Score.text = score.toString()
    }



}
