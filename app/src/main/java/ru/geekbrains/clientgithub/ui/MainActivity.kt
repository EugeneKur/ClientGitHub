package ru.geekbrains.clientgithub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.geekbrains.clientgithub.data.RepositoryImpl
import ru.geekbrains.clientgithub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.usersRecyclerView.adapter = UsersAdapter(RepositoryImpl().getUserFromLocalStorage())
    }
}