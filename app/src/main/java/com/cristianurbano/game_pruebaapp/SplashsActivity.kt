package com.cristianurbano.game_pruebaapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.cristianurbano.game_pruebaapp.data.prefs.SharedPreferencesManager
import com.cristianurbano.game_pruebaapp.databinding.ActivitySplashsBinding
import com.cristianurbano.game_pruebaapp.ui.MainActivity
import com.cristianurbano.game_pruebaapp.ui.MenuActivity

@SuppressLint("CustomSplashScreen")
class   SplashsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashsBinding
    private lateinit var sharedPref: SharedPreferencesManager
    private val timeSplash = 3000L
    private var userIsLogged = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashsBinding.inflate(LayoutInflater.from(this))
        sharedPref= SharedPreferencesManager(this)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        setupJumpNextActivity()
        setupGetPrefs()

    }

    private fun setupGetPrefs() {
        userIsLogged=sharedPref.getPref("userIsLoggedkey", false) as Boolean
    }

    private fun setupJumpNextActivity() {
        Looper.myLooper()?.let { looper ->
            Handler(looper).postDelayed({
                if (userIsLogged){
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                }else{
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }, timeSplash)
        }
    }
}