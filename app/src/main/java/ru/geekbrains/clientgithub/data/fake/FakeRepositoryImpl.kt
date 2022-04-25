package ru.geekbrains.clientgithub.data.fake

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.clientgithub.R
import ru.geekbrains.clientgithub.data.Title
import ru.geekbrains.clientgithub.data.User
import ru.geekbrains.clientgithub.data.db.Users
import ru.geekbrains.clientgithub.domain.GitProjectEntity
import ru.geekbrains.clientgithub.domain.Repository

class FakeRepositoryImpl: Repository {
    override fun getProjectsUserFromServer(name: String): Single<List<GitProjectEntity>> {
        val dummyList = listOf(
            GitProjectEntity(0, "grgsth"),
            GitProjectEntity(1, "aerha"),
            GitProjectEntity(2, "aerhban"),
            GitProjectEntity(3, "ath"),
            GitProjectEntity(4, "rtdhz"),
            GitProjectEntity(5, "zdfnfmj"),
        )

        return Single.just(dummyList)
    }

    override fun getUserFromLocalStorage(): List<User> {
        return getUsers()
    }

}

private fun getUsers(): List<User> {
    return Users().users
}
