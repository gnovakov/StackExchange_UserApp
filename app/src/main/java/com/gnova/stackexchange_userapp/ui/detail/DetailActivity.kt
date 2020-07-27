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

    private fun initialiseData(model: DetailModel) {
        Picasso.get().load(model.user.profile_image).into(avatar_img)
        user_name_detail.text = model.user.display_name
        reputation_detail.text = model.user.reputation.toString()
        gold_badges_count.text = model.user.badge_counts.gold.toString()
        silver_badges_count.text = model.user.badge_counts.silver.toString()
        bronze_badges_count.text = model.user.badge_counts.bronze.toString()
        location.text = model.user.location ?: "N/a"
        account_age.text = model.age
        creation_date.text = model.userCreationDate
    }

}