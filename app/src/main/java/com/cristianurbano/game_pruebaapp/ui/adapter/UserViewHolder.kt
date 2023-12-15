package com.cristianurbano.game_pruebaapp.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cristianurbano.game_pruebaapp.Models.UserModel
import com.cristianurbano.game_pruebaapp.databinding.ItemUserBinding


class UserViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemUserBinding.bind(view)
    fun render(userModel: UserModel) {
        binding.txtNameUser.text = userModel.name
        binding.txtPhone.text = userModel.phone
    }



}