package ru.geekbrains.clientgithub.ui.cardUsers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.clientgithub.R
import ru.geekbrains.clientgithub.data.User

class GitProjectsAdapter : RecyclerView.Adapter<GitProjectsAdapter.RepoItemViewHolder>() {

    private var project: List<String> = listOf()
    var listener: OnItemClick? = null


    fun setProject(data: List<String>) {
        project = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoItemViewHolder {
        return RepoItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.repo_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RepoItemViewHolder, position: Int) {
        holder.bind(project[position])
    }

    override fun getItemCount(): Int = project.size

    fun interface OnItemClick {
        fun onClick(user: User)
    }

    inner class RepoItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(project: String) {
            itemView.findViewById<TextView>(R.id.name_repo_text_view).text = project
        }
    }

}