package ru.geekbrains.clientgithub.data.web.github


import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.geekbrains.clientgithub.domain.GitProjectEntity

interface GitHubApi {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Single<List<GitProjectEntity>>
}