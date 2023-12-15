package com.cristianurbano.game_pruebaapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cristianurbano.game_pruebaapp.Models.UserModel
import com.cristianurbano.game_pruebaapp.data.prefs.SharedPreferencesManager
import com.cristianurbano.game_pruebaapp.data.sqlite.query.AuthQuery
import com.cristianurbano.game_pruebaapp.data.sqlite.query.UserQuery
import com.cristianurbano.game_pruebaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: SharedPreferencesManager
    private lateinit var queryAuth: AuthQuery
    private lateinit var queryUser: UserQuery

    private var user = ""
    private var password = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        sharedPref = SharedPreferencesManager(this)
        queryAuth = AuthQuery(this)
        queryUser = UserQuery(this)
        setContentView(binding.root)

        initUI()
    }
    //Inicializar Diseño

    private fun initUI(){
        setupListeners()
    }

    private fun setupListeners(){
        binding.btnLogin.setOnClickListener{
            user = binding.etUser.text.toString()
            password = binding.etPassword.text.toString()
            sharedPref.savePref("userNameKey", user)

            //Intencion de pasar de una actividad a otra

            if (validateForm()) {
                val user = UserModel(
                    name = "Andres Felipe",
                    identification = "121",
                    phone = "32172517353",
                    email = "gsamdev@gmail.com",
                    userName = "gsamdev",
                    role = "adminnn",
                    password = "123"
                )
                //queryUser.insertUser(user)
                loginAuth()
            }
        }
    }

    private fun loginAuth() {
        /*val response = queryAuth.login(usuario, contrasenia)
        if (response != null) {*/
        sharedPref.savePref("userIsLoggedKey", true)
        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra("userName", user)
        startActivity(intent)
        finish()
        //}
    }
    //Validacion de formulario

    private fun validateForm(): Boolean {
        return if (binding.etUser.text.toString().isEmpty() or
            binding.etPassword.text.toString().isEmpty()){
            Toast.makeText(this, " Please enter User and Password ",
                Toast.LENGTH_SHORT).show()
            false
        }else{
            true
        }
    }

}