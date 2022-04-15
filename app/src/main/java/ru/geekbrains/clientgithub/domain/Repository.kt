package ru.geekbrains.clientgithub.domain

import ru.geekbrains.clientgithub.data.User

interface Repository {
    fun getUserFromServer(): User

    fun getUserFromLocalStorage(): List<User>

}