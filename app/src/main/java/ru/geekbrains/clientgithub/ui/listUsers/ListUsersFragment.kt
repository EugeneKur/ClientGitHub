package ru.geekbrains.clientgithub.ui.listUsers

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
//import org.koin.android.ext.android.inject
import ru.geekbrains.clientgithub.app
import ru.geekbrains.clientgithub.data.User
import ru.geekbrains.clientgithub.databinding.ListUsersFragmentBinding
import ru.geekbrains.clientgithub.domain.Repository
import ru.geekbrains.clientgithub.utils.AppState
import java.util.*
import javax.inject.Inject

class ListUsersFragment : Fragment() {

    private val keyViewModelId = "key_view_model"
    private var _binding: ListUsersFragmentBinding? = null
    private val binding get() = _binding!!
    private val adapter = UsersAdapter { user ->
        controller.openScreen(user)
    }
    @Inject
    lateinit var repo: Repository
//    private val repo: Repository by inject()

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

        app.appDependenciesComponent.injectList(this)

        binding.usersRecyclerView.adapter = adapter

        if (savedInstanceState != null) {
            val viewModelId = savedInstanceState.getString(keyViewModelId)!!
            viewModel = app.viewModelStore.getViewModel(viewModelId) as ListUsersViewModel
        } else {
            val id = UUID.randomUUID().toString()
            viewModel = ListUsersViewModel(id, repo)
            app.viewModelStore.saveViewModel(viewModel)
        }
// Подписались на изменения liveData
        viewModel.getData().observe(viewLifecycleOwner, { state ->
            render(state)
        })
        // Запросили новые данные
        viewModel.getUser()


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(keyViewModelId, viewModel.id)
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