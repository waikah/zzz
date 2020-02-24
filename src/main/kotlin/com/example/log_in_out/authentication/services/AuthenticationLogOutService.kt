package com.example.log_in_out.authentication.services

interface AuthenticationLogOutService{
    fun signOutWithToken(authenticationToken: String): String
}
