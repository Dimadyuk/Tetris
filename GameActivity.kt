package com.example.tetris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.tetris.storage.AppPreferences

class GameActivity : AppCompatActivity() {
    var tvHighScore: TextView? = null
    var tvCurrentScore: TextView? = null
    var appPreferences: AppPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        supportActionBar?.hide()

        val btnRestart = findViewById<Button>(R.id.btn_restart)
        tvHighScore = findViewById(R.id.tv_high_score_game)
        tvCurrentScore = findViewById(R.id.tv_current_score_game)

        updateHighScore()
        updateCurrentScore()
    }

    fun updateHighScore(){
        tvHighScore?.text = "${appPreferences?.getHighScore()}"
    }

    fun updateCurrentScore(){
        tvCurrentScore?.text = "0"
    }
}