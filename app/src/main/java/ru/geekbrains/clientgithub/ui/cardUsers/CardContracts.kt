package ru.geekbrains.clientgithub.ui.cardUsers

import ru.geekbrains.clientgithub.data.User

interface CardContracts {

    interface ViewModelContract {
        fun getProjects(user: User)
    }
}