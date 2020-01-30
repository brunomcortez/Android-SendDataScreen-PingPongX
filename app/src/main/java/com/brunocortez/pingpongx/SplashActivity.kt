package com.brunocortez.pingpongx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({ startPlayerActivity() }, 2000)
    }

    private fun startPlayerActivity() {
        startActivity(Intent(this, PlayerActivity::class.java))
        finish()
    }

}
