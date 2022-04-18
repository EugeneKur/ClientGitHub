package ru.geekbrains.clientgithub.domain

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.clientgithub.data.User


interface Repository {
    fun getUserFromServer(name: String): Single<List<GitProjectEntity>>

    fun getUserFromLocalStorage(): List<User>

    fun getPojectsUsersFromLocalStorage(name: String): List<String>
}