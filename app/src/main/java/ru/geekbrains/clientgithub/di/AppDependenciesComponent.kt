package ru.geekbrains.clientgithub.di

import dagger.Component
import ru.geekbrains.clientgithub.ui.cardUsers.CardUserFragment
import ru.geekbrains.clientgithub.ui.listUsers.ListUsersFragment
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppDependenciesModule::class
    ]
)
interface AppDependenciesComponent {
    fun injectList(listUserFragment: ListUsersFragment)
    fun injectCard(cardUserFragment: CardUserFragment)
}