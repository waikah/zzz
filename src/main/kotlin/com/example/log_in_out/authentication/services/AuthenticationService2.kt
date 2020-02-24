package com.example.log_in_out.authentication.services

interface AuthenticationService2{
    fun signOut(username: String,password: Long): String
}