package me.tabraiz.learn.kotlin.coroutines.data.api

import me.tabraiz.learn.kotlin.coroutines.data.model.ApiUser

interface ApiHelper {

    suspend fun getUsers(): List<ApiUser>

    suspend fun getMoreUsers(): List<ApiUser>

    suspend fun getUsersWithError(): List<ApiUser>

}