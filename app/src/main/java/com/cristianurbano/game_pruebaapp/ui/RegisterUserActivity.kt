package com.cristianurbano.game_pruebaapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.cristianurbano.game_pruebaapp.Models.UserModel
import com.cristianurbano.game_pruebaapp.data.sqlite.query.UserQuery
import com.cristianurbano.game_pruebaapp.databinding.ActivityRegisterUserBinding

class RegisterUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterUserBinding
    private lateinit var userQuery: UserQuery

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterUserBinding.inflate(LayoutInflater.from(this))
        userQuery = UserQuery(this)

        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnRegister.setOnClickListener {
            val name = binding.etUserForm.text.toString()
            val identification = binding.etIdentification.text.toString()
            val password = binding.etPasswordForm.text.toString()
            //Aqui le pasamos los datos de cada uno de nuestros datos recuperados del formulario
            //Falta adecuar el formulario para poder insertarle toda la informacion a la tabla usuarios

            /*Aqui le pasamos la informacion en el orden que este la data class UserModel*/
            val user = UserModel()
            userQuery.insertUser(user)
        }
    }
}