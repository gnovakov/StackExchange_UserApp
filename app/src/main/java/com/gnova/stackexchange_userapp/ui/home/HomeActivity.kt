package com.gnova.stackexchange_userapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gnova.stackexchange_userapp.App
import com.gnova.stackexchange_userapp.R
import com.gnova.stackexchange_userapp.StackApiStatus
import com.gnova.stackexchange_userapp.ViewModelFactory
import com.gnova.stackexchange_userapp.api.models.User
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory<HomeViewModel>
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        observeApiStatus()

    }

    private fun observeApiStatus() {
        viewModel.apiStatus.observe(this, Observer {
            it?.let {
                when (it) {
                    StackApiStatus.LOADING -> {
                        Log.d("TAG", "LOADING")
                    }
                    StackApiStatus.ERROR -> {
                        Log.d("TAG", "ERROR")
                    }
                    StackApiStatus.DONE -> {
                        Log.d("TAG", "DONE")
                        observeUsers()
                    }

                }
            }
        })
    }

    private fun observeUsers() {
        viewModel.users.observe(this, Observer {
            it?.let {
                showUsers(it)
            }
        })
    }

    private fun showUsers(users: List<User>) {
        Log.d("TAG", users[0].display_name)

    }
}