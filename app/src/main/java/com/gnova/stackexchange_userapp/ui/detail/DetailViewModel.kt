package com.gnova.stackexchange_userapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gnova.stackexchange_userapp.Dates
import com.gnova.stackexchange_userapp.api.StackRepo
import com.gnova.stackexchange_userapp.api.models.User
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val dateHelper: Dates) : ViewModel() {

    // MutableLiveData that stores the selected user
    private val _selectedUser = MutableLiveData<DetailModel>()
    val selectedUser: LiveData<DetailModel>
        get() = _selectedUser

    fun onViewInit(user: User) {
        editData(user)
    }

    private fun editData(user: User) {


        val age = "This account is " + dateHelper.elapsedTime(user.creation_date.toLong()).toString() + " years old"
        val userCreationDate = dateHelper.creationDate(user.creation_date.toLong())

        val detailModel = DetailModel(user, age, userCreationDate)

        _selectedUser.value = detailModel


    }


}