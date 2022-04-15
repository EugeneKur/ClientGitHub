package ru.geekbrains.clientgithub.ui.listUsers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.clientgithub.R
import ru.geekbrains.clientgithub.data.User

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UserItemViewHolder>() {

    private var user: List<User> = listOf()
    var listener: OnItemClick? = null


    fun setUser(data: List<User>) {
        user = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        return UserItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.users_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        holder.bind(user[position])
    }

    override fun getItemCount(): Int = user.size

    fun interface OnItemClick {
        fun onClick(user: User)
    }

    inner class UserItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(user: User) {
            itemView.findViewById<TextView>(R.id.name_user_item_text_view).text = user.title.name
            itemView.findViewById<ImageView>(R.id.user_item_image_view)
                .setImageResource(user.title.image)
            itemView.setOnClickListener {
                listener?.onClick(user)
            }
        }
    }

}