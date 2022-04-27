package ru.geekbrains.clientgithub.data.web.github

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.clientgithub.data.User
import ru.geekbrains.clientgithub.data.db.Users
import ru.geekbrains.clientgithub.domain.GitProjectEntity
import ru.geekbrains.clientgithub.domain.Repository

class RepositoryImpl(
    private val api: GitHubApi
) : Repository {
    override fun getProjectsUserFromServer(name: String): Single<List<GitProjectEntity>> {
        return api.listRepos(name)
    }

    override fun getUserFromLocalStorage(): List<User> {
        return Users().users
    }
}