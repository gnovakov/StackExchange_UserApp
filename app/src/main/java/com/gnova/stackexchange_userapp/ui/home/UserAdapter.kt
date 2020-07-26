package com.gnova.stackexchange_userapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gnova.stackexchange_userapp.R
import com.gnova.stackexchange_userapp.api.models.User
import kotlinx.android.synthetic.main.user_grid_view_item.view.*

class UserAdapter(private val onClickListener: OnClickListener) : ListAdapter<User, UserAdapter.UserHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_grid_view_item, parent, false)
        return UserHolder(view)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val users = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(users)
        }
        holder.bind(users)
    }

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {

            itemView.userId.text = user.user_id.toString()
            itemView.userName.text = user.display_name

        }

    }

    companion object DiffCallback : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.user_id == newItem.user_id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    class OnClickListener(val clickListener: (user: User) -> Unit) {
        fun onClick(user: User) = clickListener(user)
    }

}