package com.example.log_in_out.authentication.dao.database.user

import com.example.log_in_out.authentication.dao.database.user.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository : CrudRepository<User, Long> {
    fun findByUsername(username: String): Optional<User>
}
