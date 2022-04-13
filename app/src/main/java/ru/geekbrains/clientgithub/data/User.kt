package ru.geekbrains.clientgithub.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import ru.geekbrains.clientgithub.R

@Parcelize
data class User (
    val title: Title = getDefaultTitle(),
    val about: String = "Описание пользователя"
): Parcelable

@Parcelize
data class Title(
    val name: String = "User",
    val rating: Int = 0,
    val image: Int = R.drawable.ic_baseline_face_24
): Parcelable

fun getDefaultTitle() = Title("User", 10, R.drawable.ic_baseline_face_24)

fun getUsers(): List<User> {
    return listOf(
        User(Title("User1", 10, R.drawable.ic_baseline_face_24), "Описание"),
        User(Title("User2", 10, R.drawable.ic_baseline_face_24), "Описание"),
        User(Title("User3", 10, R.drawable.ic_baseline_face_24), "Описание"),
        User(Title("User4", 10, R.drawable.ic_baseline_face_24), "Описание"),
        )
}

