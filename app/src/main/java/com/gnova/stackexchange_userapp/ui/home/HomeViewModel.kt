package com.gnova.stackexchange_userapp.ui.home

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gnova.stackexchange_userapp.StackApiStatus
import com.gnova.stackexchange_userapp.api.StackRepo
import com.gnova.stackexchange_userapp.api.models.User
import kotlinx.coroutines.launch
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

    /*init {
        getUsers()
    }*/

    fun getUsers(name: Editable) {
        // Using Coroutines
        viewModelScope.launch {
            var getUsersDeferred = stackRepo.getUsers(name)
            try {
                _apiStatus.value = StackApiStatus.LOADING
                var apiResult = getUsersDeferred.await()
                _apiStatus.value = StackApiStatus.DONE
                _users.value = apiResult.items
            } catch (e: Exception) {
                _apiStatus.value = StackApiStatus.ERROR
                _users.value = ArrayList()
            }
        }
    }

}