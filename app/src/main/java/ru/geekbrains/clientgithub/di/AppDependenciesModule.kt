package ru.geekbrains.clientgithub.di

import dagger.Module
import dagger.Provides
//import org.koin.core.qualifier.named
//import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.geekbrains.clientgithub.data.web.github.GitHubApi
import ru.geekbrains.clientgithub.data.web.github.RepositoryImpl
import ru.geekbrains.clientgithub.domain.Repository
import javax.inject.Singleton

//val appModule = module {
//
//    single<String>(named("api_github")) { "https://api.github.com/" }
//    single<Repository> { RepositoryImpl(get<GitHubApi>()) }
//    single<GitHubApi> { get<Retrofit>().create(GitHubApi::class.java) }
//    single<Retrofit> {
//        Retrofit.Builder()
//            .baseUrl(get<String>(named("api_github")))
//            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//            .addConverterFactory(get())
//            .build()
//    }
//    factory<Converter.Factory> { GsonConverterFactory.create() }
//
//}

@Module
class AppDependenciesModule {

    @Singleton
    @Provides
    fun provideGitHubApi(retrofit: Retrofit): GitHubApi {
        return retrofit.create(GitHubApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(api: GitHubApi): Repository {
        return RepositoryImpl(api)
    }

    @Provides
    fun provideBaseUrl(): String {
        return "https://api.github.com/"
    }

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(converterFactory)
            .build()
    }
}