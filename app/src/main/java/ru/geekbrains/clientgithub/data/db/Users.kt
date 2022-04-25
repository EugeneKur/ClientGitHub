package ru.geekbrains.clientgithub.data.db

import ru.geekbrains.clientgithub.R
import ru.geekbrains.clientgithub.data.Title
import ru.geekbrains.clientgithub.data.User
import ru.geekbrains.clientgithub.domain.GitProjectEntity

class Users {
    val users: List<User> = listOf(
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