package com.cristianurbano.game_pruebaapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristianurbano.game_pruebaapp.data.sqlite.query.UserQuery
import com.cristianurbano.game_pruebaapp.databinding.ActivityListUserBinding
import com.cristianurbano.game_pruebaapp.ui.adapter.UserAdapter

class ListUserActivity : AppCompatActivity() {

    private lateinit var userQuery: UserQuery
    private lateinit var binding: ActivityListUserBinding

    private lateinit var userAdapter: UserAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListUserBinding.inflate(LayoutInflater.from(this))
        userQuery = UserQuery(this)
        setContentView(binding.root)

        initUI()

    }

    private fun initUI() {

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val listUsers = userQuery.listAllUsers()
        userAdapter = UserAdapter(listUsers, this)
        recyclerView = binding.rvUsers
        //recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = userAdapter
    }
    }
