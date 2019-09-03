package com.pawan.recyclerviewkotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pawan.recyclerviewkotlin.databinding.ListitemUserBinding
import com.pawan.recyclerviewkotlin.model.Users


class UserRvAdapter : RecyclerView.Adapter<UserRvAdapter.UserViewHolder> {

    var context: Context? = null
    var userList: ArrayList<Users>? = null

    constructor(context: Context?, userList: ArrayList<Users>?) : super() {
        this.context = context
        this.userList = userList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var infaltor: LayoutInflater = LayoutInflater.from(parent.context)
        var itemBinding: ListitemUserBinding = ListitemUserBinding.inflate(infaltor, parent, false)
        return UserViewHolder(itemBinding);
    }

    override fun getItemCount(): Int {
        return userList!!.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: Users = userList!!.get(position);
        holder.bind(user)
    }

    class UserViewHolder : RecyclerView.ViewHolder {
        var itemBinding: ListitemUserBinding? = null

        constructor(itemBinding: ListitemUserBinding?) : super(itemBinding!!.root) {
            this.itemBinding = itemBinding
        }


        fun bind(user: Users) {
            itemBinding?.setVariable(1,user)
            itemBinding?.executePendingBindings()
        }
    }
}