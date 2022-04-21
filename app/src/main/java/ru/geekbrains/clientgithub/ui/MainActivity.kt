package ru.geekbrains.clientgithub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.geekbrains.clientgithub.data.User
import ru.geekbrains.clientgithub.databinding.ActivityMainBinding
import ru.geekbrains.clientgithub.ui.cardUsers.CardUserFragment
import ru.geekbrains.clientgithub.ui.listUsers.ListUsersFragment

class MainActivity : AppCompatActivity(), ListUsersFragment.Controller {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(binding.mainContainer.id, ListUsersFragment.newInstance())
            .commit()
    }

    override fun openScreen(user: User) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(
                binding.mainContainer.id,
                CardUserFragment.newInstance(user)
            )
            .commit()
    }
}