package com.example.log_in_out.authentication.services

import com.example.log_in_out.authentication.dao.database.token.Token
import com.example.log_in_out.authentication.dao.database.token.TokenRepository
import com.example.log_in_out.authentication.dao.database.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*

@Service
class AuthenticationServiceImpl : AuthenticationService {
    @Autowired
    lateinit var userRepo: UserRepository

    @Autowired
    lateinit var tokenRepo: TokenRepository

    override fun signInWithUsernameAndPassword(username: String, password: String): String {
        return userRepo.findByUsername(username)
                .map {
                    if (it.password == password) {
                        // Generate Token
                        val uuid = UUID.randomUUID()

                        val token1 = Token(uuid.toString(), it.id)
                        tokenRepo.save(token1)
                        return@map uuid.toString()
                    } else {
                        throw Exception("Wrong password")
                    }
                }.orElseThrow {
                    return@orElseThrow Exception("Wrong Username")
                }
    }

    override fun signOutWithToken(authenticationToken: String): String {
        return tokenRepo.findByAuthenticationToken(authenticationToken)
                .map {
                    //I should remove the token
                    val token = Token(it.authenticationToken, it.userId)
                    tokenRepo.delete(token)

                    return@map "Logout Successfully"
                }
                .orElseThrow {
                    return@orElseThrow Exception("Invalid Token")
                }
    }
}

