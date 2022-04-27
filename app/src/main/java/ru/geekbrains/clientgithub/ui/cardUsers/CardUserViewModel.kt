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

class CardUserViewModel(override val id: String, private val repository: Repository) : ViewModel(), CardContracts.ViewModelContract, BaseViewModel {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val repo: Repository = repository

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getData(): LiveData<AppState> = liveDataToObserve

    override fun getProjectsRetrofit(name: String) {
        compositeDisposable.add(
            repo
                .getProjectsUserFromServer(name)
                .subscribeBy {
                liveDataToObserve.postValue(AppState.Success(it))
            }
        )
    }

}

