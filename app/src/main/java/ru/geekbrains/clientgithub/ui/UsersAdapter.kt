package ru.geekbrains.clientgithub.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.clientgithub.R
import ru.geekbrains.clientgithub.data.User

class UsersAdapter (private var items: List<User>) :
    RecyclerView.Adapter<UsersAdapter.UserItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        return UserItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.users_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {

        val user = items[position]

        holder.itemView.apply {
            findViewById<TextView>(R.id.name_user_item_text_view).text = user.title.name
            findViewById<ImageView>(R.id.user_item_image_view).setImageResource(user.title.image)
        }
    }

    override fun getItemCount(): Int =items.size

    inner class UserItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

}