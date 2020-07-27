package com.gnova.stackexchange_userapp.ui.detail

import android.os.Parcelable
import com.gnova.stackexchange_userapp.api.models.User
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailModel (
    val user: User,
    val age: String,
    val userCreationDate: String
) : Parcelable