package ru.geekbrains.clientgithub.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import ru.geekbrains.clientgithub.R

@Parcelize
data class User(
    val title: Title = getDefaultTitle(),
    val about: String = "Описание пользователя"
) : Parcelable

@Parcelize
data class Title(
    val name: String = "User",
    val rating: Int = 0,
    val image: Int = R.drawable.ic_baseline_face_24,
    val projects: List<String> = listOf("3r", "wr")
) : Parcelable

fun getDefaultTitle() = Title("User", 10, R.drawable.ic_baseline_face_24)

fun getUsers(): List<User> {
    return listOf(
        User(
            Title(
                "EugeneKur", 10, R.drawable.ic_baseline_face_24,
                listOf("1", "2", "9", "9", "9", "8")
            ),
            "Описание"
        ),
        User(
            Title(
                "User2", 10, R.drawable.ic_baseline_face_24,
                listOf("2", "3", "5", "h", "x", "zth", "zgbn", "zdfb", "zd")
            ),
            "Описание"
        ),
        User(
            Title(
                "User3", 10, R.drawable.ic_baseline_face_24,
                listOf("fm", "xfg", "zdgh", "zfgn", "zfg", "zmn", "zgn", "zng", "zn")
            ), "Описание"
        ),
        User(
            Title(
                "User4", 10, R.drawable.ic_baseline_face_24,
                listOf("8", "7", "5", "4", "dk", "dtyk", "zng", "zgn", "zdfgn")
            ),
            "Описание"
        ),
        User(
            Title(
                "User5", 10, R.drawable.ic_baseline_face_24,
                listOf("8", "7", "5", "4", "dk", "dtyk", "zng", "zgn", "zdfgn")
            ), "Описание"
        ),
        User(
            Title(
                "User6", 10, R.drawable.ic_baseline_face_24,
                listOf("8", "7", "5", "4", "dk", "dtyk", "zng", "zgn", "zdfgn")
            ),
            "Описание"
        ),
        User(
            Title(
                "User7", 10, R.drawable.ic_baseline_face_24,
                listOf("8", "7", "5", "4", "dk", "dtyk", "zng", "zgn", "zdfgn")
            ),
            "Описание"
        ),
        User(
            Title(
                "User8", 10, R.drawable.ic_baseline_face_24,
                listOf("8", "7", "5", "4", "dk", "dtyk", "zng", "zgn", "zdfgn")
            ),
            "Описание"
        ),
    )
}

fun getProjectsUser(name: String): List<String> {
    val users: List<User> = getUsers()
    var projectsUser: List<String> = listOf()


    for (i in 1 until users.size) {
        if (users[i].title.name == name) {
            projectsUser = users[i].title.projects
        }
    }

    return projectsUser

}

