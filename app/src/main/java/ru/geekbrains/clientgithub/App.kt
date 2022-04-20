package ru.geekbrains.clientgithub

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import ru.geekbrains.clientgithub.data.RepositoryImpl
import ru.geekbrains.clientgithub.domain.Repository

class App: Application() {
    val gitProjectsRepo: Repository by lazy {RepositoryImpl()}

    companion object {

    }
}


val Context.app: App
    get() = applicationContext as App
