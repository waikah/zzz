package com.example.log_in_out.authentication.dao.database.token

import org.springframework.data.repository.CrudRepository
import java.util.*

interface TokenRepository : CrudRepository<Token, Long> {
    fun findByAuthenticationToken(authenticationToken: String): Optional<Token>
}
