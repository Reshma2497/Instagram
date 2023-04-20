package com.vipulasri.jetinstagram.data

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.vipulasri.jetinstagram.data.PostsRepository.posts
import com.vipulasri.jetinstagram.model.Post
import com.vipulasri.jetinstagram.model.User
import com.vipulasri.jetinstagram.model.names

object FavouritesRepository {
    private val _users = mutableStateOf<List<User>>(emptyList())
    val favUsers: State<List<User>> = _users
    private fun populateUsers() {
        val users = ArrayList<User>()
        (0..9).forEach { index ->
            val user = User(



                    name = names[index],
                    username = names[index],
                    image = "https://randomuser.me/api/portraits/men/${index+1}.jpg"
            )
            users.add(user)
        }

        this._users.value = users
    }
    init {
        populateUsers()
    }




}