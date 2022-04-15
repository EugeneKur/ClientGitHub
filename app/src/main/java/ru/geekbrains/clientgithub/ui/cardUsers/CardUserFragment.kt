package ru.geekbrains.clientgithub.ui.cardUsers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.geekbrains.clientgithub.data.User
import ru.geekbrains.clientgithub.databinding.CardUserFragmentBinding
import ru.geekbrains.clientgithub.ui.listUsers.ListUsersViewModel
import ru.geekbrains.clientgithub.utils.AppState

class CardUserFragment : Fragment() {
    companion object {
        fun newInstance(bundle: Bundle?): CardUserFragment {
            val fragment = CardUserFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var _binding: CardUserFragmentBinding? = null
    private val binding get() = _binding!!
    private val adapter = GitProjectsAdapter()

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

        viewModel = ViewModelProvider(this).get(CardUserViewModel::class.java)

        // Подписались на изменения liveData
        viewModel.getData().observe(viewLifecycleOwner, { state ->
            render(state)
        })

        // Запросили новые данные
        user?.let { viewModel.getProjects(it) }
//        val project: List<String> = user?.title?.projects as List<String>
//
//        binding.projectsRecyclerView.adapter = adapter
//
//        adapter.setProject(project)


    }

    private fun render(state: AppState) {

        when (state) {
            is AppState.Success<*> -> {

                val project: List<String> = state.data as List<String>
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