package com.gnova.stackexchange_userapp

import java.text.DateFormat.MEDIUM
import java.text.DateFormat.getDateInstance
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class Dates @Inject constructor(){

    fun creationDate(long: Long) =
        getDateInstance(MEDIUM)
            .format(Date(long * 1000))

    fun elapsedTime(long: Long) =
        SimpleDateFormat("yyyy", Locale.getDefault())
            .format(Date((System.currentTimeMillis() / 1000L)* 1000)).toLong() -
                SimpleDateFormat("yyyy", Locale.getDefault())
                    .format(Date(long * 1000)).toLong()
}