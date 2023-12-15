package com.cristianurbano.game_pruebaapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.cristianurbano.game_pruebaapp.data.prefs.SharedPreferencesManager
import com.cristianurbano.game_pruebaapp.databinding.ActivityMenuBinding
import com.cristianurbano.game_pruebaapp.ui.game.GameActivity


class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    private var userName = ""
    private lateinit var sharedPref: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(LayoutInflater.from(this))
        sharedPref = SharedPreferencesManager(this)

        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        setupGetPrefs()
        setupClickListeners()
    }

    private fun setupClickListeners() {

        binding.btnPlay.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        binding.btnScore.setOnClickListener {
            val intent = Intent(this, ScoreActivity::class.java)
            startActivity(intent)
        }

    }



    private fun setupGetPrefs() {
        userName = sharedPref.getPref("userNameKey", "Empty").toString()
        binding.tvUser.text = userName
    }


}