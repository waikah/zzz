package com.example.log_in_out.authentication.services

import com.example.log_in_out.authentication.dao.database.token.Token
import com.example.log_in_out.authentication.dao.database.token.TokenRepository
import com.example.log_in_out.authentication.dao.database.user.User
import com.example.log_in_out.authentication.dao.database.user.UserRepository
import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
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
                    if (BCrypt.checkpw(password, it.password)) {
                        // Generate Token
                        //The JWT signature algorithm we will be using to sign the token
//                        val signatureAlgorithm: SignatureAlgorithm = SignatureAlgorithm.HS256
//
//                        val nowMillis = System.currentTimeMillis()
//                        val now = Date(nowMillis)
//
//                        val random = Random()
//                        val secretKey: String = it.username.toString() + Integer.toString(random.nextInt(1000))
//
//                        val apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey)
//
//                        var signingKey: Key? = null
//                        try {
//                            signingKey = SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName())
//                        } catch (e: Exception) {
//                            println("Exception while generating key " + e.message)
//                        }
//
//                        val builder: JwtBuilder = Jwts.builder().setId(id)
//                                .setIssuedAt(now)
//                                .signWith(signatureAlgorithm, signingKey)
//
//                        //if it has been specified, let's add the expiration
//                        //if it has been specified, let's add the expiration
//                        if (ttlMillis >= 0) {
//                            val expMillis: Long = nowMillis + ttlMillis
//                            val exp = Date(expMillis)
//                            builder.setExpiration(exp)
//                        }
//
//                        val tokenInfo = arrayOf(builder.compact(), secretKey)
                        val uuid = UUID.randomUUID()

                        val token = Token(uuid.toString(), it.id)
                        tokenRepo.save(token)
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

    override fun signUpWithUsernameAndPassword(username: String, password: String): String {

        return if (!userRepo.findByUsername(username).isPresent) {
            val encryptedPassword: String = BCrypt.hashpw(password, BCrypt.gensalt())

            val user = User(0, username, encryptedPassword)
            userRepo.save(user)
            "Sign up successful"
        } else throw Exception("Username already in use, please try again!")

    }


}

