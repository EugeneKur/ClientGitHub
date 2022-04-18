package ru.geekbrains.clientgithub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.geekbrains.clientgithub.R
import ru.geekbrains.clientgithub.databinding.ActivityMainBinding
import ru.geekbrains.clientgithub.ui.listUsers.ListUsersFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, ListUsersFragment.newInstance())
            .commit()
    }
}