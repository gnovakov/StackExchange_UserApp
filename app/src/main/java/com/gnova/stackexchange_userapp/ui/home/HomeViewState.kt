package com.gnova.stackexchange_userapp.ui.home

import com.gnova.stackexchange_userapp.api.models.User

sealed class HomeViewState {

    data class Presenting( val user: List<User> ) : HomeViewState()

    object Error : HomeViewState()

    object Loading : HomeViewState()
}