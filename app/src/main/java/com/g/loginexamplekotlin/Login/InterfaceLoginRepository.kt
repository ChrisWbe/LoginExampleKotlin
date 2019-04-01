package com.g.loginexamplekotlin.Login

import com.g.loginexamplekotlin.User

interface InterfaceLoginRepository {
    fun authentication(user: User, pass: String)
    fun createUser(user: User, pass: String)
    fun createUserDataBase(user: User)
}