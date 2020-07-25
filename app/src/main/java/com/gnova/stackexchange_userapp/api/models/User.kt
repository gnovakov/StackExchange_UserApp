package com.gnova.stackexchange_userapp.api.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserResult(
    val has_more: Boolean,
    val items: List<User>,
    val quota_max: Int,
    val quota_remaining: Int
) : Parcelable

@Parcelize
data class User(
    val account_id: Int,
    val badge_counts: BadgeCounts,
    val creation_date: Int,
    val display_name: String,
    val is_employee: Boolean,
    val last_access_date: Int,
    val last_modified_date: Int,
    val link: String,
    val location: String,
    val profile_image: String,
    val reputation: Int,
    val reputation_change_day: Int,
    val reputation_change_month: Int,
    val reputation_change_quarter: Int,
    val reputation_change_week: Int,
    val reputation_change_year: Int,
    val user_id: Int,
    val user_type: String
) : Parcelable

@Parcelize
data class BadgeCounts(
    val bronze: Int,
    val gold: Int,
    val silver: Int
) : Parcelable
