package com.gnova.stackexchange_userapp.api

import android.text.Editable
import com.gnova.stackexchange_userapp.api.models.UserResult
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class StackRepo @Inject constructor(private val stackApi: StackApi){

    fun getUsers(name: Editable): Deferred<UserResult> =
        stackApi.getUsers(
            1, 20, "asc", "name", name, "stackoverflow"
        )

}
