package com.example.log_in_out.authentication.services

interface AuthenticationLogInService {
    fun signInWithUsernameAndPassword(username: String, password: String): String
}

