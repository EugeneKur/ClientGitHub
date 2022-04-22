package ru.geekbrains.clientgithub

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import ru.geekbrains.clientgithub.data.RepositoryImpl
import ru.geekbrains.clientgithub.domain.Repository
import ru.geekbrains.clientgithub.utils.ViewModelStore

class App : Application() {
    val gitProjectsRepo: Repository by lazy { RepositoryImpl() }
    val viewModelStore by lazy { ViewModelStore() }
}

val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app
