package com.example.log_in_out.authentication

import com.example.log_in_out.authentication.dao.TokenStoringPostRequest
import com.example.log_in_out.authentication.dao.UserLoginPostRequest
import com.example.log_in_out.authentication.services.AuthenticationService
import com.example.log_in_out.authentication.services.AuthenticationService2
import com.example.log_in_out.authentication.services.AuthenticationServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthenticationController {
    @Autowired
    lateinit var authenticationService: AuthenticationService
    @Autowired
    lateinit var authenticationService2: AuthenticationService2

    @PostMapping("/login")
    fun signIn(@RequestBody userDetail: UserLoginPostRequest): ResponseEntity<String> {
        val token = authenticationService.signInWithUsernameAndPassword(userDetail.username, userDetail.password)
        return ResponseEntity.ok(token)
    }

    @PostMapping("/logout")
    fun signOutrequest(@RequestBody tokenDetail: TokenStoringPostRequest): ResponseEntity<String> {
        val token1 = authenticationService2.signOut(tokenDetail.authenticationToken, tokenDetail.userId)
        return ResponseEntity.ok(token1)
    }
}