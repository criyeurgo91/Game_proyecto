package com.cristianurbano.game_pruebaapp.ui.game


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.cristianurbano.game_pruebaapp.databinding.ActivityGameBinding
import com.cristianurbano.game_pruebaapp.ui.MenuActivity
import com.cristianurbano.game_pruebaapp.ui.ScoreActivity


class GameActivity : AppCompatActivity() {

    private lateinit var binding:ActivityGameBinding
    private var contPuntosA: Int = 0
    private var contPuntosB: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(LayoutInflater.from(this))

        setContentView(binding.root)
        initUI()
    }

    private fun initUI(){
            contA()
            contB()
            reset()
            finish()
        }

    private fun contA(){
        binding.btnPuntosA.setOnClickListener {
            if (contPuntosA < 25) {
                contPuntosA++
                binding.txtPuntosA.text = contPuntosA.toString()
            } else {
                // Lógica cuando se alcanzan 25 puntos
                mostrarGanador("Equipo A", contPuntosA)
            }
        }
    }

    private fun contB(){
        binding.btnPuntosB.setOnClickListener {
            if (contPuntosB < 25) {
                contPuntosB++
                binding.txtPuntosB.text = contPuntosB.toString()
            } else {
                // Lógica cuando se alcanzan 25 puntos
                mostrarGanador("Equipo B", contPuntosB)
            }
        }
    }

    private fun mostrarGanador(nombreEquipo: String, puntos: Int) {
        // Muestra un mensaje con el nombre del equipo ganador
        // y pasa a la actividad ScoreActivity
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra("nombreEquipo", nombreEquipo)
        intent.putExtra("puntos", puntos)
        startActivity(intent)
        finish() // Termina la actividad actual
    }

    private fun reset(){
        binding.btnReset.setOnClickListener {
            //resetear los contadores a 0
            contPuntosA = 0
            contPuntosB = 0

            binding.txtPuntosA.text= contPuntosA.toString()
            binding.txtPuntosB.text= contPuntosB.toString()
        }
    }

    override fun finish(){
        binding.btnFinish.setOnClickListener {
            //terminar partida
            val intent = Intent (this, MenuActivity::class.java)
            startActivity(intent)
        }
    }




    }
