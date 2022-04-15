package ru.geekbrains.clientgithub.ui.cardUsers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.clientgithub.data.RepositoryImpl
import ru.geekbrains.clientgithub.data.User
import ru.geekbrains.clientgithub.domain.Repository
import ru.geekbrains.clientgithub.utils.AppState

class CardUserViewModel : ViewModel(), CardContracts.ViewModelContract {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val repo: Repository = RepositoryImpl()

    fun getData(): LiveData<AppState> = liveDataToObserve

    override fun getProjects(user: User) {
        liveDataToObserve.value = AppState.Loading
            val project = repo.getPojectsUsersFromLocalStorage(user)
            liveDataToObserve.postValue(AppState.Success(project))
    }

}