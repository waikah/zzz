package com.example.log_in_out.authentication

import com.example.log_in_out.authentication.dao.TokenStoringPostRequest
import com.example.log_in_out.authentication.dao.UserLoginPostRequest
import com.example.log_in_out.authentication.services.AuthenticationLogInService
import com.example.log_in_out.authentication.services.AuthenticationLogOutService
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
    lateinit var authenticationService: AuthenticationLogInService
    @Autowired
    lateinit var authenticationLogOutService: AuthenticationLogOutService

    @PostMapping("/login")
    fun signIn(@RequestBody userDetail: UserLoginPostRequest): ResponseEntity<String> {
        val token = authenticationService.signInWithUsernameAndPassword(userDetail.username, userDetail.password)
        return ResponseEntity.ok(token)
    }

    @PostMapping("/logout")
    fun signOut(@RequestBody tokenDetail: TokenStoringPostRequest): ResponseEntity<String> {
        val signOutMsg = authenticationLogOutService.signOutWithToken(tokenDetail.authenticationToken)
        return ResponseEntity.ok(signOutMsg)
    }
}
