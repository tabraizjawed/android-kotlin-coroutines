package me.tabraiz.learn.kotlin.coroutines.data.local

import me.tabraiz.learn.kotlin.coroutines.data.local.entity.User

interface DatabaseHelper {

    suspend fun getUsers(): List<User>

    suspend fun insertAll(users: List<User>)

}