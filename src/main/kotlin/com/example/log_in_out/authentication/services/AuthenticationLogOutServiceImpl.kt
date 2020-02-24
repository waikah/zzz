package com.example.log_in_out.authentication.services


import com.example.log_in_out.authentication.dao.database.token.Token
import com.example.log_in_out.authentication.dao.database.token.TokenRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception


@Service
class AuthenticationLogOutServiceImpl: AuthenticationLogOutService {
    @Autowired
    lateinit var tokenRepo: TokenRepository

    override fun signOutWithToken(authenticationToken: String): String {
        return tokenRepo.findByAuthenticationToken(authenticationToken)
                .map {
                    //I should remove the token
                    val token = Token(it.authenticationToken, it.userId)
                    tokenRepo.delete(token)

                    return@map "Logout Successfully"
                }
                .orElseThrow {
                    return@orElseThrow Exception("Token Invalid")
                }
    }
}
