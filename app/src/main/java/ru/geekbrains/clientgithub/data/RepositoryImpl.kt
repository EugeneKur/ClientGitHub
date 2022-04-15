package ru.geekbrains.clientgithub.data

import ru.geekbrains.clientgithub.domain.Repository

class RepositoryImpl: Repository {
    override fun getUserFromServer(): User {
        return User()
    }

    override fun getUserFromLocalStorage(): List<User> {
        return getUsers()
    }

}