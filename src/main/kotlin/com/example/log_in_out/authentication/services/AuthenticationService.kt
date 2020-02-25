package com.example.log_in_out.authentication.services

interface AuthenticationService {
    fun signInWithUsernameAndPassword(username: String, password: String): String

    fun signOutWithToken(authenticationToken: String): String
}

