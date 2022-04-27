package ru.geekbrains.clientgithub.ui.cardUsers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject
import ru.geekbrains.clientgithub.app
import ru.geekbrains.clientgithub.data.User
import ru.geekbrains.clientgithub.databinding.CardUserFragmentBinding
import ru.geekbrains.clientgithub.domain.GitProjectEntity
import ru.geekbrains.clientgithub.domain.Repository
import ru.geekbrains.clientgithub.utils.AppState
import java.util.*

class CardUserFragment : Fragment() {

    companion object {
        private const val USER_ARGS_KEY = "USER"
        fun newInstance(user: User) = CardUserFragment().apply {
            arguments = Bundle()
            arguments?.putParcelable(USER_ARGS_KEY, user)
        }
    }

    private val keyViewModelId = "key_card_view_model"
    private var _binding: CardUserFragmentBinding? = null
    private val binding get() = _binding!!
    private val adapter = GitProjectsAdapter()
    private var name: String = ""
    private val repo: Repository by inject()

    private lateinit var viewModel: CardUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CardUserFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = arguments?.getParcelable<User>("USER")
        binding.nameUserTextView.text = user?.title?.name ?: ""
        user?.title?.image?.let { binding.userImageView.setImageResource(it) }

        binding.projectsRecyclerView.adapter = adapter

        if (savedInstanceState != null) {
            val viewModelId = savedInstanceState.getString(keyViewModelId)!!
            viewModel = app.viewModelStore.getViewModel(viewModelId) as CardUserViewModel
        } else {
            val id = UUID.randomUUID().toString()
            viewModel = CardUserViewModel(id, repo)
            app.viewModelStore.saveViewModel(viewModel)
        }
        // Подписались на изменения liveData
        viewModel.getData().observe(viewLifecycleOwner, { state ->
            render(state)
        })

        name = user?.title?.name.toString()
        // Запросили новые данные
        viewModel.getProjectsRetrofit(name)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(keyViewModelId, viewModel.id)
    }

    private fun render(state: AppState) {
        when (state) {
            is AppState.Success<*> -> {
                val project: List<GitProjectEntity> = state.data as List<GitProjectEntity>
                adapter.setProject(project)
            }
            is AppState.Error -> {
                // TODO: 14.04.2022
            }
            is AppState.Loading -> {
                // TODO: 14.04.2022
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}