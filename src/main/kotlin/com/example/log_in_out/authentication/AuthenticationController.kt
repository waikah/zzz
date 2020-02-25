package com.example.log_in_out.authentication

import com.example.log_in_out.authentication.dao.TokenStoringPostRequest
import com.example.log_in_out.authentication.dao.UserLoginPostRequest
import com.example.log_in_out.authentication.services.AuthenticationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin(origins = ["http://localhost:4200"], allowedHeaders = ["*"])
@RequestMapping("/api/v1/auth")
class AuthenticationController {
    @Autowired
    lateinit var authenticationService: AuthenticationService

    @PostMapping("/login")
    fun signIn(@RequestBody userDetail: UserLoginPostRequest): ResponseEntity<String> {
        val token: String
        token = try {
            authenticationService.signInWithUsernameAndPassword(userDetail.username, userDetail.password)
            //val httpHeader = HttpHeaders()

            //httpHeader.addHeader("Access-Control-Expose-Headers", "Authorization");
            //httpHeader.add("Authorization", token)
        } catch (e: Exception) {
            e.message.toString()
        }

        return ResponseEntity.ok(token)
        //return ResponseEntity.ok().header("Authorization", token).build()
    }

    @PostMapping("/logout")
    fun signOut(@RequestBody tokenDetail: TokenStoringPostRequest): ResponseEntity<String> {
        val signOutMsg: String
        signOutMsg = try {
            authenticationService.signOutWithToken(tokenDetail.authenticationToken)
        } catch (e: Exception) {
            e.message.toString()
        }
        return ResponseEntity.ok(signOutMsg)
    }
}
