package com.example.log_in_out.authentication.services


import com.example.log_in_out.authentication.dao.database.token.Token
import com.example.log_in_out.authentication.dao.database.token.TokenRepository
import com.example.log_in_out.authentication.dao.database.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*



@Service
class AuthenticationSignOut: AuthenticationService2 {
    @Autowired
    lateinit var tokenRepo2: TokenRepository

    @Autowired
    lateinit var userRepo2: UserRepository


    override fun signOut(authenticationToken: String, userId: Long): String {
        return tokenRepo2.findByAuthenticationToken(authenticationToken)
                .map {
                    if (it.userId == userId) {
                        //I should remove the token
                        val token2 = Token(it.authenticationToken,it.userId)
                        tokenRepo2.delete(token2)
                        return@map "Logout Successfully"

                    } else {
                        throw Exception("Logout fail")
                    }
                }
                .orElseThrow {
                    return@orElseThrow Exception("Token Invalid")
                }


    }
}