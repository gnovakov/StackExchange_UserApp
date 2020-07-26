package com.gnova.stackexchange_userapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gnova.stackexchange_userapp.App
import com.gnova.stackexchange_userapp.Const.USER
import com.gnova.stackexchange_userapp.R
import com.gnova.stackexchange_userapp.ViewModelFactory
import com.gnova.stackexchange_userapp.api.models.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory<DetailViewModel>
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

        intent.extras?.let {
            val user = it.get(USER) as User
            viewModel.onViewInit(user)
        }

        observeSelectedUser()

    }

    private fun observeSelectedUser() {
        viewModel.selectedUser.observe(this, Observer {
            it?.let {
                initialiseData(it)
            }
        })
    }

    private fun initialiseData(user: User) {
        Picasso.get().load(user.profile_image).into(avatar_img)
        user_name.text = user.display_name
        reputation.text = user.reputation.toString()
        gold_badges_count.text = user.badge_counts.gold.toString()
        silver_badges_count.text = user.badge_counts.silver.toString()
        bronze_badges_count.text = user.badge_counts.bronze.toString()
        location.text = user?.location ?: "N/a"
        account_age.text = "This account is " + elapsedTime(user).toString() + " years old"
        creation_date.text = creationDate(user)

    }

    fun creationDate( user: User) =
            SimpleDateFormat("dd-MM-yyyy")
            .format(Date(user.creation_date.toLong() * 1000))

    fun elapsedTime( user:User) =
        SimpleDateFormat("yyyy")
            .format(Date((System.currentTimeMillis() / 1000L)* 1000)).toLong() -
        SimpleDateFormat("yyyy")
            .format(Date(user.creation_date.toLong() * 1000)).toLong()




}