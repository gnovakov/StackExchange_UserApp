package com.gnova.stackexchange_userapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gnova.stackexchange_userapp.api.StackRepo
import com.gnova.stackexchange_userapp.api.models.User
import javax.inject.Inject

class DetailViewModel @Inject constructor() : ViewModel() {

    fun onViewInit(user: User) {
        _selectedUser.value = user
    }

    // MutableLiveData that stores the selected user
    private val _selectedUser = MutableLiveData<User>()
    val selectedUser: LiveData<User>
        get() = _selectedUser

}