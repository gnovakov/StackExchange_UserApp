package com.gnova.stackexchange_userapp.api

import android.text.Editable
import com.gnova.stackexchange_userapp.api.models.UserResult
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StackRepo @Inject constructor(private val stackApi: StackApi){

    fun getUsers(name: Editable): Single<UserResult> =
        stackApi.getUsers(
            1, 20, "asc", "name", name, "stackoverflow"
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}
