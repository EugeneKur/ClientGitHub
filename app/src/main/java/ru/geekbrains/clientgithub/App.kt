package ru.geekbrains.clientgithub

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import ru.geekbrains.clientgithub.di.appModule
import ru.geekbrains.clientgithub.utils.ViewModelStore

class App : Application() {

    val viewModelStore by lazy { ViewModelStore() }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}

val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app
