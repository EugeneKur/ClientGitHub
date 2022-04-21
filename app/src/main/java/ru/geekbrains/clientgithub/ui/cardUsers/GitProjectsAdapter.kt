package ru.geekbrains.clientgithub.ui.cardUsers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.clientgithub.R
import ru.geekbrains.clientgithub.databinding.RepoItemLayoutBinding
import ru.geekbrains.clientgithub.domain.GitProjectEntity

class GitProjectsAdapter : RecyclerView.Adapter<GitProjectsAdapter.RepoItemViewHolder>() {

    private var project: List<GitProjectEntity> = listOf()

    fun setProject(data: List<GitProjectEntity>) {
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

    inner class RepoItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RepoItemLayoutBinding.bind(view)

        fun bind(project: GitProjectEntity) {
            binding.nameRepoTextView.text = project.name
        }
    }

}