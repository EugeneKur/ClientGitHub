package ru.geekbrains.clientgithub.ui.listUsers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.clientgithub.R
import ru.geekbrains.clientgithub.data.User
import ru.geekbrains.clientgithub.databinding.UsersItemLayoutBinding

class UsersAdapter : RecyclerView.Adapter<UserItemViewHolder>() {

    private var user: List<User> = listOf()
    var listener: OnItemClick? = null



    fun setUser(data: List<User>) {
        user = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserItemViewHolder.createView(parent)

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        listener?.let { holder.bind(user[position], it) }
    }

    override fun getItemCount(): Int = user.size

    fun interface OnItemClick {
        fun onClick(user: User)
    }

//    inner class UserItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        private val binding = UsersItemLayoutBinding.bind(view)
//
//        fun bind(user: User) {
//            binding.nameUserItemTextView.text = user.title.name
//            binding.userItemImageView.setImageResource(user.title.image)
//            binding.root.setOnClickListener {
//                listener?.onClick(user)
//            }
//
////            itemView.findViewById<TextView>(R.id.name_user_item_text_view).text = user.title.name
////            itemView.findViewById<ImageView>(R.id.user_item_image_view)
////                .setImageResource(user.title.image)
////            itemView.setOnClickListener {
////                listener?.onClick(user)
////            }
//        }
//    }

}