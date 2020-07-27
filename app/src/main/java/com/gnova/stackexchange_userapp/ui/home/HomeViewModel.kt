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

    // The most recent API response
    private val _apiStatus = MutableLiveData<StackApiStatus>()
    val apiStatus: LiveData<StackApiStatus>
        get() = _apiStatus

    // A User
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>>
        get() = _users

    
    fun onSearchBtnClick(name: Editable) {
        getUsers(name)
    }

    private fun getUsers(name: Editable) {
        // Using Rx
        add(stackRepo.getUsers(name).subscribe(
            {
                _apiStatus.value = StackApiStatus.LOADING
                _users.value = it.items
                _apiStatus.value = StackApiStatus.DONE
            }, {
                _apiStatus.value = StackApiStatus.ERROR
                _users.value = ArrayList()
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