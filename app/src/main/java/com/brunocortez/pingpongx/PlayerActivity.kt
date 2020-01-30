package com.brunocortez.pingpongx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brunocortez.pingpongx.extensions.hideKeyboard
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        btStart.setOnClickListener { startPressed() }
        clRoot.setOnClickListener { hideKeyboard() }
    }

    private fun startPressed() {
        hideKeyboard()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(KEY_PLAYER_ONE, etPlayer1.text.toString())
        intent.putExtra(KEY_PLAYER_TWO, etPlayer2.text.toString())
        startActivity(intent)
        finish()
    }
}
