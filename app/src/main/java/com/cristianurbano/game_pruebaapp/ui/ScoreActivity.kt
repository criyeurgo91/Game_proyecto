package com.cristianurbano.game_pruebaapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cristianurbano.game_pruebaapp.R
import com.cristianurbano.game_pruebaapp.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recibe los datos del Intent
        val nombreEquipo = intent.getStringExtra("nombreEquipo")
        val puntos = intent.getIntExtra("puntos", 0)

        // Muestra el mensaje con el nombre del equipo ganador y los puntos
        val mensaje = "¡$nombreEquipo es el ganador con $puntos puntos!"
        binding.tvScore.text = mensaje
    }
}