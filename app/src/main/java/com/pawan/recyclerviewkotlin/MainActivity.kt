package com.pawan.recyclerviewkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.pawan.recyclerviewkotlin.adapters.UserRvAdapter
import com.pawan.recyclerviewkotlin.databinding.ActivityMainBinding
import com.pawan.recyclerviewkotlin.model.Users

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    var usersList: List<Users>? = null
    var userAdapter: UserRvAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        usersList = ArrayList<Users>()
        (usersList as ArrayList<Users>).add(addUsers("Pawan", 18))
        (usersList as ArrayList<Users>).add(addUsers("Shahid", 28))
        (usersList as ArrayList<Users>).add(addUsers("Nilesh", 21))
        (usersList as ArrayList<Users>).add(addUsers("Ramesh", 25))
        (usersList as ArrayList<Users>).add(addUsers("Rajkumar", 22))
        userAdapter = UserRvAdapter(this, usersList as ArrayList<Users>)
        this.binding?.rvActivityMainUsers?.layoutManager = LinearLayoutManager(this)
        this.binding?.rvActivityMainUsers?.adapter = userAdapter


    }

    private fun addUsers(name: String, age: Int): Users {
        var users: Users = Users(name, age);
        return users;
    }
}
