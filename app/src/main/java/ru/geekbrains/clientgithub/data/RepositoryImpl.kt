package ru.geekbrains.clientgithub.data

import android.content.Context
import com.example.retrofitrx.data.retrofit.GitHubApi
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.geekbrains.clientgithub.domain.GitProjectEntity
import ru.geekbrains.clientgithub.domain.Repository

class RepositoryImpl : Repository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api: GitHubApi = retrofit.create(GitHubApi::class.java)

    override fun getUserFromServer(name: String): Single<List<GitProjectEntity>> {
        return api.listRepos(name)
    }

    override fun getUserFromLocalStorage(): List<User> {
        return getUsers()
    }

    override fun getPojectsUsersFromLocalStorage(name: String): List<String> {
        return getProjectsUser(name)
    }

}