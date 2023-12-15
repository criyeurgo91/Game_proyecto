package com.cristianurbano.game_pruebaapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristianurbano.game_pruebaapp.Models.UserModel
import com.cristianurbano.game_pruebaapp.R

class UserAdapter (private val listUser: List<UserModel>, private val context: Context) :
    RecyclerView.Adapter<UserViewHolder>() {

    //Sirve para inflar el diseño
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        )
    }

    //Sirve para el conteo de los elementos de la lista
    override fun getItemCount(): Int = listUser.size


    //sirve para mostrar la informacion en el diseño
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.render(listUser[position])
    }


}