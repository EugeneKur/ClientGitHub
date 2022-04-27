package com.example.retrofitrx.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.geekbrains.clientgithub.domain.Repository
import ru.geekbrains.clientgithub.ui.cardUsers.CardUserViewModel


class CardUserViewModelFactory(private val id: String, private val repo: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CardUserViewModel(id, repo) as T
    }
}