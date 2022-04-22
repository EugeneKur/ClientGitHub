package ru.geekbrains.clientgithub.ui.cardUsers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import ru.geekbrains.clientgithub.App
import ru.geekbrains.clientgithub.domain.Repository
import ru.geekbrains.clientgithub.utils.AppState
import ru.geekbrains.clientgithub.utils.BaseViewModel

class CardUserViewModel(override val id: String) : ViewModel(), CardContracts.ViewModelContract, BaseViewModel {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val repo: Repository = App().gitProjectsRepo

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getData(): LiveData<AppState> = liveDataToObserve

    override fun getProjectsRetrofit(name: String) {
        compositeDisposable.add(
            repo
                .getUserFromServer(name)
                .subscribeBy {
                liveDataToObserve.postValue(AppState.Success(it))
            }
        )
    }

    override fun getProjects(name: String) {
        liveDataToObserve.value = AppState.Loading
        val project = repo.getPojectsUsersFromLocalStorage(name)
        liveDataToObserve.postValue(AppState.Success(project))
    }

}

