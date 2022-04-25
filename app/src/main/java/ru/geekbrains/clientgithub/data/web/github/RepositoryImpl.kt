package ru.geekbrains.clientgithub.data.web.github

import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.geekbrains.clientgithub.R
import ru.geekbrains.clientgithub.data.Title
import ru.geekbrains.clientgithub.data.User
import ru.geekbrains.clientgithub.domain.GitProjectEntity
import ru.geekbrains.clientgithub.domain.Repository

class RepositoryImpl : Repository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api: GitHubApi = retrofit.create(GitHubApi::class.java)

    override fun getProjectsUserFromServer(name: String): Single<List<GitProjectEntity>> {
        return api.listRepos(name)
    }

    override fun getUserFromLocalStorage(): List<User> {
        return getUsers()
    }
}

fun getUsers(): List<User> {
    return listOf(
        User(
            Title(
                "EugeneKur", 10, R.drawable.ic_baseline_face_24
            ),
            "Описание"
        ),
        User(
            Title(
                "User2", 10, R.drawable.ic_baseline_face_24
            ),
            "Описание"
        ),
        User(
            Title(
                "User3", 10, R.drawable.ic_baseline_face_24
            ), "Описание"
        ),
        User(
            Title(
                "User4", 10, R.drawable.ic_baseline_face_24
            ),
            "Описание"
        ),
        User(
            Title(
                "User5", 10, R.drawable.ic_baseline_face_24
            ), "Описание"
        ),
        User(
            Title(
                "User6", 10, R.drawable.ic_baseline_face_24
            ),
            "Описание"
        ),
        User(
            Title(
                "User7", 10, R.drawable.ic_baseline_face_24
            ),
            "Описание"
        ),
        User(
            Title(
                "User8", 10, R.drawable.ic_baseline_face_24
            ),
            "Описание"
        ),
    )
}