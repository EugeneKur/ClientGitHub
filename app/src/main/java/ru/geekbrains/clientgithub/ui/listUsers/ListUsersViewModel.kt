package ru.geekbrains.clientgithub.ui.listUsers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.clientgithub.App
import ru.geekbrains.clientgithub.domain.Repository
import ru.geekbrains.clientgithub.utils.AppState
import ru.geekbrains.clientgithub.utils.BaseViewModel

class ListUsersViewModel(override val id: String, private val repository: Repository) : ViewModel(), UserContracts.ViewModelContract, BaseViewModel {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val repo: Repository = repository

    fun getData(): LiveData<AppState> = liveDataToObserve

    override fun getUser() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            Thread.sleep(1000)

            val user = repo.getUserFromLocalStorage()

            liveDataToObserve.postValue(AppState.Success(user))

        }.start()
    }

}