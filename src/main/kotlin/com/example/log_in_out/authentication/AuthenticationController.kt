package com.example.log_in_out.authentication

import com.example.log_in_out.authentication.dao.TokenStoringPostRequest
import com.example.log_in_out.authentication.dao.UserLoginPostRequest
import com.example.log_in_out.authentication.services.AuthenticationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.servlet.function.RequestPredicates.contentType
import java.io.IOException

@RestController
@CrossOrigin(origins = ["http://localhost:4200"], allowedHeaders = ["*"])
@RequestMapping("/api/v1/auth")
class AuthenticationController {
    @Autowired
    lateinit var authenticationService: AuthenticationService

    @PostMapping("/login")
    fun signIn(@RequestBody userDetail: UserLoginPostRequest): ResponseEntity<String> {
        val token: String
        return try {
            token = authenticationService.signInWithUsernameAndPassword(userDetail.username, userDetail.password)

            ResponseEntity.ok().header("token", token).contentType(MediaType.APPLICATION_JSON).body(token)
        } catch (e: Exception) {
            ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(e.message.toString())
        }
        //return ResponseEntity.ok(token)
    }

    @PostMapping("/logout")
    fun signOut(@RequestBody tokenDetail: TokenStoringPostRequest): ResponseEntity<String> {
        val signOutMsg: String
        return try {
            signOutMsg = authenticationService.signOutWithToken(tokenDetail.authenticationToken)

            ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(signOutMsg)
        } catch (e: Exception) {
            ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(e.message.toString())
        }
    }

    @PostMapping("/signUp")
    fun signOut(@RequestBody userDetail: UserLoginPostRequest): ResponseEntity<String> {
        val signOutMsg: String
        return try {
            signOutMsg = authenticationService.signUpWithUsernameAndPassword(userDetail.username, userDetail.password)

            ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(signOutMsg)
        } catch (e: Exception) {
            ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(e.message.toString())
        }
    }
}
