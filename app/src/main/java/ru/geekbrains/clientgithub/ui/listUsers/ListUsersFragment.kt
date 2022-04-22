package ru.geekbrains.clientgithub.ui.listUsers

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.geekbrains.clientgithub.data.User
import ru.geekbrains.clientgithub.databinding.ListUsersFragmentBinding
import ru.geekbrains.clientgithub.utils.AppState

class ListUsersFragment : Fragment() {


    private var _binding: ListUsersFragmentBinding? = null
    private val binding get() = _binding!!
    private val adapter = UsersAdapter { user ->
        controller.openScreen(user)
    }

    private lateinit var viewModel: ListUsersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ListUsersFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity !is Controller) {
            throw IllegalStateException("Activity должна наследоваться от ColorListFragment.Controller")
        }
    }

    private val controller by lazy { activity as Controller }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.usersRecyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(ListUsersViewModel::class.java)
        // Подписались на изменения liveData
        viewModel.getData().observe(viewLifecycleOwner, { state ->
            render(state)
        })

        // Запросили новые данные
        viewModel.getUser()
    }

    private fun render(state: AppState) {
        when (state) {
            is AppState.Success<*> -> {

                val user: List<User> = state.data as List<User>
                adapter.setUser(user)
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

    interface Controller {
        fun openScreen(user: User)
    }

}