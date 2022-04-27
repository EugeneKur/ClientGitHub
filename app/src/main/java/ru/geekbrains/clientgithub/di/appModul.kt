package ru.geekbrains.clientgithub.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.geekbrains.clientgithub.data.web.github.GitHubApi
import ru.geekbrains.clientgithub.data.web.github.RepositoryImpl
import ru.geekbrains.clientgithub.domain.Repository

val appModule = module {

    single<String>(named("api_github")) { "https://api.github.com/" }
    single<Repository> { RepositoryImpl(get<GitHubApi>()) }
    single<GitHubApi> { get<Retrofit>().create(GitHubApi::class.java) }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(get<String>(named("api_github")))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(get())
            .build()
    }
    factory<Converter.Factory> { GsonConverterFactory.create() }

}
