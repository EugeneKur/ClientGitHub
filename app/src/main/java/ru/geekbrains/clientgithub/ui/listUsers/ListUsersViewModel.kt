package ru.geekbrains.clientgithub.ui.listUsers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.clientgithub.data.RepositoryImpl
import ru.geekbrains.clientgithub.domain.Repository
import ru.geekbrains.clientgithub.utils.AppState

class ListUsersViewModel : ViewModel(), UserContracts.ViewModelContract {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val repo: Repository = RepositoryImpl()

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