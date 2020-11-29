package com.gnova.stackexchange_userapp.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.gnova.stackexchange_userapp.App
import com.gnova.stackexchange_userapp.Const.USER
import com.gnova.stackexchange_userapp.R
import com.gnova.stackexchange_userapp.ViewModelFactory
import com.gnova.stackexchange_userapp.api.models.User
import com.gnova.stackexchange_userapp.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory<HomeViewModel>
    private lateinit var viewModel: HomeViewModel

    private val adapter: UserAdapter by lazy {
        UserAdapter(UserAdapter.OnClickListener {
            launchDetailActivity(it)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        search_button.setOnClickListener {
            viewModel.onSearchBtnClick(search_input.text);
        }

        setupRecyclerView()

        observeViewState()

    }

    private fun observeViewState() {
        viewModel.viewState.observe(this, Observer {
            when (it) {
                is HomeViewState.Presenting -> showUsers(it.user)
                is Error -> Log.d("TAG", "ERROR")
            }
        })
    }

    private fun showUsers(users: List<User>) {
        adapter.submitList(users)

    }

    private fun launchDetailActivity(selectedUser: User) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(USER, selectedUser)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        user_recycler_view.setHasFixedSize(true)
        user_recycler_view.layoutManager = GridLayoutManager(this, 1)
        user_recycler_view.adapter = adapter
    }


}