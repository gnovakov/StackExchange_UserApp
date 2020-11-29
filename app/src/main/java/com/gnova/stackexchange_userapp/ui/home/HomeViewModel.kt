package com.gnova.stackexchange_userapp.ui.home

import android.text.Editable
import androidx.lifecycle.*
import com.gnova.stackexchange_userapp.StackApiStatus
import com.gnova.stackexchange_userapp.api.StackRepo
import com.gnova.stackexchange_userapp.api.models.User
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val stackRepo: StackRepo): ViewModel()  {

    // View State
    private val _viewState = MutableLiveData<HomeViewState>()
    val viewState: LiveData<HomeViewState>
        get() = _viewState

    fun onSearchBtnClick(name: Editable) {
        getUsers(name)
    }

    private fun getUsers(name: Editable) {
        _viewState.value = HomeViewState.Loading
        add(
            stackRepo.getUsers(name)
                .subscribe(
                    {
                        _viewState.value = HomeViewState.Presenting(it.items)
                    }, {
                        _viewState.value = HomeViewState.Error
                    }

                ))
    }

    val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    protected fun add(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun cleanUp() {
        compositeDisposable.clear()
    }

}